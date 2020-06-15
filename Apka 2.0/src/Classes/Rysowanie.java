package Classes;

import java.awt.*;
import javax.swing.*;

<<<<<<< HEAD
=======
/**
 * Klasa zawierająca metody do rysowania
 */
>>>>>>> master
public class Rysowanie
{

    public static void  main(String[] argh)
    {
        Ramka Okno;
        DTFT Transformata;
        funkcje sygnał;
<<<<<<< HEAD
        
        double fs; //Parametry próbkowania
        int N;
        
        double A; //Parametry sygnału
        double f;
        
        double f_max; //Parametry DTFT
        double f_min;
        double f_krok;
        
        double[] próbki;
        widmo[] wynik;
        
        fs = 1000;
        N = 50;
        
        A = 5;
        f = 20;
        
        f_max = fs/2;
        f_min = -f_max;
        f_krok = fs/2000;
        
        Transformata = new DTFT(f_min, f_max, f_krok, fs);
        sygnał = new funkcje(fs,N);
        
        próbki = sygnał.sinus(20, 5);
        wynik = Transformata.ObliczDTFT(próbki);
        
        Okno = new Ramka(600,600,"Wykresy widm",10,10, wynik);
        Okno.UstawMnieNaŚrodku();
        
        Okno.setVisible(true);
        
=======

        double fs; //Parametry próbkowania
        int N;

        double A; //Parametry sygnału
        double f;

        double f_max; //Parametry DTFT
        double f_min;
        double f_krok;

        double[] próbki;
        widmo[] wynik;

        fs = 1000;
        N = 50;

        A = 5;
        f = 20;

        f_max = fs/2;
        f_min = -f_max;
        f_krok = fs/2000;

        Transformata = new DTFT(f_min, f_max, f_krok, fs);
        sygnał = new funkcje(fs,N);

        próbki = sygnał.sinus(20, 5);
        wynik = Transformata.ObliczDTFT(próbki);

        Okno = new Ramka(600,600,"Wykresy widm",10,10, wynik);
        Okno.UstawMnieNaŚrodku();

        Okno.setVisible(true);

>>>>>>> master
        if(argh.length > 0 && argh[0].compareTo("t") == 0) //Blokada na wyrzucanie widma do konsoli
        {
            WyprowadźWidmo(wynik);
        }//end if
<<<<<<< HEAD
        
    }//Koniec main
    
    public static void WyprowadźWidmo(widmo[] tablica)
    {
        int i;
        
        System.out.println("Częstotliwość [Hz]\tAmplituda\tMoc [dB]");
        
=======

    }//Koniec main

    /**
     * Metoda służąca do wprowadzenia widma
     *
     * @param tablica
     */
    public static void WyprowadźWidmo(widmo[] tablica)
    {
        int i;

        System.out.println("Częstotliwość [Hz]\tAmplituda\tMoc [dB]");

>>>>>>> master
        for(i = 0; i < tablica.length; i++)
        {
            System.out.print(tablica[i].getCzęstotliwość() + "\t");
            System.out.print(tablica[i].getWidmoAmplitudowe() + "\t");
            System.out.println(tablica[i].get_dB());
        }//next i
<<<<<<< HEAD
        
=======

>>>>>>> master
    }//Koniec wyprowadzania widma

}//Koniec klasy



class Ramka extends JFrame
{
<<<<<<< HEAD
    private PanelOkna PanelDoRysunku;

    public Ramka(int maxx, int maxy, String tytuł, int IleX, int IleY, widmo[] Wynik)
    {
        super();
        
        setSize(maxx,maxy);
        setTitle(tytuł);
        
        PanelDoRysunku = new PanelOkna(IleX, IleY, Wynik);
        add(PanelDoRysunku,BorderLayout.CENTER);
        
    }//Koniec konstruktora
    
