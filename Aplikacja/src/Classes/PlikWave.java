/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.File;
import java.io.RandomAccessFile;

/**
 * Klasa służąca do obsługi pliku wave (nowy, otwórz, zapisz, dopisz).
 * Udostępniona do użytku przez dr Piotra Wrzeciono
 * @author Piotr Wrzeciono
 * @since 2016.02.19
 */
public class PlikWave
{
    /**Nagłówek pliku WAVE - musi być prywatny, gdyż tylko określone pola podlegają modyfikacji w trakcie dopisywania, ale długość nie ulega zmianie. */
    private NagłówekPlikuWave Nagłówek;
    /**Plik binarny o dostępie do dowolnego miejsca - do obsługi operacji na pliku wave. */
    private RandomAccessFile PlikNaDysku;
    /**Instancja klasy służąca do pobierania informacji systemowych. */
    private File PlikNaDyskuFile;
    /**Nazwa pliku w formie tekstowej. */
    private String NazwaPliku;
    /**Wielkość bufora nagłówka pliku wave - wartośc potrzebna przy wielu operacjach. */
    private int WielkośćBuforaNagłówka;

    /**Status operacji dokonywanych na pliku. */
    private int status;

    /**Operacja zakończyła się powodzeniem. */
    public static final int BRAK_BŁĘDÓW = 0;
    /**Próbowano odczytać plik, który fizycznie nie istnieje (jeszcze). */
    public static final int PLIK_NIE_ISTNIEJE = 1;
    /**Wystąpił jakiś błąd przy próbie otwarcia pliku. */
    public static final int NIE_UDAŁO_SIĘ_OTWORZYĆ_PLIKU = 2;
    /**Błąd podczas zapisu - metoda write(byte[] bufor). */
    public static final int BŁĄD_PODCZAS_ZAPISU = 3;
    /**Błąd podczas odczytu - metoda read(byte[] bufor). */
    public static final int BŁĄD_PODCZAS_ODCZYTU = 4;
    /**Nagłówek pliku WAVE jest niepoprawny - najczęstrzym powodem jest próba otwarcia pliku, który plikiem wave nie jest. */
    public static final int BŁĘDNY_NAGŁÓWEK = 5;
    /**Błąd podczas tworzenia instancji klasy File - prawie niemożliwe, ale to jednak tylko "prawie". */
    public static final int BŁĄD_PODCZAS_TWORZENIA_INSTANCJI_FILE = 6;
    /**Próba otworzenia pliku, który i tak jest już otwarty. */
    public static final int PLIK_JUŻ_JEST_OTWARTY = 7;
    /**Błąd podczas wywołania metody seek(long pozycja). */
    public static final int BŁĄD_USTAWIANIA_POZYCJI_W_PLIKU = 8;
    /**Błąd podczas zamykania pliku - tak na wszylki "wypadek". */
    public static final int BŁĄD_PODCZAS_ZAMYKANIA_PLIKU = 9;
    /**Próba utworzenia nowego pliku wave o takiej samej nazwie, jak już istniejący - niewskazane. */
    public static final int PODANY_PLIK_JUŻ_ISTNIEJE = 10;
    /**Próba utworzenia nowego pliku się nie powiodła - powód za bardzo nie ma zanczenia. */
    public static final int NIE_UDAŁO_SIĘ_UTWORZYĆ_PLIKU = 11;

