package Classes;
import java.util.*;


/**
 * Klasa odpowiedzialna za obsługę szybkiej transformaty Fouriera
 * żródło: https://introcs.cs.princeton.edu/java/97data/FFT.java.html
 */
public class FFT
{
    // compute the FFT of x[], assuming its length n is a power of 2

    /**
     * Metoda służy do obliczania szybkiej transformaty Fouriera
     * @param x Liczby do konwersji
     * @return Tablica wyników FFT
     */
    public static Complex[] fft(Complex[] x)
    {
        int n = x.length;

        // base case
        if (n == 1) return new Complex[]{x[0]};

        // radix 2 Cooley-Tukey FFT
        if (n % 2 != 0) {
            throw new IllegalArgumentException("n is not a power of 2");
        }

        // compute FFT of even terms
        Complex[] even = new Complex[n / 2];
        for (int k = 0; k < n / 2; k++) {
            even[k] = x[2 * k];
        }
        Complex[] evenFFT = fft(even);

        // compute FFT of odd terms
        Complex[] odd = even;  // reuse the array (to avoid n log n space)
        for (int k = 0; k < n / 2; k++) {
            odd[k] = x[2 * k + 1];
        }
        Complex[] oddFFT = fft(odd);

        // combine
        Complex[] y = new Complex[n];
        for (int k = 0; k < n / 2; k++) {
            double kth = -2 * k * Math.PI / n;
            Complex wk = new Complex(Math.cos(kth), Math.sin(kth));
            y[k] = evenFFT[k].plus(wk.times(oddFFT[k]));
            y[k + n / 2] = evenFFT[k].minus(wk.times(oddFFT[k]));
        }
        return y;
    }
  
  //
  // Methods
  //

    /**
     * Metoda służy do obliczania odwrotnej transformaty Fouriera
     * @param x Liczby do konwersji
     * @return Tablica wyników odwrotnej transformaty Fouriera
     */
    public static Complex[] ifft(Complex[] x) {
        int n = x.length;
        Complex[] y = new Complex[n];

        // take conjugate
        for (int i = 0; i < n; i++) {
            y[i] = x[i].conjugate();
        }

        // compute forward FFT
        y = fft(y);

        // take conjugate again
        for (int i = 0; i < n; i++) {
            y[i] = y[i].conjugate();
        }

        // divide by n
        for (int i = 0; i < n; i++) {
            y[i] = y[i].scale(1.0 / n);
        }

        return y;
    }

}
