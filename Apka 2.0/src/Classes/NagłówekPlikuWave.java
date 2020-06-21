
package Classes;

/**
 * Klasa służąca do obsługiwania nagłówka pliku wave.
 *
 * Klasa ta jest tworzona zarówno z danych strumienia, jak i z bajtów odczytanych z pliku.
 * Udostępniona do użytku przez dr Piotra Wrzeciono
 * @author Piotr Wrzeciono
 * @since 2016.02.17
 */
public class NagłówekPlikuWave
{
    /**************Stałe kodujące rodzaj danych w pliku wave********************************/

    /**Nazwa i wartość stałej przynależą do standardu WAVE. */
    public final static int UNKNOWN = 0x0000;
    /**Nazwa i wartość stałej przynależą do standardu WAVE. */
    public final static int MICROSOFT_ADPCM = 0x0002;
    /**Nazwa i wartość stałej przynależą do standardu WAVE. */
    public final static int PCM = 0x0001;
    /**Nazwa i wartość stałej przynależą do standardu WAVE. */
    public final static int IEEE_FLOATING_POINT = 0x0003;
    /**Nazwa i wartość stałej przynależą do standardu WAVE. */
    public final static int IBM_CVSD = 0x0005;
    /**Nazwa i wartość stałej przynależą do standardu WAVE. */
    public final static int MICROSOFT_ALAW = 0x0006; //M od µ (8-bit ITU-T G.711BA ALAW)
    /**Nazwa i wartość stałej przynależą do standardu WAVE. */
    public final static int MICROSOFT_M_LAW = 0x0007; //M od µ (8-bit ITU-T G.711 M-LAW)
    /**Nazwa i wartość stałej przynależą do standardu WAVE. */
    public final static int INTEL_IMA_DVI_ADPCM= 0x0011;
    /**Nazwa i wartość stałej przynależą do standardu WAVE. */
    public final static int ITU_G723_ADPCM= 0x0016;
    /**Nazwa i wartość stałej przynależą do standardu WAVE. */
    public final static int DIALOGIC_OKI_ADPCM = 0x0017;
    /**Nazwa i wartość stałej przynależą do standardu WAVE. */
    public final static int DOLBY_AAC = 0x0030;
    /**Nazwa i wartość stałej przynależą do standardu WAVE. */
    public final static int MICROSOFT_GSM_V6_POINT10 = 0x0031;
    /**Nazwa i wartość stałej przynależą do standardu WAVE. */
    public final static int ROCKWELL_ADPCM = 0x0036;
    /**Nazwa i wartość stałej przynależą do standardu WAVE. */
    public final static int ITU_G721_ADPCM = 0x0040;
    /**Nazwa i wartość stałej przynależą do standardu WAVE. */
    public final static int MICROSOFT_MSG723 = 0x0042;
    /**Nazwa i wartość stałej przynależą do standardu WAVE. */
    public final static int ITU_T_G726 = 0x0045;
    /**Nazwa i wartość stałej przynależą do standardu WAVE. */
    public final static int APICOM_G726_ADPCM = 0x0064;
    /**Nazwa i wartość stałej przynależą do standardu WAVE. */
    public final static int IBM_M_LAW = 0x0101;  // M od µ
    /**Nazwa i wartość stałej przynależą do standardu WAVE. */
    public final static int IBM_A_LAW = 0x0102;
    /**Nazwa i wartość stałej przynależą do standardu WAVE. */
    public final static int IBM_ADPCM = 0x0103;

    /***************************************************************************************/

    /**************Stałe służące do komunikowania kontroli poprawności nagłówka*************/

    /**Wszystkie dane w nagłówku (które można sprawdzić) są prawidłowe. */
    public static final int WSZYSTKO_PRAWIDŁOWE = 0;
    /**Początek pliku ('RIFF') jest we właściwym miejscu. */
    public static final int RIFF_PRAWIDŁOWY = 1;
    /**'RIFF' nie został odnaleziony. */
    public static final int RIFF_NIEPRAWIDŁOWY = 2;
    /**'WAVE' jest na swoim miejscu. */
    public static final int WAVE_PRAWIDŁOWY = 3;
    /**'WAVE' nie został odnaleziony. */
    public static final int WAVE_NIEPRAWIDŁOWY = 4;
    /**'fmt ' jest tak, gdzie powinien być. */
    public static final int fmt_PRAWIDŁOWY = 5;
    /**Nie znaleziono 'fmt '. */
    public static final int fmt_NIEPRAWIDŁOWY = 6;
    /**Wpisana (podana) częstotliwość bajtów jest obliczona prawidłowo. */
    public static final int CZĘSTOTLIWOŚĆ_BAJTÓW_PRAWIDŁOWA = 7;
    /**Wpisana (podana) częstotliwość bajtów jest nieprawidłowa. */
    public static final int CZĘSTOTLIWOŚĆ_BAJTÓW_NIEPRAWIDŁOWA = 8;
    /**Wyliczony (podany) rozmiar próbki jest prawidłowy. */
    public static final int ROZMIAR_PRÓBKI_PRAWIDŁOWY = 9;
    /**Wyliczony (podany) rozmiar próbki jest nieprawidłowy. */
    public static final int ROZMIAR_PRÓBKI_NIEPRAWIDŁOWY = 10;
    /**Liczba bitów jest wielokrotnością liczby 8. */
    public static final int ROZDZIELCZOŚĆ_PRAWIDŁOWA = 11;
    /**Liczba bitów nie jest wielokrotnością liczby 8. */
    public static final int ROZDZIELCZOŚĆ_NIEPRAWIDŁOWA = 12;
    /**'data' znajduje się na właściwym miejscu. */
    public static final int data_PRAWIDŁOWA = 13;
    /**'data' nie znajduje się na właściwym miejscu. */
    public static final int data_NIEPRAWIDŁOWA = 14;