    public void UstawMnieNaŚrodku()
      {
	  Toolkit ŚrodowiskoGUI; //Potrzebna nam skrzynka z narzędziami
	  Dimension RozmiarEkranu;
	  int PozycjaX;
	  int PozycjaY;

	  int SzerokośćOkna;
	  int WysokośćOkna;

	  ŚrodowiskoGUI = Toolkit.getDefaultToolkit(); //Standardowy, domyślny Toolkit

	  /* Toolkit.getDefaultToolkit to metoda statyczna, zwracająca obiekt,
	   * który opisuje środowisko graficzne "zewnętrzne" w stosunku do okna.
	   * Do informacji podstawowych należy oczywiście rozmiar ekranu lub pulpitu
	   * wirtualnego, zawsze wyrażający się w pikselach.
	   * Znając rozmiar okna oraz rozmiar ekranu, w prosty sposób możemy
	   * umieścić okno na środku pulpitu.
	   */

	  RozmiarEkranu = ŚrodowiskoGUI.getScreenSize();

	  PozycjaX = 0;
	  PozycjaY = 0;

	  SzerokośćOkna = this.getSize().width;
	  WysokośćOkna = this.getSize().height;

	  PozycjaX = (RozmiarEkranu.width - SzerokośćOkna)/2;
	  PozycjaY = (RozmiarEkranu.height - WysokośćOkna)/2;

	  this.setLocation(PozycjaX,PozycjaY); // Ustawia pozycję okna

      }//Koniec centrowania ramki
    
=======
    /**
     * Klasa zawierająca metody do utworzenia ramki
     */
    private PanelOkna PanelDoRysunku;

    /**
     * Metoda tworząca ramke
     * @param maxx
     * @param maxy
     * @param tytuł
     * @param IleX
     * @param IleY
     * @param Wynik
     */
    public Ramka(int maxx, int maxy, String tytuł, int IleX, int IleY, widmo[] Wynik)
    {
        super();

        setSize(maxx,maxy);
        setTitle(tytuł);

        PanelDoRysunku = new PanelOkna(IleX, IleY, Wynik);
        add(PanelDoRysunku,BorderLayout.CENTER);

    }//Koniec konstruktora

    /**
     * Metoda ustawiająca położenie okna
     */
    public void UstawMnieNaŚrodku()
    {
        Toolkit ŚrodowiskoGUI; //Potrzebna nam skrzynka z narzędziami
        Dimension RozmiarEkranu;
        int PozycjaX;
        int PozycjaY;

        int SzerokośćOkna;
        int WysokośćOkna;

        ŚrodowiskoGUI = Toolkit.getDefaultToolkit(); //Standardowy, domyślny Toolkit

        /* Toolkit.getDefaultToolkit to metoda statyczna, zwracająca obiekt,
         * który opisuje środowisko graficzne "zewnętrzne" w stosunku do okna.
         * Do informacji podstawowych należy oczywiście rozmiar ekranu lub pulpitu
         * wirtualnego, zawsze wyrażający się w pikselach.
         * Znając rozmiar okna oraz rozmiar ekranu, w prosty sposób możemy
         * umieścić okno na środku pulpitu.
         */

        RozmiarEkranu = ŚrodowiskoGUI.getScreenSize();

        PozycjaX = 0;
        PozycjaY = 0;

        SzerokośćOkna = this.getSize().width;
        WysokośćOkna = this.getSize().height;

        PozycjaX = (RozmiarEkranu.width - SzerokośćOkna)/2;
        PozycjaY = (RozmiarEkranu.height - WysokośćOkna)/2;

        this.setLocation(PozycjaX,PozycjaY); // Ustawia pozycję okna

    }//Koniec centrowania ramki

>>>>>>> master
}//Koniec ramki


/* Klasa dziedzicząca z klasy JPanel
 * W klasie tej przeciążeniu poddano metodę paintComponent,
 * używaną jak nazwa wskazuje, do rysowania.
 * Rysowanie może odbywać się tylko za pomocą tej metody,
 * a dodatkowo metoda ta jest wywoływana tylko wtedy, gdy
 * istnieje potrzeba przerysowania okna. Jest to bardzo istotna
 * informacja, bo rysunek w rzeczywistości powinien być
 * w pewien sposób buforowany, gdyż w innym przypadku
 * zotanie on zamazany czym innym, na przykład innym oknem.
 */

<<<<<<< HEAD

=======
/**
 * Klasa zawierająca metody tworzące panel okna
 */
>>>>>>> master
class PanelOkna extends JPanel
{
    private final int IlePodziałekX;
    private final int IlePodziałekY;
    private final widmo[] WidmoDoRysowania;
<<<<<<< HEAD
    
=======

>>>>>>> master
    private double max_wartość_widma;
    private double min_wartość_widma;
    private double f_min;
    private double f_max;
<<<<<<< HEAD
    