    /**
     * Metoda zwracająca tekstowy opis stałych - może być potrzebna w razie testów.
     * @param nr Numer stałej -> stałe dotyczące statusu.
     * @return Opis stałej.
     */
    public static String OpisStatusu(int nr)
    {
        String opis;

        opis = "";


        if(nr == BRAK_BŁĘDÓW) opis = "Brak błędów";
        if(nr == PLIK_NIE_ISTNIEJE) opis = "Podany plik nie istnieje";
        if(nr == NIE_UDAŁO_SIĘ_OTWORZYĆ_PLIKU) opis = "Nie udało się otworzyć pliku!";
        if(nr == BŁĄD_PODCZAS_ZAPISU) opis = "Błąd podczas zapisu danych!";
        if(nr == BŁĄD_PODCZAS_ODCZYTU) opis = "Błąd podczas odczytu danych";
        if(nr == BŁĘDNY_NAGŁÓWEK) opis = "Błędny nagłówek pliku WAVE";
        if(nr == BŁĄD_PODCZAS_TWORZENIA_INSTANCJI_FILE) opis = "Błąd podczas tworzenia instancji klasy File";
        if(nr == PLIK_JUŻ_JEST_OTWARTY) opis = "Plik już jest otwarty!";
        if(nr == BŁĄD_USTAWIANIA_POZYCJI_W_PLIKU) opis = "Błąd w trakcie wywołania polecenia seek";
        if(nr == BŁĄD_PODCZAS_ZAMYKANIA_PLIKU) opis = "Błąd podczas zamykania pliku wave";
        if(nr == PODANY_PLIK_JUŻ_ISTNIEJE) opis = "Podany plik już istnieje - nie można go utworzyć jako nowego!";
        if(nr == NIE_UDAŁO_SIĘ_UTWORZYĆ_PLIKU) opis = "Nie udało się utworzyć pliku!";

        return opis;

    }//Koniec metody zwracającej opis statusu

    /**
     * Konstruktor klasy tworzący instancję pliku wave.
     *
     * Konstruktor powołuje tylki instancję klasy File oraz zapamiętuje nazwę pliku.<br>
     * Do pozostałych czynności używa się innych metod.
     * @param NazwaPliku
     */
    public PlikWave(String NazwaPliku)
    {
        this.NazwaPliku = NazwaPliku;
        this.Nagłówek = null;
        this.PlikNaDysku = null;
        this.WielkośćBuforaNagłówka = 0;

        try{
            this.PlikNaDyskuFile = new File(NazwaPliku);
            status =  BRAK_BŁĘDÓW;
        }catch(Exception ex){
            status = BŁĄD_PODCZAS_TWORZENIA_INSTANCJI_FILE;
        }//Koniec przechwytywania wyjątku

    }//Koniec konstruktora

    /**
     * Metoda zwracająca status pliku wave.
     * @return Status pliku wave (jedna ze stałych zdefiniowana na początku).
     */
    public int getStatusPlikuWave()
    {
        return status;
    }//koniec getStatusPlikuWave

    /**
     * Metoda zwracająca status nagłówka pliku wave
     * @return <b>null</b>, gdy nagłówek nie został jeszcze utworzony. W innym przypadku tablica jedno lub ośmio-elementowa.
     */
    public int[] getStatusNagłówkaPlikuWave()
    {
        int[] status_wave;

        status_wave = null;

        if(Nagłówek != null) status_wave = Nagłówek.getPoprawnośćNagłówka();

        return status_wave;
    }//Koniec getStatusPlikuWave

    /**
     * Metoda służy do otworzenia już istniejącego pliku.
     *
     * Sam konstruktor tworzy tylko instancję klasy <b><i>File</i></b>, gdyż nie wiadomo, co programista chce zrobić.
     * Do otworzenia istniejącego już pliku służy właśnie ta metoda.
     */
    public void OtwórzIstniejącyPlik()
    {
        byte[] DaneNagłówkaPlikuWave;

        WielkośćBuforaNagłówka = 0;

        if(this.PlikNaDyskuFile.exists() == false) status = PLIK_NIE_ISTNIEJE;

        if(status != PLIK_NIE_ISTNIEJE) //Gdy strumień wejściowy != null, nie ma sensu wywoływanie tego polecenia.
        {
            try{
                PlikNaDysku = new RandomAccessFile(NazwaPliku,"rw");
                status = BRAK_BŁĘDÓW;
            }catch(Exception ex){
                status = NIE_UDAŁO_SIĘ_OTWORZYĆ_PLIKU;
                PlikNaDysku = null; //Usunięcie obiektu z pamięci!
            }//end catch

            if(status == BRAK_BŁĘDÓW)
            {
                WielkośćBuforaNagłówka = this.PodajPozycjęData() + 8;
            }//end if

            if(status == BRAK_BŁĘDÓW)
            {
                DaneNagłówkaPlikuWave = new byte[WielkośćBuforaNagłówka];

                try{
                    PlikNaDysku.seek(0); //Próba ustawienia pozycji
                    PlikNaDysku.read(DaneNagłówkaPlikuWave);
                }catch(Exception ex){
                    status = BŁĄD_PODCZAS_ODCZYTU;
                }

                if(status == BRAK_BŁĘDÓW) //Finalnie! Można utworzyć nagłówek pliku!!!
                {
                    Nagłówek = new NagłówekPlikuWave(DaneNagłówkaPlikuWave);

                    if(Nagłówek.getPoprawnośćNagłówka().length != 1) //Jednak coś poszło nie tak!
                    {
                        status = BŁĘDNY_NAGŁÓWEK;
                    }//end if
                }//end if

            }//end if

        }else
        {
            if(status == BRAK_BŁĘDÓW) status = PLIK_JUŻ_JEST_OTWARTY;
        }//end if
    }//Koniec metody otwierającej istniejący plik.