    /***************************************************************************************/


    /**Pierwszy element nagłówka - 2 bajty, zawierają tekst 'RIFF'. */
    private byte[] ID_1;
    /**Drugi element nagłówka - 4 bajty, rozmiar danych z pominięciem pierwszych 8 bajtów nagłówka - typ unsigned int small endian. Po dopisie danych wymaga modyfikacji.*/
    private byte[] RozmiarDanych_2;
    /**Trzeci element nagłówka - 4 bajty, zawierają tekst 'WAVE'. */
    private byte[] FormatID_3;
    /**Czwarty element nagłówka - 4 bajty, zawierają tekst 'fmt '. */
    private byte[] OpisID_4;
    /**Piąty element nagłówka - 4 bajty, rozmiar części opisowej, zwykle wynosi 18 a minimalna wartość to 16. Typ int, small endian. Jest to rozmiar będący sumą elementów: 6,7,8,9,10,11,12. */
    private byte[] RozmiarOpisu_5;
    /**Szósty element nagłówka - 2 bajty (short), dla sygnału PCM wynosi 1 - też small endian. */
    private byte[] FormatAudio_6;
    /**Siódmy element nagłówka - 2 bajty (short) - liczba kanałów w pliku. Kodowanie - small endian.*/
    private byte[] LiczbaKanałów_7;
    /**Ósmy element nagłówka - 4 bajty (int) - częstotliwość próbkowania f<sub>s</sub> [Hz]. Kodowanie - small endian.*/
    private byte[] CzęstotliwośćPróbkowania_8;
    /**Dziewiąty element nagłówka - 4 bajty (int) - f<sub>s</sub> * liczba kanałów * liczba bitów w próbce / 8. */
    private byte[] CzęstotliwośćBajtów_9;
    /**Dziesiąty element nagłówka - 2 bajty (short) - Liczba kanałów *  liczba bitów w próbce / 8. Też small endian. */
    private byte[] RozmiarPróbki_10;
    /**Jedenasty element nagłówka - 2 bajty (short) small endian - Liczba bitów w próbce (pojedynczy kanał!). */
    private byte[] LiczbaBitówWPróbce_11;
    /**Dwunasty element nagłówka - Dodatkowe parametry (może być cokolwiek) o dowolnej długości. Uwaga Dane kończą się tekstem: 'data'. */
    private byte[] DodatkoweParametry_12;
    /**Trzynasty element nagłówka Tekst 'data' kończący pole nagłówka. */
    private byte[] DaneID_13;
    /**Czternasty element nagłówka 4 bajty (int) unsigned, small endian - Rozmiar danych = Rozmiar pliku - rozmiar nagłówka (włącznie z 'data') - 4 (na rozmiar tego pola).
     * <br>Uwaga! Rozmiar danych może być mniejszy od normalnego przypadku. Na przykład znaczniki zapisywane są po wszystkich danych muzycznych. Wtedy rozmiar danych jest mnieszy od przykładu podanego powyżej. */
    private byte[] RozmiarBlokuDanych_14;

    /**
     * Metoda zamieniająca String na tablicę bajtów.
     * @param Tekst Tekst do zamiany
     * @return tablica bajtowa.
     */
    private byte[] ZamieńStringNaBajty(String Tekst)
    {
        byte[] bajty_ascii;
        int i;
        int znak;
        char[] ZnakiZTekstu;

        ZnakiZTekstu = Tekst.toCharArray();

        bajty_ascii = new byte[ZnakiZTekstu.length];

        for(i = 0; i < bajty_ascii.length; i++)
        {
            znak = (int)ZnakiZTekstu[i];

            if(znak < 127) bajty_ascii[i] = (byte)znak; else bajty_ascii[i]=32; //Albo tekst, albo spacje!
        }//next i

        return bajty_ascii;
    }//Koniec metody zamieniającej String na bajty

