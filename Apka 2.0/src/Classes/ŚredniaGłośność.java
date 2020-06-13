package Classes;

public class ŚredniaGłośność {

    /**
     * Oblicza moc z korekcją według krzywej A
     * @param nazwaNagrania
     * @param czySzybkie wybór okna
     * @return moc z korekcją A
     */
    public static double[] ObliczMocKorekcjaA(String nazwaNagrania, boolean czySzybkie) {

        PlikWave plik = new PlikWave(nazwaNagrania);
        plik.OtwórzIstniejącyPlik();

        long fsamp = plik.getCzęstotliwośćPróbkowania();
        int ilePróbek;
        double[] wyniki;
        int indexPróbki = 0;
        int licznik = 0;
        int m = plik.getLiczbęBitów(); // liczba bitów na próbke (M = 8 bitów)
        double maxWartość = Math.pow(2,m-1); // dla 8 bitów = 128

        double korekta = Kalibracja.korekta;
        double ogranicznik = 0;
        int licznikOgr = 0;
        int licznikWyniki = 0;

        // jeśli szybkie to obliczamy co 0.125s jeśli wolne to dla 1s
        if(czySzybkie) {
            ogranicznik = 1;
        } else {
            ogranicznik = 8;
        }
        int ilePróbekSzybkie = (int)fsamp/8;   // ile próbek na 0.125 s

        if (ilePróbekSzybkie > 4096) {
            ilePróbek = 4096;
        } else {
            ilePróbek = 2048;
        }
        wyniki = new double[(int)((plik.getLiczbęPróbek()/ilePróbekSzybkie)/ogranicznik)];
        //System.out.println(wyniki.length);

        while (indexPróbki + ilePróbekSzybkie < plik.getLiczbęPróbek()) {
            licznik++;
            byte[] probki = plik.PobierzKilkaPróbek(indexPróbki, ilePróbek);
            indexPróbki += ilePróbekSzybkie;

            // podział na kanały
            Complex[] zespoloneL = new Complex[probki.length/2];
            int licznikL = 0;
            for (int i = 0; i < probki.length; i++) {
                if (i % 2 == 0) {
                    Complex x = new Complex(probki[i] / maxWartość, 0);   // zamiana na zespolone z jednoczesną normalizacją
                    zespoloneL[licznikL] = x;
                    licznikL++;
                }
            }
            // obliczanie FFT dla lewego kanału
            Complex[] fftL = FFT.fft(zespoloneL);
            // Obliczanie modułów liczb zespolonych
            double[] fftLabs = new double[fftL.length];
            for (int i = 0; i < fftL.length; i++) {
                fftLabs[i] = fftL[i].getModuł() / ilePróbek;     // normalizacja wyników fft
            }
            double krok = fsamp / (double) fftLabs.length;     // krok częstotliwości
            double P = 0;
            double[] korekcjaA = new double[fftLabs.length];

            // zamiana na decybele i korekcja krzywą A
            for (int i = 0; i < fftLabs.length; i++) {
                // KOREKCJA WEDŁUG KRZYWEJ A
                korekcjaA[i] = Math.pow(fftLabs[i], 2);      // podnoszenie modułu zespolonej z fft do kwadratu
                korekcjaA[i] = 10 * Math.log10(korekcjaA[i]);     // zamiana na decybele
                korekcjaA[i] += KrzyweKorekcyjne.ObliczKrzywąA(i * krok) + korekta;   // dodanie wartości z krzywej A oraz korekty z kalibracji
                if (i == 1) korekcjaA[i - 1] = korekcjaA[i];      // nadpisanie infinity dla 0 Hz
                korekcjaA[i] = Math.pow(10, korekcjaA[i] / 10.0);  // oddecybelowanie
                P += korekcjaA[i];      // obliczenie mocy ze wzoru P = suma( |F(n)|^2 ), gdzie F(n) = DFT(f(n))
            }

            //System.out.println("Obliczona moc: " + P);
            P = 10 * Math.log10(P);

            if(licznikOgr < ogranicznik) {
                wyniki[licznikWyniki] += P;
                licznikOgr++;
            } else {
                licznikOgr = 1;
                wyniki[licznikWyniki] = wyniki[licznikWyniki]/ogranicznik;
                licznikWyniki++;
                if(licznikWyniki >= wyniki.length) break;
                wyniki[licznikWyniki] += P;
            }
        }

        return wyniki;
    }