    /**
     * Metoda zamykająca plik wave.
     *
     * <div style="color:red"><b>UWAGA! Wywołanie tej metody pociąga za sobą również: wykasnowanie nagłówka pliku oraz usunięcie dostępu do obiektu reprezentującego plik binarny.</b></div>
     */
    public void ZamknijPlik()
    {
        if(PlikNaDysku != null) //Tylko wtedy ma to sens!
        {
            try{

                PlikNaDysku.close();

                status = BRAK_BŁĘDÓW;

            }catch(Exception ex)
            {
                status = BŁĄD_PODCZAS_ZAMYKANIA_PLIKU;
            }//end try-catch

            PlikNaDysku = null; //Wszystko zerujemy!
            Nagłówek = null;
            WielkośćBuforaNagłówka = 0;

        }//end if

    }//Metoda zamykająca plik

    /**
     * Metoda wyszukująca na początku pliku słowa kluczowego 'data'.
     *
     * Celem tej metody jest pomoc w wyliczeniu wielkości nagłówka. W pliku WAVE może mieć on różną długość, ale 'data' jest ostatnim słowem kluczowym nagłówka.<br>
     * Za słowem 'data' są 4 bajty zawierające w sobie wielkość bloku danych oraz same dane.
     * @return Pozycja tekstu 'data'.
     */
    private int PodajPozycjęData()
    {
        int pozycja;
        byte[] bufor;
        int i;
        byte[] słowo_data;
        int IleSięDałoOdczytać;
        int j;
        int ile_poprawnych;

        pozycja = 35;
        bufor = new byte[10000];
        IleSięDałoOdczytać = 0;

        słowo_data = new byte[]{'d','a','t','a'};

        ile_poprawnych = 0;

        try{
            PlikNaDysku.seek(0);
            status = BRAK_BŁĘDÓW;
        }catch(Exception ex){
            status = BŁĄD_USTAWIANIA_POZYCJI_W_PLIKU;

            pozycja = -1;
        }//Koniec try-catch

        if(status == BRAK_BŁĘDÓW) //teraz odczytujemy;
        {
            try{
                IleSięDałoOdczytać = PlikNaDysku.read(bufor);
            }catch(Exception ex){
                status = BŁĄD_PODCZAS_ODCZYTU;
            }
        }//end if

        if(status == BRAK_BŁĘDÓW)
        {
            i = 30;

            do{
                ile_poprawnych = 0;
                if(i + słowo_data.length < IleSięDałoOdczytać)//zabezpieczenie przez przekroczeniem indeksu
                {
                    for(j = i; j < i + słowo_data.length;j++)
                    {
                        if(bufor[j] == słowo_data[j - i]) ile_poprawnych++;
                    }//next i
                }//end if

                if(ile_poprawnych < słowo_data.length) i++; //Następna pozycja

            }while(i < bufor.length && ile_poprawnych < słowo_data.length);

            if(ile_poprawnych == słowo_data.length) pozycja = i;
        }//end if

        return pozycja;
    }//Koniec szukania pozycji 'data'