    /**
     * Metoda tworząca nagłówek bajtowy (gotowy do zapisu w pliku wave).
     * @return Nagłówek pliku wave w postaci tablicy bajtów.
     */
    private byte[] TwórzNagłówekBajtowy()
    {
        byte[] dane_nagłówka;
        int ile_bajtów;
        int licznik_bitów;
        int i;

        ile_bajtów  = this.ID_1.length + this.RozmiarDanych_2.length + this.FormatID_3.length + this.OpisID_4.length;
        ile_bajtów += this.RozmiarOpisu_5.length + this.FormatAudio_6.length + this.LiczbaKanałów_7.length;
        ile_bajtów += this.CzęstotliwośćPróbkowania_8.length + this.CzęstotliwośćBajtów_9.length;
        ile_bajtów += this.RozmiarPróbki_10.length + this.LiczbaBitówWPróbce_11.length;
        if(this.DodatkoweParametry_12 != null) ile_bajtów += this.DodatkoweParametry_12.length;
        ile_bajtów += this.DaneID_13.length + this.RozmiarBlokuDanych_14.length;

        dane_nagłówka = new byte[ile_bajtów];
        licznik_bitów = 0;

        for(i = 0; i < this.ID_1.length; i++){dane_nagłówka[licznik_bitów] = this.ID_1[i]; licznik_bitów++;}
        for(i = 0; i < this.RozmiarDanych_2.length; i++){dane_nagłówka[licznik_bitów] = this.RozmiarDanych_2[i]; licznik_bitów++;}
        for(i = 0; i < this.FormatID_3.length; i++){dane_nagłówka[licznik_bitów] = this.FormatID_3[i]; licznik_bitów++;}
        for(i = 0; i < this.OpisID_4.length; i++){dane_nagłówka[licznik_bitów] = this.OpisID_4[i]; licznik_bitów++;}
        for(i = 0; i < this.RozmiarOpisu_5.length; i++){dane_nagłówka[licznik_bitów] = this.RozmiarOpisu_5[i]; licznik_bitów++;}
        for(i = 0; i < this.FormatAudio_6.length; i++){dane_nagłówka[licznik_bitów] = this.FormatAudio_6[i]; licznik_bitów++;}
        for(i = 0; i < this.LiczbaKanałów_7.length; i++){dane_nagłówka[licznik_bitów] = this.LiczbaKanałów_7[i]; licznik_bitów++;}
        for(i = 0; i < this.CzęstotliwośćPróbkowania_8.length; i++){dane_nagłówka[licznik_bitów] = this.CzęstotliwośćPróbkowania_8[i]; licznik_bitów++;}
        for(i = 0; i < this.CzęstotliwośćBajtów_9.length; i++){dane_nagłówka[licznik_bitów] = this.CzęstotliwośćBajtów_9[i]; licznik_bitów++;}
        for(i = 0; i < this.RozmiarPróbki_10.length; i++){dane_nagłówka[licznik_bitów] = this.RozmiarPróbki_10[i]; licznik_bitów++;}
        for(i = 0; i < this.LiczbaBitówWPróbce_11.length; i++){dane_nagłówka[licznik_bitów] = this.LiczbaBitówWPróbce_11[i]; licznik_bitów++;}
        if(this.DodatkoweParametry_12 != null) for(i = 0; i < this.DodatkoweParametry_12.length; i++){dane_nagłówka[licznik_bitów] = this.DodatkoweParametry_12[i]; licznik_bitów++;}
        for(i = 0; i < this.DaneID_13.length; i++){dane_nagłówka[licznik_bitów] = this.DaneID_13[i]; licznik_bitów++;}
        for(i = 0; i < this.RozmiarBlokuDanych_14.length; i++){dane_nagłówka[licznik_bitów] = this.RozmiarBlokuDanych_14[i]; licznik_bitów++;}

        return dane_nagłówka;
    }//Koniec metody tworzącej nagłówej bajtowy do zapisu.

    /**
     * Metoda zwracająca nagłówek w postaci bajtowej (na zewnątrz).
     * @return Nagłówek pliku wave w postaci gotowej do zapisu.
     */
    public byte[] getBajtyNagłówka()
    {
        return this.TwórzNagłówekBajtowy();
    }//Koniec metody zwracającej bajty nagłówka

    /**
     * Pierwszy konstruktor tworzący nagłówkek dla pustego pliku wave.
     * @param LiczbaBitów Liczba bitów (rozdzielczość bitowa) sygnału
     * @param LiczbaKanałów Liczba kanałów w sygnale
     * @param CzęstotliwośćPróbkowania CzęstotliwośćPróbkowania [Hz]
     * @param DodatkoweParametryDoWpisania  Dodatkowe parametry do wpisania - tylko ASCII!!!!
     * @param RodzajKodowaniaDanych Tutaj należy podać rodzaj kodowania danych - ze stałych zdefiniowanych na początku klasy
     */
    public NagłówekPlikuWave(int LiczbaBitów, int LiczbaKanałów, int CzęstotliwośćPróbkowania, String DodatkoweParametryDoWpisania, int RodzajKodowaniaDanych)
    {
        long CzęstotliwośćBajtów;
        int RozmiarPróbki;
        byte[] DodatkoweParametryDoWpisywaniaTab;
        int WyliczonyRozmiarOpisu;
        byte[] TymczasowyNagłówekBajtowy;

        InicjalizacjaPodstawowychElementówNagłówka();

        this.FormatAudio_6 = LittleBigEndian.ZamieńUnsignedShortNaTablicęLittleEndian(RodzajKodowaniaDanych);

        RozmiarPróbki = LiczbaKanałów * LiczbaBitów/8;
        CzęstotliwośćBajtów = LiczbaKanałów * CzęstotliwośćPróbkowania * LiczbaBitów/8;
        if(DodatkoweParametryDoWpisania.length() > 0)
        {
            DodatkoweParametryDoWpisywaniaTab = this.ZamieńStringNaBajty(DodatkoweParametryDoWpisania);
        }else
        {
            DodatkoweParametryDoWpisywaniaTab = new byte[2]; //Typowo dwa bajty na parametry extra
        }//end if

        WyliczonyRozmiarOpisu = 16 + DodatkoweParametryDoWpisywaniaTab.length;

        this.RozmiarOpisu_5 = LittleBigEndian.ZamieńSignedIntNaTablicęLittleEndian(WyliczonyRozmiarOpisu);
        this.LiczbaKanałów_7 = LittleBigEndian.ZamieńUnsignedShortNaTablicęLittleEndian(LiczbaKanałów);
        this.CzęstotliwośćPróbkowania_8 = LittleBigEndian.ZamieńUnsignedIntNaTablicęLittleEndian(CzęstotliwośćPróbkowania);
        this.CzęstotliwośćBajtów_9 = LittleBigEndian.ZamieńUnsignedIntNaTablicęLittleEndian(CzęstotliwośćBajtów);
        this.RozmiarPróbki_10 = LittleBigEndian.ZamieńUnsignedShortNaTablicęLittleEndian(RozmiarPróbki);
        this.LiczbaBitówWPróbce_11 = LittleBigEndian.ZamieńUnsignedShortNaTablicęLittleEndian(LiczbaBitów);
        this.DodatkoweParametry_12 = DodatkoweParametryDoWpisywaniaTab;

        TymczasowyNagłówekBajtowy = this.TwórzNagłówekBajtowy();

        this.RozmiarDanych_2 = LittleBigEndian.ZamieńUnsignedIntNaTablicęLittleEndian(TymczasowyNagłówekBajtowy.length - 8);

    }//Koniec konstruktora