    public PanelOkna(int IleX, int IleY, widmo[] WidmoDoRysowania )
    {
        super();
        
        this.setOpaque(true);
        IlePodziałekX = IleX;
        IlePodziałekY = IleY;
        
        this.WidmoDoRysowania = WidmoDoRysowania;
        
=======

    /**
     * Metoda tworząca panel okna
     * @param IleX
     * @param IleY
     * @param WidmoDoRysowania
     */
    public PanelOkna(int IleX, int IleY, widmo[] WidmoDoRysowania )
    {
        super();

        this.setOpaque(true);
        IlePodziałekX = IleX;
        IlePodziałekY = IleY;

        this.WidmoDoRysowania = WidmoDoRysowania;

>>>>>>> master
        max_wartość_widma = ZnajdźMaksAmplitudę();
        min_wartość_widma = ZnajdźMinAmplitudę();
        f_min = WidmoDoRysowania[0].getCzęstotliwość();
        f_max = WidmoDoRysowania[WidmoDoRysowania.length-1].getCzęstotliwość();
<<<<<<< HEAD
        
    }//Koniec konstruktora

    public void paintComponent(Graphics NaTymRysujemy)
    {
	int PozycjaX;
	int PozycjaY;
	
	super.paintComponent(NaTymRysujemy);
	setBackground(Color.WHITE);
	
	RysujSkalę(NaTymRysujemy);
	RysujWidmo(NaTymRysujemy);

    }//Koniec rysowania wszystkiego
    
=======

    }//Koniec konstruktora

    /**
     * metoda pomocnicza w rysowaniu
     * @param NaTymRysujemy
     */
    public void paintComponent(Graphics NaTymRysujemy)
    {
        int PozycjaX;
        int PozycjaY;

        super.paintComponent(NaTymRysujemy);
        setBackground(Color.WHITE);

        RysujSkalę(NaTymRysujemy);
        RysujWidmo(NaTymRysujemy);

    }//Koniec rysowania wszystkiego

    /**
     * Metoda rysująca skalę
     * @param NaTymRysujemy
     */
>>>>>>> master
    private void RysujSkalę(Graphics NaTymRysujemy)
    {
        int MaxX;
        int MaxY;
        int x;
        int y;
        int skokX;
        int skokY;
<<<<<<< HEAD
        
        MaxX = getWidth();
        MaxY = getHeight();
        
        skokX = (int)MaxX/IlePodziałekX;
        skokY = (int)MaxY/IlePodziałekY;
        
        NaTymRysujemy.setColor(Color.LIGHT_GRAY);
        
=======

        MaxX = getWidth();
        MaxY = getHeight();

        skokX = (int)MaxX/IlePodziałekX;
        skokY = (int)MaxY/IlePodziałekY;

        NaTymRysujemy.setColor(Color.LIGHT_GRAY);

>>>>>>> master
        for(x = 0; x <= MaxX; x += skokX)
        {
            NaTymRysujemy.drawLine(x,0,x,MaxY);
        }//next x
<<<<<<< HEAD
        
=======

>>>>>>> master
        for(y = 0; y <= MaxY; y += skokY)
        {
            NaTymRysujemy.drawLine(0,y,MaxX,y);
        }//next y
<<<<<<< HEAD
        
    }//Koniec rysowania skali
    
    
=======

    }//Koniec rysowania skali


    /**
     * metoda rysujaca widmo
     * @param NaTymRysujemy
     */
>>>>>>> master
    private void RysujWidmo(Graphics NaTymRysujemy)
    {
        int MaxX;
        int MaxY;
        int x1;
        int y1;
        int x2;
        int y2;
        int i;
<<<<<<< HEAD
        
        MaxX = getWidth();
        MaxY = getHeight();
        
        NaTymRysujemy.setColor(Color.BLUE); //Rysujemy na niebiesko
        
=======

        MaxX = getWidth();
        MaxY = getHeight();

        NaTymRysujemy.setColor(Color.BLUE); //Rysujemy na niebiesko

>>>>>>> master
        for(i = 0; i < WidmoDoRysowania.length - 1; i++)
        {
            x1 = PrzeliczWspółrzędną(MaxX, f_min, f_max, WidmoDoRysowania[i].getCzęstotliwość());
            y1 = PrzeliczWspółrzędną(MaxY, min_wartość_widma, max_wartość_widma, WidmoDoRysowania[i].getWidmoAmplitudowe());
            y1 = Lustro(MaxY, y1);
<<<<<<< HEAD
            
            x2 = PrzeliczWspółrzędną(MaxX, f_min, f_max, WidmoDoRysowania[i+1].getCzęstotliwość());
            y2 = PrzeliczWspółrzędną(MaxY, min_wartość_widma, max_wartość_widma, WidmoDoRysowania[i+1].getWidmoAmplitudowe());
            y2 = Lustro(MaxY, y2);
            
            NaTymRysujemy.drawLine(x1,y1,x2,y2);
            
        }//next i
        
    }//Koniec rysowania widma amplitudowego
    
    