    /**
     * Metoda zwraca wielkość pliku na dysku [B].
     * @return Wielkość pliku
     */
    public long getWielkośćPliku()
    {
        long wielkość;

        wielkość = 0;

        if(PlikNaDyskuFile.exists()) wielkość = PlikNaDyskuFile.length();

        return wielkość;
    }//Koniec metody zwracającej wielkość pliku na dysku

    /**
     * Metoda zwracająca liczbę kanałów w pliku wave.
     * @return 0, gdy nie ma nagłówka, 1 - mono, 2 - stereo itd.
     */
    public int getLiczbaKanałów()
    {
        int ile;

        ile = 0;

        if(Nagłówek != null) ile = Nagłówek.getLiczbęKanałów();

        return ile;
    }//Koniec metody zwracającej liczbę kanałów

    /**
     * Metoda zwracająca liczbę bitów służących do kodowania amplitudy sgnału.
     * @return 0, gdy nie ma nagłówka, potem wielokrotność 8 - bitów: 8, 16, 24 oraz 32.
     */
    public int getLiczbęBitów()
    {
        int ile;

        ile = 0;

        if(Nagłówek != null) ile = Nagłówek.getLiczbęBitów();

        return ile;
    }//Koniec metody zwracającej liczbę bitów

    /**
     * Metoda zwraca wielkość całego segmentu danych, zawierającą próbkę ze wszystkich kanałów.
     * @return 0, gdy nie ma nagłówka, wartość dodatnią, gdy nagłówek jest.
     */
    public int getLiczbęBajtówNaCałąPróbkę()
    {
        int ile;

        ile = 0;

        if(Nagłówek != null) ile = Nagłówek.getLiczbęBajtówNaCałąPróbkę();

        return ile;
    }//Koniec metody zwracającej liczbę bajtów w całej próbce

    /**
     * Metoda zwraca szybkość (częstotliwość) bajtową sygnału w pliku WAVE.
     * @return 0, gdy nie ma nagłówka. Gdy jest nagłówek, jest to wartość w [B/s].
     */
    public long getCzęstotliwośćBajtową()
    {
        long ile;

        ile = 0;

        if(Nagłówek != null) ile = Nagłówek.getCzęstotliwośćBajtową();

        return ile;
    }//Koniec metody zwracającej liczbę bitów

    /**
     * Metoda zwracająca wielkość nagłówka (minimum 44 bajty).
     * @return 0, gdy nie ma nagłówka, wartosć 44 lub większą, gdy nagłówek jest.
     */
    public int getWielkośćNagłówka()
    {
        int ile_bajtów;

        ile_bajtów = 0;

        if(Nagłówek != null) ile_bajtów = Nagłówek.getBajtyNagłówka().length;

        return ile_bajtów;
    }//Koniec metody zwracającek wielkość nagłówka

    /**
     * Metoda zwraca wielkość danych dźwiękowych w pliku wave.
     *
     * Wartość ta jest istotna, gdyż wave może przechowywać różne dane, nie tylko dźwięk.
     * @return 0, gdy nie ma nagłówka, wartość większa od 0, gdy nagłówek jest i dane dźwiękowe również są obecne w pliku.
     */
    public long getWielkośćBlokuDanych()
    {
        long ile;

        ile = 0;

        if(Nagłówek != null) ile = Nagłówek.getDługośćBlokuDanychSygnału();

        return ile;
    }//Koniec metody zwracającej wielkość bloku z danymi

    /**
     * Metoda zwracająca dodatkowe parametry z nagłówka (może być cokolwiek, byle ASCII).
     * @return "", gdy nic nie ma (może nie być nagłówka, ale też parametrów dodatkowych).
     */
    public String getDodatkoweParametry()
    {
        String Dodatki;

        Dodatki = "";

        if(Nagłówek != null) Dodatki = Nagłówek.getDodatkoweParametry();

        return Dodatki;
    }//Koniec metody zwracającej dodatkowe parametry

    /**
     * Metoda zwracająca częstotliwość próbkowania.
     * @return 0, gdy nie ma nagłówka, albo inną wartość, np. 32000, 44100, 48000 itd. Jednostką jest [Hz].
     */
    public long getCzęstotliwośćPróbkowania()
    {
        long ile;

        ile = 0;

        if(Nagłówek != null) ile = Nagłówek.getCzęstotliwośćPróbkowania();

        return ile;
    }//Koniec metody zwracającej częstotliwość próbkowania