    /**
     * Konstruktor tworzący instancję klasy na podstawie danych odczytanych z pliku (tablica bajtowa).
     * @param TablicaBajtowaZNagłówkiem Dane odczytane z pliku.
     */
    public NagłówekPlikuWave(byte[] TablicaBajtowaZNagłówkiem)
    {
        int liczba_bajtów_dodatkowych_parametrów;
        byte[] długość_wyliczonego_rozmiaru_opisu;
        int przesunięcie;

        this.InicjalizacjaPodstawowychElementówNagłówka();

        długość_wyliczonego_rozmiaru_opisu = this.PrzepiszFragmentTablicy(TablicaBajtowaZNagłówkiem, 16, 19);
        liczba_bajtów_dodatkowych_parametrów = (int) LittleBigEndian.UtwórzUnsignedIntZLittleEndian(długość_wyliczonego_rozmiaru_opisu) - 16;

        this.ID_1 = this.PrzepiszFragmentTablicy(TablicaBajtowaZNagłówkiem, 0, 3);
        this.RozmiarDanych_2 = this.PrzepiszFragmentTablicy(TablicaBajtowaZNagłówkiem, 4, 7);
        this.FormatID_3 = this.PrzepiszFragmentTablicy(TablicaBajtowaZNagłówkiem, 8, 11);
        this.OpisID_4 = this.PrzepiszFragmentTablicy(TablicaBajtowaZNagłówkiem, 12, 15);
        this.RozmiarOpisu_5 = this.PrzepiszFragmentTablicy(TablicaBajtowaZNagłówkiem, 16, 19);
        this.FormatAudio_6 = this.PrzepiszFragmentTablicy(TablicaBajtowaZNagłówkiem, 20, 21);
        this.LiczbaKanałów_7 = this.PrzepiszFragmentTablicy(TablicaBajtowaZNagłówkiem, 22, 23);
        this.CzęstotliwośćPróbkowania_8 = this.PrzepiszFragmentTablicy(TablicaBajtowaZNagłówkiem, 24, 27);
        this.CzęstotliwośćBajtów_9 = this.PrzepiszFragmentTablicy(TablicaBajtowaZNagłówkiem, 28, 31);
        this.RozmiarPróbki_10 = this.PrzepiszFragmentTablicy(TablicaBajtowaZNagłówkiem, 32, 33);
        this.LiczbaBitówWPróbce_11 = this.PrzepiszFragmentTablicy(TablicaBajtowaZNagłówkiem, 34, 35);

        if(liczba_bajtów_dodatkowych_parametrów == 0)
        {
            this.DodatkoweParametry_12 = null;
        }else
        {
            this.DodatkoweParametry_12 = this.PrzepiszFragmentTablicy(TablicaBajtowaZNagłówkiem, 36, 36 + liczba_bajtów_dodatkowych_parametrów - 1);
            //Gdy jest jeden bajt, to idneks początkowy równa się końcowemu!
        }//end if

        przesunięcie = 36 + liczba_bajtów_dodatkowych_parametrów;

        this.DaneID_13 = this.PrzepiszFragmentTablicy(TablicaBajtowaZNagłówkiem, przesunięcie, przesunięcie + 3);
        this.RozmiarBlokuDanych_14 = this.PrzepiszFragmentTablicy(TablicaBajtowaZNagłówkiem, przesunięcie + 4, przesunięcie + 4 + 3);

    }//Koniec konstruktora dekodującego nagłówek pliku wave

    /**
     * Metoda służąca do pobierania wybranego fragmentu tablicy byte[]
     * @param Tablica Tablica
     * @param IndeksPoczątkowy Indeks początkowy
     * @param IndeksKońcowy Indeks końcowy
     * @return
     */
    private byte[] PrzepiszFragmentTablicy(byte[] Tablica, int IndeksPoczątkowy, int IndeksKońcowy)
    {
        int i;
        int ile_elementów;
        int j;
        byte[] tablica_krótsza;

        ile_elementów = IndeksKońcowy - IndeksPoczątkowy + 1;
        j = 0;
        tablica_krótsza = new byte[ile_elementów];

        for(i = IndeksPoczątkowy; i <= IndeksKońcowy; i++)
        {
            tablica_krótsza[j] = Tablica[i];
            j++;
        }//next i


        return tablica_krótsza;
    }//Koniec metody pobierającej fragment tablicy byte.