=======

            x2 = PrzeliczWspółrzędną(MaxX, f_min, f_max, WidmoDoRysowania[i+1].getCzęstotliwość());
            y2 = PrzeliczWspółrzędną(MaxY, min_wartość_widma, max_wartość_widma, WidmoDoRysowania[i+1].getWidmoAmplitudowe());
            y2 = Lustro(MaxY, y2);

            NaTymRysujemy.drawLine(x1,y1,x2,y2);

        }//next i

    }//Koniec rysowania widma amplitudowego

    /**
     * Metoda licząca współrzędną
     * @param Max
     * @param d_min
     * @param d_max
     * @param wartość
     * @return
     */
>>>>>>> master
    private int PrzeliczWspółrzędną(int Max, double d_min, double d_max, double wartość)
    {
        double max_obrazka;
        double różnica;
        double szerokość;
        double ułamek;
        int wynik;
<<<<<<< HEAD
        
        max_obrazka = (double)Max;
        różnica = d_max - d_min; //To jest całość.
        szerokość = wartość - d_min;
        
        ułamek = szerokość/różnica;
        
        wynik = (int)(Max * ułamek);
        
        return wynik;
        
    }//Koniec metody przeliczającej współrzędną
    
    private int Lustro(int Max, int wartość)
    {
        int wynik;
        
        wynik = Max - wartość;
        
        return wynik;
    }//Koniec metody Lustro
    
=======

        max_obrazka = (double)Max;
        różnica = d_max - d_min; //To jest całość.
        szerokość = wartość - d_min;

        ułamek = szerokość/różnica;

        wynik = (int)(Max * ułamek);

        return wynik;

    }//Koniec metody przeliczającej współrzędną

    /**
     * Metoda lustro?
     * @param Max
     * @param wartość
     * @return
     */
    private int Lustro(int Max, int wartość)
    {
        int wynik;

        wynik = Max - wartość;

        return wynik;
    }//Koniec metody Lustro

    /**
     * Metoda znajdująca maksymalną amplitudę
     * @return
     */
>>>>>>> master
    private double ZnajdźMaksAmplitudę()
    {
        double max_amp;
        int i;
<<<<<<< HEAD
        
        max_amp = WidmoDoRysowania[0].getWidmoAmplitudowe();
        
=======

        max_amp = WidmoDoRysowania[0].getWidmoAmplitudowe();

>>>>>>> master
        for(i = 0; i < WidmoDoRysowania.length; i++)
        {
            if(max_amp < WidmoDoRysowania[i].getWidmoAmplitudowe())
            {
                max_amp = WidmoDoRysowania[i].getWidmoAmplitudowe();
            }//end if
        }//next i
<<<<<<< HEAD
        
        return max_amp;
        
    }//Koniec szukania maks
    
=======

        return max_amp;

    }//Koniec szukania maks

    /**
     * Metoda znajdująca minimalną amplitudę
     * @return
     */
>>>>>>> master
    private double ZnajdźMinAmplitudę()
    {
        double min_amp;
        int i;
<<<<<<< HEAD
        
        min_amp = WidmoDoRysowania[0].getWidmoAmplitudowe();
        
=======

        min_amp = WidmoDoRysowania[0].getWidmoAmplitudowe();

>>>>>>> master
        for(i = 0; i < WidmoDoRysowania.length; i++)
        {
            if(min_amp > WidmoDoRysowania[i].getWidmoAmplitudowe())
            {
                min_amp = WidmoDoRysowania[i].getWidmoAmplitudowe();
            }//end if
        }//next i
<<<<<<< HEAD
        
        return min_amp;
        
    }//Koniec szukania maks
    
    
=======

        return min_amp;

    }//Koniec szukania maks


>>>>>>> master
}//Koniec klasy