    /**
     * Metoda zwracająca kodowanie audio.
     * @return Kodowanie audio -> dokumentacja klasy NagłówekPlikuWave. Gdy wartość == -1, to oznacza, że nie ma nagłówka.
     */
    public int getKodowanieAudio()
    {
        int kod;

        kod = -1;

        if(Nagłówek != null) kod = Nagłówek.getKodowanieDźwięku();

        return kod;
    }//Koniec metody zwracającej kodowanie audio

    /**
     * Odczyt pojedynczej próbki (wszystkich kanałów) z pliku. Próbki numerujemu od 0.
     * @param k Numer próbki sygnału
     * @return Tablica z danymi, jeżeli się wszystko powiodłow. W innym przypadku <b>null</b>.
     */
    public byte[] getCałąPróbkę(long k)
    {
        byte[] bufor;
        long pozycja;
        long ile_odczytano;

        bufor = null;

        if(PlikNaDysku != null && k < this.getLiczbęPróbek())
        {
            pozycja = (k * (long)Nagłówek.getLiczbęBajtówNaCałąPróbkę()) + (long)this.WielkośćBuforaNagłówka;
            bufor = new byte[Nagłówek.getLiczbęBajtówNaCałąPróbkę()];

            try{
                PlikNaDysku.seek(pozycja);
                ile_odczytano = PlikNaDysku.read(bufor);

                if(ile_odczytano < bufor.length)
                {
                    status = BŁĄD_PODCZAS_ODCZYTU;
                    bufor = null;
                }else
                {
                    status = BRAK_BŁĘDÓW;
                }//end if

            }catch(Exception ex){

                status = BŁĄD_PODCZAS_ODCZYTU;
                bufor = null;

            }//end try-catch
        }//end if


        return bufor;
    }//Koniec pobierania całej próbki;

    /**
     * Metoda zwracająca liczbę próbek w pliku wave.
     * @return Liczba próbek w bloku danych dźwiękowych.
     */
    public long getLiczbęPróbek()
    {
        long liczba;

        liczba = -1;

        if(Nagłówek != null)
        {
            liczba = Nagłówek.getDługośćBlokuDanychSygnału()/(long)Nagłówek.getLiczbęBajtówNaCałąPróbkę();
        }//end if

        return liczba;
    }//Koniec metody zwracającej liczbę próbek


    /**
     * Metoda odczytująca wszystkie próbki sygnału z pliku.
     * <div style="color:red"><b>UWAGA!! Maksymalnie można wczytać 2GB danych!!</b></div>
     * @return dane z pliku. Jeżeli się coś nie powiodło, netoda zwraca wartość <b>null</b>.
     */
    public byte[] getOdczytajWszystkiePróbki()
    {
        byte[] wszystko;
        long ile_odczytano;

        wszystko = null;

        if(PlikNaDysku != null)
        {
            wszystko = new byte[(int)Nagłówek.getDługośćBlokuDanychSygnału()]; //Mniej niż 2GB !!!

            try{
                PlikNaDysku.seek(this.getWielkośćNagłówka());

                ile_odczytano = PlikNaDysku.read(wszystko);

                if(ile_odczytano < wszystko.length)
                {
                    status = BŁĄD_PODCZAS_ODCZYTU;
                    wszystko = null;
                }else
                {
                    status = BRAK_BŁĘDÓW;
                }//end if

            }catch(Exception ex){
                status = BŁĄD_PODCZAS_ODCZYTU;
                wszystko = null;
            }//end try-catch

        }//end if

        return wszystko;
    }//Koniec metody odczytującej wszystkie próbki

