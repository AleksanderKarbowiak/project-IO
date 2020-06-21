package Classes;
import java.util.*;


/**
 * Klasa odpowiedzialna za obsługę dyskretnej transformaty Fouriera
 * Udostępniona do użytku przez dr Piotra Wrzeciono
 */
public class DTFT {

    /**
     * Pola potrzebne do wykonania obliczeń
     */
    private final double CzęstotliwośćPoczątkowa;
    private final double CzęstotliwośćKońcowa;
    private final double KrokCzęstotliwości;
    private final int LiczbaPróbek;
    private final double CzęstotliwośćPróbkowania;

    /**
     * Konstruktor przyjmujcy potrzebne do utworzenia obiektu transformaty
     * @param początek - częstotliwość poczatkowa
     * @param koniec - częstotliwość końcowa
     * @param krok - krok częśtotliwościowy ustawiony dla obliczeń
     * @param fs - częśtotlwiość próbkowania
     */
  public DTFT(double początek, double koniec, double krok, double fs)
    {
        CzęstotliwośćPoczątkowa = początek;
        CzęstotliwośćKońcowa = koniec;
        KrokCzęstotliwości = krok;
        
        LiczbaPróbek = (int)((koniec - początek)/krok);
        
        CzęstotliwośćPróbkowania = fs;
        
    }

    /**
     * Metoda obliczajca pulsację
     * @param f - cześtotliwość dla które liczymy pulsację
     */
 private double pulsacja(double f)
    {
        double wynik;
        
        wynik = 2 * Math.PI * f;
        
        return wynik;
    }//Koniec obliczania pulsacji


    /**
     * Metoda zwracajaca próbkę widma
     * @param f - częstotliwość
     * @param próbki - próbki naszego nagrania
     * @return - wynikiem metody jest liczba urojona przechowywana za pomoca klasy Complex
     */
 private Complex ObliczPróbkęWidma(double f, double[] próbki)
    {
        int i;
        Complex wynik;
        double a;
        double b;
        double omega;
        double ułamek;
        
        a = 0;
        b = 0;
        omega = pulsacja(f);
        
        for(i = 0; i < próbki.length; i++)
        {
            ułamek = (omega * (double)i)/CzęstotliwośćPróbkowania;
            
            a += próbki[i] * Math.cos(ułamek);
            b -= próbki[i] * Math.sin(ułamek);
        }
        
        a = a/(double)próbki.length;
        b = b/(double)próbki.length;
        
        wynik = new Complex(a,b);
        
        return wynik;
        
    }

    /**
     * Metoda używana do obliczania DTFT, korzystaja z metody @ObliczProbkeWidma do zapełniania tablicy widmo[]
     * @param próbki - próbki nagrania
     * @return - tablica widmo z wynikiem DTFT
     */
    
    public widmo[] ObliczDTFT(double[] próbki)
    {
        widmo[] tablica;
        int i;
        double f;
        Complex pojedynczy;
        double a;
        double b;
        
        tablica = new widmo[LiczbaPróbek];
        
        for(i = 0; i < LiczbaPróbek; i++)
        {
            f = CzęstotliwośćPoczątkowa + (KrokCzęstotliwości * ((double)i));
            
            pojedynczy = ObliczPróbkęWidma(f, próbki);
            
            a = pojedynczy.getReal();
            b = pojedynczy.getImaginary();
            
            tablica[i] = new widmo(a, b, f);
            
        }//next i
        
        return tablica;      
    }
}