    /**
     * Metoda sprawdzająca, czy tablice są takie same (pod względem zawartości)
     * @param Tablica1
     * @param Tablica2
     * @return <b>true</b> gdy są identyczne, <b>false</b> gdy są różne.
     */
    private boolean CzyTabliceSąTakieSame(byte[] Tablica1, byte[] Tablica2)
    {
        int długość1;
        int długość2;
        boolean wynik;
        int i;

        wynik = false;

        długość1 = Tablica1.length;
        długość2 = Tablica2.length;

        if(długość1 == długość2) //teraz sprawdzamy
        {
            wynik = true;
            i = 0;
            do{
                if(Tablica1[i] != Tablica2[i]) wynik = false;
                i++;
            }while((i < długość1) && (wynik == true));

        }//end if

        return wynik;
    }//Koniec metody porównującej ze sobą tablice

    /**
     * Metoda służąca do inicjalizacji domyślnych bajtów nagłówka pliku wave.
     */
    private void InicjalizacjaPodstawowychElementówNagłówka()
    {
        this.ID_1 = ZamieńStringNaBajty("RIFF");
        this.RozmiarDanych_2 = new byte[4];
        this.FormatID_3 = ZamieńStringNaBajty("WAVE");
        this.OpisID_4 = ZamieńStringNaBajty("fmt ");
        this.RozmiarOpisu_5 = LittleBigEndian.ZamieńSignedIntNaTablicęLittleEndian(18);
        this.FormatAudio_6 = LittleBigEndian.ZamieńShortNaTablicęLittleEndian((short)1); //Kod PCM bez kompresji - na razie nic innego nie wchodzi w grę!
        this.LiczbaKanałów_7 = new byte[2];
        this.CzęstotliwośćPróbkowania_8 = new byte[4];
        this.CzęstotliwośćBajtów_9 = new byte[4];
        this.RozmiarPróbki_10 = new byte[2];
        this.LiczbaBitówWPróbce_11 = new byte[2];
        this.DodatkoweParametry_12 = new byte[2]; //Typowo dwa bajty na ekstra dane - możliwość zmiany.
        this.DaneID_13 = ZamieńStringNaBajty("data");
        this.RozmiarBlokuDanych_14 = new byte[4];
    }//Koniec metody inicjalizującej podstawowe elementy nagłówka.

    /**
     * Metoda sprawdzająca, czy 'RIFF' jest na swoim miejscu.
     * @return <b>true</b> gdy jest wszystko w porządku, <b>false</b>, gdy 'RIFF' nie został znaleziony.
     */
    private boolean CzyRIFFjestPrawidłowy()
    {
        boolean wynik;

        wynik = this.CzyTabliceSąTakieSame(this.ID_1, this.ZamieńStringNaBajty("RIFF"));

        return wynik;
    }//Koniec sprawdzania, czy RIFF jest prawidłowy

    /**
     * Metoda sprawdzająca, czy 'WAVE' jest na prawidłowej pozycji.
     * @return <b>true</b> gdy jest wszystko w porządku, <b>false</b>, gdy 'WAVE' nie został znaleziony.
     */
    private boolean CzyWAVEjestPrawidłowy()
    {
        boolean wynik;

        wynik = this.CzyTabliceSąTakieSame(this.FormatID_3, this.ZamieńStringNaBajty("WAVE"));

        return wynik;
    }//Koniec sprawdzania, czy WAVE jest prawidłowy

    /**
     * Metoda sprawdzająca, czy 'fmt ' jest na właściwej pozycji.
     * @return <b>true</b> gdy jest wszystko w porządku, <b>false</b>, gdy 'fmt ' nie został znaleziony.
     */
    private boolean Czy_fmt_jestPrawidłowe()
    {
        boolean wynik;

        wynik = this.CzyTabliceSąTakieSame(this.OpisID_4, this.ZamieńStringNaBajty("fmt "));

        return wynik;
    }//Koniec metody sprawdzającej, czy 'fmt ' jest prawidłowe

    /**
     * Metoda sprawdzająca poprawność częstotliwości bajtowej (liczba bajtów/sekundę).
     * @return <b>true</b> gdy jest wszystko w porządku, <b>false</b>, gdy częstotliwość bajtowa jest nieprawidłowa.
     */
    private boolean CzyCzęstotliwośćBajtowaJestPrawidłowa()
    {
        int CzęstotliwośćPróbkowania;
        long CzęstotliwośćBajtowa;
        long OdczytanaCzęstotliwośćBajtowa;
        int LiczbaBajtów;

        CzęstotliwośćPróbkowania = this.getCzęstotliwośćPróbkowania();
        OdczytanaCzęstotliwośćBajtowa = this.getCzęstotliwośćBajtową();
        LiczbaBajtów = this.getLiczbęBajtówNaCałąPróbkę(); //Liczba bajtów na całą próbkę uwzględnia liczbę kanałów!

        CzęstotliwośćBajtowa = LiczbaBajtów * CzęstotliwośćPróbkowania;

        return CzęstotliwośćBajtowa == OdczytanaCzęstotliwośćBajtowa;

    }//Koniec metody sprawdzającej, czy częśtotliwość bajtowa jest prawidłowa