    /**
     * Metoda służąca do pobrania kilku próbek z pliku wave.
     * @param k Numer próbki - liczymy od 0.
     * @param ile Liczba próbek do pobrania - liczymy o d 1.
     * @return
     */
    public byte[] PobierzKilkaPróbek(long k, int ile)
    {
        byte[] bufor;
        long pozycja;
        int ile_bajtów;
        long ile_odczytano;

        ile_bajtów = ile * Nagłówek.getLiczbęBajtówNaCałąPróbkę();

        bufor = null;

        if(PlikNaDysku != null && k + ile <= this.getLiczbęPróbek())
        {
            bufor = new byte[ile_bajtów];
            pozycja = (k * (long)Nagłówek.getLiczbęBajtówNaCałąPróbkę()) + this.getWielkośćNagłówka();

            try{
                PlikNaDysku.seek(pozycja);

                ile_odczytano = PlikNaDysku.read(bufor);

                if(ile_odczytano < bufor.length)
                {
                    status = BŁĄD_PODCZAS_ODCZYTU;
                    bufor = null;
                }else
                {
                    status = BRAK_BŁĘDÓW;
                }//end if
            }catch(Exception ex){
                status = BŁĄD_PODCZAS_ODCZYTU;
                bufor = null;
            }
        }//end if

        return bufor;
    }//Koniec metody pobierającej kilka próbek

    /**
     * Metoda służąca do tworzenia nowego pliku.
     *
     * <div style="color:red"><b>UWAGA! Jeżeli plik już istnieje, to zostanie wygenerowany błąd.</b></div>
     * @param LiczbaBitów Liczba bitów w próbce
     * @param LiczbaKanałów Liczba kanałów
     * @param CzęstotliwośćPróbkowania Częstotliwość próbkowania [Hz]
     * @param KodowanieDanych Rodzaj kodowanych danych -> klasa NagłówekPlikuWave
     * @param ParametryDodatkowe Parametry dodatkowe do wpisania.
     */
    public void UtwórzNowyPlik(int LiczbaBitów, int LiczbaKanałów, int CzęstotliwośćPróbkowania, int KodowanieDanych, String ParametryDodatkowe)
    {
        if(PlikNaDyskuFile.exists())
        {
            status = PODANY_PLIK_JUŻ_ISTNIEJE; //Zabezpieczenie przed nadpisaniem
        }else
        {
            Nagłówek = new NagłówekPlikuWave(LiczbaBitów, LiczbaKanałów, CzęstotliwośćPróbkowania, ParametryDodatkowe, KodowanieDanych); //Tworzymy nowy nagłówek

            if(Nagłówek.getPoprawnośćNagłówka().length != 1)
            {
                status = BŁĘDNY_NAGŁÓWEK;
            }else//Gdy nagłówek jest prawidłowy, to rób to, co jest poniżej:
            {
                try{
                    this.PlikNaDysku = new RandomAccessFile(PlikNaDyskuFile,"rw");
                    status = BRAK_BŁĘDÓW;
                }catch(Exception ex){
                    status = NIE_UDAŁO_SIĘ_UTWORZYĆ_PLIKU;
                }

                if(status == BRAK_BŁĘDÓW)
                {
                    try{
                        PlikNaDysku.write(Nagłówek.getBajtyNagłówka());
                    }catch(Exception ex){
                        status = BŁĄD_PODCZAS_ZAPISU;
                    }//end try
                }//end if BRAK_BŁĘDÓW
            }//end if Czy nagłówek jest poprawny

        }//end if PlikNaDyskuFile.exist()

    }//Koniec metody tworzącej nowy plik


