package Classes;

/**
 * Klasa służąca do generowania spróbkowanych typowych funkcji
 */

public class funkcje
{
    /**Okres próbkowania*/
    private double Ts;
    /**Liczba próbek*/
    private int N;
    
    /**
     * Konstruktor klasy funkcje.
     * @param fs Częstotliwość próbkowania [Hz]
     * @param N Liczba próbek sygnału
     */
    public funkcje(double fs, int N)
    {
        Ts = 1/fs;
        this.N = N;
    }/** Koniec próbkowania */
    
    /**
     * metoda zwracająca sinus na podstawie częstotliwości i amplitudy
     * @param częstotliwość
     * @param amplituda
    * @return wynik
     */
    public double[] sinus(double Częstotliwość, double Amplituda)
    {
        double omega;
        double[] wynik;
        int i;
        double arg;
        double t;
        
        wynik = new double[N];
        
        omega = 2 * Math.PI * Częstotliwość;
        
        for(i = 0; i < N; i++)
        {
            t = Ts * (double)i;
            arg = omega * t;
            
            wynik[i] = Amplituda * Math.sin(arg);
        }/** next x */
        
        return wynik;
    }/** Koniec metody sinus */

    /**
     * metoda budująca sygnał o kształcie prostokąta
     * @param CzasTrwania - czas trwania sygnału
     * @param amplituda
     * @return wynik - tablica z wartościami tworzącymi sygnał o kształcie prostokąta
     */
    public double[] prostokąt(double CzasTrwania, double Amplituda)
    {
        double[] wynik;
        int i;
        double pół;
        double t;
        
        wynik = new double[N];
        pół = CzasTrwania/2;
        
        for(i = 0; i < N; i++)
        {
            t = Ts * (double)i;
            
            if(t < pół)
            {
                wynik[i] = Amplituda;
            }else
            {
                wynik[i] = 0;
            }
        }/** next i */
        
        return wynik;
        
    }/** Koniec metody prostokąt; */

    /**
     * metoda licząca spadek wykładniczy
     * @param Współczynnik
     * @param amplituda
     * @return wynik - wartość spadku wykładniczego
     */
    public double[] SpadekWykładniczy(double Współczynnik, double Amplituda)
    {
        double[] wynik;
        double t;
        int i;
        
        wynik = new double[N];
        
        for(i = 0; i < N; i++)
        {
            t = Ts * (double)i;
            
            wynik[i] = Amplituda * Math.exp(-Współczynnik * t);
        }/** next i */
        
        return wynik;
        
    }/** Koniec fukcji A*e^(-at) */

    /**
     * metoda budująca okresowy sygnał o kształcie prostokąta
     * @param IleOkresów - liczba okresów
     * @param amplituda
     * @return wynik
     */
    public double[] OkresowyProstokąt(double Amplituda, double IleOkresów)
    {
        double wynik[];
        int i;
        int okres;
        double wartość;
        int k;
        
        
        okres = (int)((N/(IleOkresów))/2);
        k = 0;
        wartość = Amplituda;
        
        wynik = new double[N];
        
        for(i = 0; i < N; i++)
        {
            wynik[i] = wartość;
            
             k++;
            
            if(k == okres)
            {
                if(wartość > 0) wartość = -Amplituda; else wartość = Amplituda;
                k = 0;
            }/** end if */
            
        }/** next i */
        
        
        return wynik;
        
    }/** Koniec metody zwracającej okresowy prostokąt */
    
    
}/** Koniec klasy */