    /**
     * Oblicza moc z korekcją według krzywej C
     * @param nazwaNagrania
     * @param czySzybkie wybór okna
     * @return moc z korekcją C
     */
    public static double[] ObliczMocKorekcjaC(String nazwaNagrania, boolean czySzybkie) {

        PlikWave plik = new PlikWave(nazwaNagrania);
        plik.OtwórzIstniejącyPlik();

        long fsamp = plik.getCzęstotliwośćPróbkowania();
        int ilePróbek;
        double[] wyniki;
        int indexPróbki = 0;
        int licznik = 0;
        int m = plik.getLiczbęBitów(); // liczba bitów na próbke (M = 8 bitów)
        double maxWartość = Math.pow(2,m-1); // dla 8 bitów = 128

        double korekta = Kalibracja.korekta;
        double ogranicznik = 0;
        int licznikOgr = 0;
        int licznikWyniki = 0;

        // jeśli szybkie to obliczamy co 0.125s jeśli wolne to dla 1s
        if(czySzybkie) {
            ogranicznik = 1;
        } else {
            ogranicznik = 8;
        }
        int ilePróbekSzybkie = (int)fsamp/8;   // ile próbek na 0.125 s

        if (ilePróbekSzybkie > 4096) {
            ilePróbek = 4096;
        } else {
            ilePróbek = 2048;
        }
        wyniki = new double[(int)((plik.getLiczbęPróbek()/ilePróbekSzybkie)/ogranicznik)];
        //System.out.println(wyniki.length);

        while (indexPróbki + ilePróbekSzybkie < plik.getLiczbęPróbek()) {
            licznik++;
            byte[] probki = plik.PobierzKilkaPróbek(indexPróbki, ilePróbek);
            indexPróbki += ilePróbekSzybkie;

            // podział na kanały
            Complex[] zespoloneL = new Complex[probki.length/2];
            int licznikL = 0;
            for (int i = 0; i < probki.length; i++) {
                if (i % 2 == 0) {
                    Complex x = new Complex(probki[i] / maxWartość, 0);   // zamiana na zespolone z jednoczesną normalizacją
                    zespoloneL[licznikL] = x;
                    licznikL++;
                }
            }
            // obliczanie FFT dla lewego kanału
            Complex[] fftL = FFT.fft(zespoloneL);
            // Obliczanie modułów liczb zespolonych
            double[] fftLabs = new double[fftL.length];
            for (int i = 0; i < fftL.length; i++) {
                fftLabs[i] = fftL[i].getModuł() / ilePróbek;     // normalizacja wyników fft
            }
            double krok = fsamp / (double) fftLabs.length;     // krok częstotliwości
            double P = 0;
            double[] korekcjaC= new double[fftLabs.length];

            // zamiana na decybele i korekcja krzywą C
            for (int i = 0; i < fftLabs.length; i++) {
                // KOREKCJA WEDŁUG KRZYWEJ C
                korekcjaC[i] = Math.pow(fftLabs[i],2);      // podnoszenie modułu zespolonej z fft do kwadratu
                korekcjaC[i] = 10 * Math.log10(korekcjaC[i]);     // zamiana na decybele
                korekcjaC[i] += KrzyweKorekcyjne.ObliczKrzywąC(i*krok) + korekta;   // dodanie wartości z krzywej C oraz korekty z kalibracji
                if (i == 1) korekcjaC[i-1] = korekcjaC[i];      // nadpisanie infinity dla 0 Hz
                korekcjaC[i] = Math.pow(10, korekcjaC[i]/10.0);  // oddecybelowanie
                P += korekcjaC[i];      // obliczenie mocy ze wzoru P = suma( |F(n)|^2 ), gdzie F(n) = DFT(f(n))
            }

            //System.out.println("Obliczona moc: " + P);
            P = 10 * Math.log10(P);

            if(licznikOgr < ogranicznik) {
                wyniki[licznikWyniki] += P;
                licznikOgr++;
            } else {
                licznikOgr = 1;
                wyniki[licznikWyniki] = wyniki[licznikWyniki]/ogranicznik;
                licznikWyniki++;
                if(licznikWyniki >= wyniki.length) break;
                wyniki[licznikWyniki] += P;
            }
        }

        return wyniki;
    }