    /**
     * Metoda dopisująca dane do pliku Wave.
     * @param dane_do_dopisania Tablica z danymi do zapisania (tablica bajtów)
     */
    public void DopiszDaneDoPliku(byte[] dane_do_dopisania)
    {
        long stara_wielkość_pliku;
        long stara_wielkość_danych_w_nagłówku;
        long nowa_wielkość_danych_w_nagłówku;
        long stara_wielkość_bloku_danych;
        long nowa_wielkość_bloku_danych;
        long nowa_wielkość_pliku;
        byte[] dane_dodatkowe;


        status = BRAK_BŁĘDÓW;
        stara_wielkość_pliku = PlikNaDyskuFile.length();
        dane_dodatkowe = null;

        if(Nagłówek.getRozmiarDanychPlikuWave() + 8 > stara_wielkość_pliku) //Po nieudanej próbie zapisu odtwarzamy nagłówek!
        {
            Nagłówek.setRozmiarDanych(stara_wielkość_pliku - 8);
            dane_dodatkowe = this.OdczytajDanePozaDźwiękiem();

            if(dane_dodatkowe == null)
            {
                Nagłówek.setDługośćBlokuDanychSygnału(stara_wielkość_pliku - this.getWielkośćNagłówka());
            }else
            {
                Nagłówek.setDługośćBlokuDanychSygnału(stara_wielkość_pliku - this.getWielkośćNagłówka() - dane_dodatkowe.length);
            }//end if

        }//end if



        if(Nagłówek != null) //Tylko w tym przypadku warto coś robić!
        {
            stara_wielkość_danych_w_nagłówku = stara_wielkość_pliku - 8;
            nowa_wielkość_danych_w_nagłówku = stara_wielkość_danych_w_nagłówku + (long)dane_do_dopisania.length;

            stara_wielkość_bloku_danych = Nagłówek.getDługośćBlokuDanychSygnału();
            nowa_wielkość_bloku_danych = stara_wielkość_bloku_danych + (long)dane_do_dopisania.length;


            if(status == BRAK_BŁĘDÓW) //Jeżeli odczyt danych zakończył się sukcesem
            {

                Nagłówek.setDługośćBlokuDanychSygnału(nowa_wielkość_bloku_danych);
                Nagłówek.setRozmiarDanych(nowa_wielkość_danych_w_nagłówku);

                try{
                    if(PlikNaDyskuFile.length() > 0) PlikNaDysku.seek(0);

                    PlikNaDysku.write(Nagłówek.getBajtyNagłówka());


                    PlikNaDysku.seek(stara_wielkość_pliku);
                    PlikNaDysku.write(dane_do_dopisania);
                    if(dane_dodatkowe != null) PlikNaDysku.write(dane_dodatkowe);

                    nowa_wielkość_pliku = PlikNaDyskuFile.length();

                    if(nowa_wielkość_pliku != stara_wielkość_pliku + dane_do_dopisania.length)
                    {
                        status = BŁĄD_PODCZAS_ZAPISU;
                    }//end if

                }catch(Exception ex){
                    status = BŁĄD_PODCZAS_ZAPISU;
                }//end try
            }//end if BRAK_BŁĘDÓW
        }//end if Nagłówek != null;

    }//Koniec metody dopisującej do pliku

    /**
     * Metoda służąca do odczytywania danych znajdujących się poza danymi dźwiękowymi, jeżeli oczywiście takie są.
     *
     * Odczytane dane muszą pozostać w pliku w postaci niezmienionej.
     *
     * @return <b>null</b>, gdy nic nie ma, albo tablica bajtów, gdy coś jest.
     */
    private byte[] OdczytajDanePozaDźwiękiem()
    {
        byte[] dodatkowe_dane;
        int ile_dodatkowych_danych;

        long wielkość_nagłówka;
        long wielkość_bloku_danych;
        long wielkość_pliku;

        long pozycja;

        status = BRAK_BŁĘDÓW;

        dodatkowe_dane = null;

        wielkość_nagłówka = this.getWielkośćNagłówka();
        wielkość_bloku_danych = Nagłówek.getDługośćBlokuDanychSygnału();
        wielkość_pliku = PlikNaDyskuFile.length();

        if(wielkość_pliku > wielkość_bloku_danych + wielkość_nagłówka) //To znaczy, że są jakieś dane!
        {
            ile_dodatkowych_danych = (int)(wielkość_pliku - wielkość_bloku_danych - wielkość_nagłówka); //Tego nie może być zbyt dużo!
            dodatkowe_dane = new byte[ile_dodatkowych_danych];

            pozycja = wielkość_nagłówka + wielkość_bloku_danych;

            try{
                PlikNaDysku.seek(pozycja);
                PlikNaDysku.read(dodatkowe_dane);
            }catch(Exception ex){

                status = BŁĄD_PODCZAS_ODCZYTU;
            }//end try-catch

        }//end if

        return dodatkowe_dane;

    }//Koniec metody odczytującej dane poza danymi dźwiękowymi w pliku.



}//Koniec klasy