    /**
     * Metoda sprawdzająca, czy rozmiar próbki jest prawidłowy (wyrażony w bajtach).
     * @return <b>true</b> gdy jest wszystko w porządku, <b>false</b>, gdy rozmiar jest nieprawidłowy.
     */
    private boolean CzyRozmiarPróbkiJestPrawidłowy()
    {
        return ((this.getLiczbęKanałów() * this.getLiczbęBitów()/8) == this.getLiczbęBajtówNaCałąPróbkę());
    }//Koniec sprawdzania, czy rozmiar próbki jest prawidłowy

    /**
     * Metoda sprawdzającam czy liczba bitów (rozdzielczość bitowa) jest wielokrotnością liczby 8.
     * @return <b>true</b> gdy jest wszystko w porządku, <b>false</b>, gdy liczba bitów jest nieprawidłowa.
     */
    private boolean CzyLiczbaBitówJestPrawidłowa()
    {
        return (this.getLiczbęBitów() % 8) == 0;
    }//Koniec sprawdzania, czy liczba bitów jest prawidłowa (wielokrotność 8)

    /**
     * Metoda spradzająca, czy 'data' jest na właściwej pozycji.
     * @return <b>true</b> gdy jest wszystko w porządku, <b>false</b>, gdy tekst 'data ' nie został znaleziony.
     */
    private boolean Czy_data_jestPrawidłowa()
    {
        boolean wynik;

        wynik = this.CzyTabliceSąTakieSame(this.DaneID_13, this.ZamieńStringNaBajty("data"));

        return wynik;
    }//Koniec sprawdzania, czy RIFF jest prawidłowy

    /**
     * Metoda sprawdzająca kompleksowo poprawność nagłówka.
     * @return tablica ze stanem poprawności nagłówka. Jeżeli wszystko jest poprawne, tablica jest jednoelementowa. W innym przypadku tablica ma 8 elementów.
     * Dokładny opis komunikatów jest w JavaDoc dotyczących publicznych stałych klasy.
     */
    public int[] getPoprawnośćNagłówka()
    {
        boolean PoprawneRIFF;
        boolean PoprawneWAVE;
        boolean Poprawne_fmt;
        boolean PoprawnaCzęstotliwośćBajtów;
        boolean PoprawnyRozmiarPróbki;
        boolean PoprawnaRozdzielczośćBajtowa;
        boolean Poprawne_data;

        int[] rezultat;
        boolean[] wyniki;
        int i;
        int ile_błędów;

        wyniki = new boolean[7];

        PoprawneRIFF = this.CzyRIFFjestPrawidłowy();
        PoprawneWAVE = this.CzyWAVEjestPrawidłowy();
        Poprawne_fmt = this.Czy_fmt_jestPrawidłowe();
        PoprawnaCzęstotliwośćBajtów = this.CzyCzęstotliwośćBajtowaJestPrawidłowa();
        PoprawnyRozmiarPróbki = this.CzyRozmiarPróbkiJestPrawidłowy();
        PoprawnaRozdzielczośćBajtowa = this.CzyLiczbaBitówJestPrawidłowa();
        Poprawne_data = this.Czy_data_jestPrawidłowa();

        wyniki[0] = PoprawneRIFF;
        wyniki[1] = PoprawneWAVE;
        wyniki[2] = Poprawne_fmt;
        wyniki[3] = PoprawnaCzęstotliwośćBajtów;
        wyniki[4] = PoprawnyRozmiarPróbki;
        wyniki[5] = PoprawnaRozdzielczośćBajtowa;
        wyniki[6] = Poprawne_data;

        ile_błędów = 0;

        for(i = 0; i < wyniki.length; i++) if(!wyniki[i]) ile_błędów++;

        if(ile_błędów == 0)
        {
            rezultat = new int[1];
            rezultat[0] = NagłówekPlikuWave.WSZYSTKO_PRAWIDŁOWE;
        }else
        {
            rezultat = new int[wyniki.length];

            for(i = 0; i < rezultat.length; i++)
            {
                if(i == 0) //RIFF
                {
                    if(!wyniki[0]) rezultat[0] = NagłówekPlikuWave.RIFF_NIEPRAWIDŁOWY; else rezultat[0] = NagłówekPlikuWave.RIFF_PRAWIDŁOWY;
                }//end if

                if(i == 1) //WAVE
                {
                    if(!wyniki[1]) rezultat[1] = NagłówekPlikuWave.WAVE_NIEPRAWIDŁOWY; else rezultat[1] = NagłówekPlikuWave.WAVE_PRAWIDŁOWY;
                }//end if

                if(i == 2) //'fmt '
                {
                    if(!wyniki[2]) rezultat[2] = NagłówekPlikuWave.fmt_NIEPRAWIDŁOWY; else rezultat[2] = NagłówekPlikuWave.fmt_PRAWIDŁOWY;
                }//end if

                if(i == 3) //Poprawna częstotliwość bajtowa
                {
                    if(!wyniki[3]) rezultat[3] = NagłówekPlikuWave.CZĘSTOTLIWOŚĆ_BAJTÓW_NIEPRAWIDŁOWA; else rezultat[3] = NagłówekPlikuWave.CZĘSTOTLIWOŚĆ_BAJTÓW_PRAWIDŁOWA;
                }//end if

                if(i == 4) //Rozmiar próbki
                {
                    if(!wyniki[4]) rezultat[4] = NagłówekPlikuWave.ROZMIAR_PRÓBKI_NIEPRAWIDŁOWY; else rezultat[4] = NagłówekPlikuWave.ROZMIAR_PRÓBKI_PRAWIDŁOWY;
                }//end if

                if(i == 5) //Rozdzielczość bitowa
                {
                    if(!wyniki[5]) rezultat[5] = NagłówekPlikuWave.ROZDZIELCZOŚĆ_NIEPRAWIDŁOWA; else rezultat[5] = NagłówekPlikuWave.ROZDZIELCZOŚĆ_PRAWIDŁOWA;
                }//end if

                if(i == 6) //Słowo kluczowe 'data'
                {
                    if(!wyniki[6]) rezultat[6] = NagłówekPlikuWave.data_NIEPRAWIDŁOWA; else rezultat[6] = NagłówekPlikuWave.data_PRAWIDŁOWA;
                }//end if

            }//next i

        }//end if


        return rezultat;
    }//Koniec metody sparawdzającej poprawność nagłówka