    /**
     * Oblicza moc z korekcją według krzywej Z
     * @param nazwaNagrania
     * @param czySzybkie wybór okna
     * @return moc z korekcją Z
     */
    public static double[] ObliczMocKorekcjaZ(String nazwaNagrania, boolean czySzybkie) {

        PlikWave plik = new PlikWave(nazwaNagrania);
        plik.OtwórzIstniejącyPlik();

        long fsamp = plik.getCzęstotliwośćPróbkowania();
        int ilePróbek;
        double[] wyniki;
        int indexPróbki = 0;
        int licznik = 0;
        int m = plik.getLiczbęBitów(); // liczba bitów na próbke (M = 8 bitów)
        double maxWartość = Math.pow(2,m-1); // dla 8 bitów = 128

        double korekta = Kalibracja.korekta;
        double ogranicznik = 0;
        int licznikOgr = 0;
        int licznikWyniki = 0;

        // jeśli szybkie to obliczamy co 0.125s jeśli wolne to dla 1s
        if(czySzybkie) {
            ogranicznik = 1;
        } else {
            ogranicznik = 8;
        }
        int ilePróbekSzybkie = (int)fsamp/8;   // ile próbek na 0.125 s

        if (ilePróbekSzybkie > 4096) {
            ilePróbek = 4096;
        } else {
            ilePróbek = 2048;
        }
        wyniki = new double[(int)((plik.getLiczbęPróbek()/ilePróbekSzybkie)/ogranicznik)];
        //System.out.println(wyniki.length);

        while (indexPróbki + ilePróbekSzybkie < plik.getLiczbęPróbek()) {
            licznik++;
            byte[] probki = plik.PobierzKilkaPróbek(indexPróbki, ilePróbek);
            indexPróbki += ilePróbekSzybkie;

            // podział na kanały
            Complex[] zespoloneL = new Complex[probki.length/2];
            int licznikL = 0;
            for (int i = 0; i < probki.length; i++) {
                if (i % 2 == 0) {
                    Complex x = new Complex(probki[i] / maxWartość, 0);   // zamiana na zespolone z jednoczesną normalizacją
                    zespoloneL[licznikL] = x;
                    licznikL++;
                }
            }
            // obliczanie FFT dla lewego kanału
            Complex[] fftL = FFT.fft(zespoloneL);
            // Obliczanie modułów liczb zespolonych
            double[] fftLabs = new double[fftL.length];
            for (int i = 0; i < fftL.length; i++) {
                fftLabs[i] = fftL[i].getModuł() / ilePróbek;     // normalizacja wyników fft
            }
            double krok = fsamp / (double) fftLabs.length;     // krok częstotliwości
            double P = 0;
            double[] korekcjaZ = new double[fftLabs.length];

            // zamiana na decybele i korekcja krzywą Z
            for (int i = 0; i < fftLabs.length; i++) {
                // KOREKCJA WEDŁUG KRZYWEJ Z
                korekcjaZ[i] = Math.pow(fftLabs[i],2);      // podnoszenie modułu zespolonej z fft do kwadratu
                korekcjaZ[i] = 10 * Math.log10(korekcjaZ[i]);     // zamiana na decybele
                korekcjaZ[i] += KrzyweKorekcyjne.ObliczKrzywąZ(i*krok) + korekta;   // dodanie wartości z krzywej Z oraz korekty z kalibracji
                korekcjaZ[i] = Math.pow(10, korekcjaZ[i]/10.0);  // oddecybelowanie
                P += korekcjaZ[i];      // obliczenie mocy ze wzoru P = suma( |F(n)|^2 ), gdzie F(n) = DFT(f(n))
            }

            //System.out.println("Obliczona moc: " + P);
            P = 10 * Math.log10(P);

            if(licznikOgr < ogranicznik) {
                wyniki[licznikWyniki] += P;
                licznikOgr++;
            } else {
                licznikOgr = 1;
                wyniki[licznikWyniki] = wyniki[licznikWyniki]/ogranicznik;
                licznikWyniki++;
                if(licznikWyniki >= wyniki.length) break;
                wyniki[licznikWyniki] += P;
            }
        }

        return wyniki;
    }

    /**
     * Funkcja oblicza średnią z wyników podanych w tablicy
     * @param tab
     * @return średnia
     */
    public static double ObliczŚrednią(double[] tab) {
        double x = 0;
        for (int i = 0; i < tab.length; i++) {
            x += tab[i];
        }
        x = x / tab.length;
        return x;
    }

    public static void main(String[] args) {

        // TESTY

        Kalibracja.Kalibruj("sinus.wav");
        double korekta = Kalibracja.korekta;
        System.out.println(korekta);

        double[] wynikiA = ObliczMocKorekcjaA("test44.wav", false);
        System.out.println("Wynik a " + ObliczŚrednią(wynikiA));

        double[] wynikiC= ObliczMocKorekcjaC("test44.wav",false);
        System.out.println("Wynik c " + ObliczŚrednią(wynikiC));

        double[] wynikiZ = ObliczMocKorekcjaZ("test44.wav", false);
        System.out.println("Wynik z " + ObliczŚrednią(wynikiZ));

        GłośnośćWykres wykres1= new GłośnośćWykres(wynikiA,wynikiC,wynikiZ,"Test44");
        wykres1.setVisible(true);

        wynikiA = ObliczMocKorekcjaA("test44.wav", true);
        System.out.println("Wynik a " + ObliczŚrednią(wynikiA));

        wynikiC= ObliczMocKorekcjaC("test44.wav",true);
        System.out.println("Wynik c " + ObliczŚrednią(wynikiC));

        wynikiZ = ObliczMocKorekcjaZ("test44.wav", true);
        System.out.println("Wynik z " + ObliczŚrednią(wynikiZ));

        GłośnośćWykres wykres2= new GłośnośćWykres(wynikiA,wynikiC,wynikiZ,"Test44");
        wykres2.setVisible(true);

    }
}
