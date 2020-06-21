package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Klasa zawierająca metody służące do budowy spektrogramu
 */
public class Spektrogram {
    /**
     * Metoda korzystając z FFT oblicza dane potrzebne do budowy spektrogramu
     * @param nazwaPliku
     * @param okna - wybór czy okna niezależne (1) czy zazębiające się w połowie (2)
     * @param ilePróbekOkno - liczba próbek dla jednego okna (np 1024, 2048)
     * @return dwuwymiarowa tablica z danymi
     */
    public static double[][] ObliczDaneDlaSpektrogramu(String nazwaPliku, int okna, int ilePróbekOkno) {

        PlikWave plik = new PlikWave(nazwaPliku);
        plik.OtwórzIstniejącyPlik();

        double[][] dane;
        long fsamp = plik.getCzęstotliwośćPróbkowania();
        long ilePróbek = plik.getLiczbęPróbek();
        int ileDoFFT = ilePróbekOkno;
        int ileOkien = (int)(ilePróbek/ileDoFFT);
        //System.out.println(ilePróbek + " " + ileDoFFT + " " + ileOkien);
        int m = plik.getLiczbęBitów(); // liczba bitów na próbke (M = 8 bitów)
        double maxWartość = Math.pow(2,m-1); // dla 8 bitów = 128
        int nakładanieSieOkien = okna;
        dane = new double[ileOkien*nakładanieSieOkien][ileDoFFT];
        int indexPróbki = 0;
        int licznik = 0;

        while (indexPróbki + ileDoFFT < ilePróbek) {
            byte[] probki = plik.PobierzKilkaPróbek(indexPróbki, ileDoFFT);

            indexPróbki += ileDoFFT/nakładanieSieOkien;

            // podział na kanały
            Complex[] zespoloneL = new Complex[ileDoFFT];
            //System.out.println(zespoloneL.length);
            int licznikL = 0;
            for (int i = 0; i < probki.length; i++) {
                if (i % 2 == 0) {
                    Complex x = new Complex(probki[i]/maxWartość, 0);
                    zespoloneL[licznikL] = x;
                    licznikL++;
                }
            }

            // obliczanie FFT dla lewego kanału
            Complex[] fftL = FFT.fft(zespoloneL);

            // Obliczanie modułu
            for (int i = 0; i < fftL.length; i++) {
                dane[licznik][i] = fftL[i].getModuł();
                //System.out.println(dane[licznik][i]);
            }
            licznik++;
        }

        return dane;
    }

    /**
     * Metoda rysuje spektrogram
     * @param dane - dane do spektrogramu
     * @param fsamp - częstotliwość próbkowania
     * @param fmax - maksymalna częstotliwość do rysowania
     */
    public static void RysujSpektrogram(double[][] dane, double fsamp, int fmax) {

        try {
            double krok = fsamp/(double) dane[0].length;
            int ileKrokow = (int)(fmax/krok);
            BufferedImage obraz = new BufferedImage(dane.length*5, ileKrokow, BufferedImage.TYPE_INT_RGB);
            int liczX = 0;

            double max = SzukajMax(dane);

            for (int i = 0; i < dane.length; i++) {
                for (int k = 0; k < 5; k++) {
                    for (int j = 0; j < ileKrokow; j++) {
                        Color kolor = getColor(dane[i][j], max);
                        obraz.setRGB(liczX, ileKrokow- 1 - j, kolor.getRGB());
                    }
                    liczX++;
                }

            }
            JFrame frame = new JFrame();
            JScrollPane scroll = new JScrollPane(new JLabel(new ImageIcon(obraz)));
            scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            scroll.setVisible(true);
            frame.getContentPane().add(scroll);
            frame.pack();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoda wyszukuje największej wartości w tablicy dwuwymiarowej
     * @param tab - tablica
     * @return max value
     */
    public static double SzukajMax(double[][] tab) {
        double max = 0;

        for (int i = 0; i < tab.length; i++) {
            for(int j = 0; j < tab[i].length; j++) {
                if(tab[i][j] > max) {
                    max = tab[i][j];
                }
            }
        }
        return max;
    }

    /**
     * Metoda oblicza kolor punktu na podstawie zadanej wartości oraz wartości maksymalnej.
     * Im wyższa wartość tym punkt ciemniejszy.
     * @param power - wartość w danym punkcie
     * @param max - maksymalna wartość w danych
     * @return kolor punktu
     */
    public static Color getColor(double power, double max) {
        float[] t = new float[3];

        double mnożnik = 256/max;
        power = power * mnożnik;
        if (power > 256) power = 256;
        //System.out.println(power);
        power = 256 - power;
        Color.RGBtoHSB((int) power,(int) power, (int) power, t);
        return Color.getHSBColor(t[0], t[1], t[2]);
    }
}