    /**
     * Metoda zwracająca opis komunikatów.
     * @param i Tu podstawiamy którąś ze stałych.
     * @return Otrzymujemy opis danej stałej.
     */
    public static String OpisStałych(int i)
    {
        String opis;

        opis = "";

        if(i == NagłówekPlikuWave.WSZYSTKO_PRAWIDŁOWE) opis = "Nagłówek całkowicie poprawny";
        if(i == NagłówekPlikuWave.RIFF_PRAWIDŁOWY) opis = "RIFF jest prawidłowy";
        if(i == NagłówekPlikuWave.RIFF_NIEPRAWIDŁOWY) opis = "RIFF jest nieprawidłowy";
        if(i == NagłówekPlikuWave.WAVE_PRAWIDŁOWY) opis = "WAVE jest prawidłowy";
        if(i == NagłówekPlikuWave.WAVE_NIEPRAWIDŁOWY) opis = "WAVE jest nieprawidłowy";
        if(i == NagłówekPlikuWave.fmt_PRAWIDŁOWY) opis = "'fmt ' jest prawidłowy";
        if(i == NagłówekPlikuWave.fmt_NIEPRAWIDŁOWY) opis = "'fmt ' jest nieprawidłowy";
        if(i == NagłówekPlikuWave.CZĘSTOTLIWOŚĆ_BAJTÓW_PRAWIDŁOWA) opis = "Częstotliwość bajtowa jest prawidłowa";
        if(i == NagłówekPlikuWave.CZĘSTOTLIWOŚĆ_BAJTÓW_NIEPRAWIDŁOWA) opis = "Częstotliwość bajtowa jest nieprawidłowa";
        if(i == NagłówekPlikuWave.ROZMIAR_PRÓBKI_PRAWIDŁOWY) opis = "Rozmiar próbki jest prawidłowy";
        if(i == NagłówekPlikuWave.ROZMIAR_PRÓBKI_NIEPRAWIDŁOWY) opis = "Rozmiar próbki jest nieprawidłowy";
        if(i == NagłówekPlikuWave.ROZDZIELCZOŚĆ_PRAWIDŁOWA) opis = "Rozdzielczość bitowa jest prawidłowa";
        if(i == NagłówekPlikuWave.ROZDZIELCZOŚĆ_NIEPRAWIDŁOWA) opis = "Rozdzielczość bitowa jest nieprawidłowa";
        if(i == NagłówekPlikuWave.data_PRAWIDŁOWA) opis = "'data' jest prawidłowa";
        if(i == NagłówekPlikuWave.data_NIEPRAWIDŁOWA) opis = "'data' jest nieprawidłowa";

        return opis;
    }//Koniec opisu stałych

    /**
     * Metoda zwracająca częstiotliwość próbkowania.
     * @return Częstotliwość próbkowania [Hz].
     */
    public int getCzęstotliwośćPróbkowania()
    {
        int wynik;

        wynik = (int) LittleBigEndian.UtwórzUnsignedIntZLittleEndian(this.CzęstotliwośćPróbkowania_8);

        return wynik;
    }//Koniec metody zwracającej częstotliwość próbkowania

    /**
     * Metoda zwracająca częstotliwość bajtową.
     * @return Częstotliwość bajtowa [bajty/s].
     */
    public long getCzęstotliwośćBajtową()
    {
        long wynik;

        wynik = LittleBigEndian.UtwórzUnsignedIntZLittleEndian(this.CzęstotliwośćBajtów_9);

        return wynik;
    }//Koniec metody zwracającej częstotliwość bajtową

    /**
     * Metoda zwracająca liczbę bitów (rozdzielczość bitową sygnału).
     * @return Liczba bitów (8, 16, 24 lub 32).
     */
    public int getLiczbęBitów()
    {
        int wynik;

        wynik = LittleBigEndian.UtwórzUnsignedShortZLittleEndian(this.LiczbaBitówWPróbce_11);

        return wynik;
    }//Koniec metody zwracającej liczbę bitów w próbce

    /**
     * Metoda zwracająca liczbę kanałów w pliku wave.
     * @return Liczba kanałów.
     */
    public int getLiczbęKanałów()
    {
        int wynik;

        wynik = LittleBigEndian.UtwórzUnsignedShortZLittleEndian(this.LiczbaKanałów_7);

        return wynik;

    }//Koniec metody zwracającej liczbę kanałów

    /**
     * Metoda zwracająca liczbę bajtów na każdą próbkę (konieczne w trakcie odczytu!)
     * @return Liczba bajtów na próbkę.
     */
    public int getLiczbęBajtówNaCałąPróbkę()
    {
        int wynik;

        wynik = LittleBigEndian.UtwórzUnsignedShortZLittleEndian(this.RozmiarPróbki_10);

        return wynik;
    }//Koniec metody zwracającej liczbę bajtów na całą próbkę

    /**
     * Metoda zwracająca dodatkowe parametry z pliku wave.
     * @return Dodatkowe parametry z nagłówka.
     */
    public String getDodatkoweParametry()
    {
        String wynik;
        char[] TablicaZnaków;
        int i;

        wynik = "";

        if(this.DodatkoweParametry_12 != null)
        {
            TablicaZnaków = new char[this.DodatkoweParametry_12.length];

            for(i = 0; i < this.DodatkoweParametry_12.length;i++)
            {
                TablicaZnaków[i] = (char)this.DodatkoweParametry_12[i];
            }//next i

            wynik = String.copyValueOf(TablicaZnaków);
        }//end if

        return wynik;
    }//Koniec metody zwracającej dodatkowe parametry

    /**
     * Metoda zwracająca długość bloku danych sygnału. Uwaga! Przy dopisywaniu danych do pliku wave, dana ta musi być modyfikowana!
     * @return Długość bloku sygnału [B].
     */
    public long getDługośćBlokuDanychSygnału()
    {
        long wynik;

        wynik = LittleBigEndian.UtwórzUnsignedIntZLittleEndian(this.RozmiarBlokuDanych_14);

        return wynik;
    }//Koniec metody zwracającej długość bloku danych z dźwiękiem

    /**
     * Metoda służy do zwracania zawartości pola drugiego w pliku Wave. Wartość tego pola to wielkość pliku - 8.
     * @return Zawartość pola 2.
     */
    public long getRozmiarDanychPlikuWave()
    {
        return LittleBigEndian.UtwórzUnsignedIntZLittleEndian(this.RozmiarDanych_2);
    }//Koniec metody zwracającej pole 2 nagłówka

    /**
     * Metoda ustawiająca długość bloku sygnału po dopisaniu.
     * <br>
     * Metoda dopisywania do pliku wave<br>
     * <ol>
     * <li>Zapamiętaj dane z bufora wejściowego lub innego pliku (o tym samym formacie WAVE).</li>
     * <li>Odczytaj wszytskie dane znajdujące się za blokiem danych</li>
     * <li>Wylicz nową wielkość danych do zapisu (stary blok danych + nowy blok danych).
     * <li>Zmodyfikuj długość bloku danych sygnału (wpisz wartość wuliczoną poprzednio)</li>
     * <li>Zmodyfikuj wielkość pliku w nagłówku (Rozmiar danych, pole nr 2) poprzez dodanie do starej wielkości liczby nowych bajtów</li>
     * <li>Pamiętaj, że innych danych nagłówka WAVE <span style="color:red"><b> W ŻADNYM RAZIE NIE WOLNO MODYFIKOWAĆ!</b></span></li>
     * <li>Zapisz nowy nagłówek (od pozycji 0 w pliku wave)</li>
     * <li>Przeszkocz na pozycję: DługośćNagłówka + Stara wielkość bloku danych - 1 (pozycje liczymy od 0)</li>
     * <li>Na tej pozycji dopisz dane, które są do dopisania</li>
     * <li>Po dopisaniu tych danych zapisz teraz to, co poprzednio znajdowało się za blokiem danych</li>
     * </ol>
     * @param WielkośćBloku Wielkość bloku [B].
     */
    public void setDługośćBlokuDanychSygnału(long WielkośćBloku)
    {
        this.RozmiarBlokuDanych_14 = LittleBigEndian.ZamieńUnsignedIntNaTablicęLittleEndian(WielkośćBloku);
    }//Koniec

    /**
     * Metoda ustawiająca nowy rozmiar danych (pole nr 2) - porzebne przed zapisem!
     * @param RozmiarDanych Nowy rozmiar danych.
     */
    public void setRozmiarDanych(long RozmiarDanych)
    {
        this.RozmiarDanych_2 = LittleBigEndian.ZamieńUnsignedIntNaTablicęLittleEndian(RozmiarDanych);
    }//Koniec metody ustawiającej nowy rozmiar danych

    /**
     * Metoda zwracająca oznaczenie kodowe formatu audio (na przykład: 1 - PCM, 3 - IEEE_FLOAT).
     * @return Kod formatu audio.
     */
    public int getKodowanieDźwięku()
    {
        return LittleBigEndian.UtwórzUnsignedShortZLittleEndian(this.FormatAudio_6);
    }//Koniec metody zwracającej kodowanie dźwięku


}//Koniec klasy
