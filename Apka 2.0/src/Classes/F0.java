package Classes;

/**
 * Klasa z metodami obliczającymi częstotliwość podstawową
 */


public class F0 {

  /** Metoda obliczająca ile momentów (ile zestawów po 4096 próbki) jest w wybranym pliku */
  public static int IleMomentów(String nazwaPliku) {
    PlikWave plik = new PlikWave(nazwaPliku);
    plik.OtwórzIstniejącyPlik();
    int ile = (int)(plik.getLiczbęPróbek()/4096);
    return ile;
  }
  /** Metoda oblicza F0 z uśrednionego widma otrzymanego z FFT */
  public static double ObliczŚrednieF0(String nazwaPliku) {

    PlikWave plik = new PlikWave(nazwaPliku);
    plik.OtwórzIstniejącyPlik();

    long fsamp = plik.getCzęstotliwośćPróbkowania();

    double[] wyniki = new double[2048];

    int ilePróbek = 4096;
    int indexPróbki = 0;
    int licznik = 0;
    double średnieF0 = 0;

    //System.out.println("Ile razy " + plik.getLiczbęPróbek()/4096);

    while (indexPróbki + ilePróbek < plik.getLiczbęPróbek()) {

      //System.out.println("Licznik: " + licznik);
      licznik++;
      byte[] probki = plik.PobierzKilkaPróbek(indexPróbki, ilePróbek);

      indexPróbki += ilePróbek;


      // podział na kanały
      Complex[] zespoloneL = new Complex[ilePróbek / 2];
      int licznikL = 0;
      for (int i = 0; i < probki.length / 2; i++) {

        Complex x = new Complex(probki[i], 0);
        if (i % 2 == 0) {
          zespoloneL[licznikL] = x;
          licznikL++;
        }
      }

      // obliczanie FFT dla lewego kanału
      Complex[] fftL = FFT.fft(zespoloneL);

      // Obliczanie modułów liczb zepsolonych
      double[] fftLabs = new double[fftL.length];

      for (int i = 0; i < fftL.length; i++) {
        fftLabs[i] = fftL[i].getModuł();
        wyniki[i] += fftLabs[i];
      }

    }

    for (int i = 0; i < wyniki.length; i++)
    {
      wyniki[i] = wyniki[i]/licznik;
    }

    średnieF0 = SzukajF0(wyniki, fsamp);

    Wykres wykres = new Wykres(wyniki, "Uśrednione widmo nagrania");
    wykres.setVisible(true);

    return średnieF0;
  }

  /** Metoda oblicza F0 i wyświetla wykres wybranego momentu nagrania */
  public static double ObliczF0wJednymMomencie(String nazwaPliku, int moment) {
    PlikWave plik = new PlikWave(nazwaPliku);
    plik.OtwórzIstniejącyPlik();

    long fsamp = plik.getCzęstotliwośćPróbkowania();

    int ilePróbek = 4096;
    double F0 = 0;

    byte[] probki = plik.PobierzKilkaPróbek((moment-1)*4096, ilePróbek);

    // podział na kanały
    Complex[] zespoloneL = new Complex[ilePróbek / 2];
    int licznikL = 0;
    for (int i = 0; i < probki.length / 2; i++) {

      Complex x = new Complex(probki[i], 0);
      if (i % 2 == 0) {
        zespoloneL[licznikL] = x;
        licznikL++;
      }
    }

    // obliczanie FFT dla lewego kanału
    Complex[] fftL = FFT.fft(zespoloneL);

    // Obliczanie modułów liczb zepsolonych
    double[] fftLabs = new double[fftL.length];

    for (int i = 0; i < fftL.length; i++) {
      fftLabs[i] = fftL[i].getModuł();
    }

    F0 = SzukajF0(fftLabs, fsamp);

    Wykres wykres = new Wykres(fftLabs, "Widmo " + moment + " momentu");
    wykres.setVisible(true);

    return F0;
  }
  /** Metoda wyszukuje częstotliwość podstawową (F0) z podanego widma FFT*/
  private static double SzukajF0(double[] tab, double f)
  {
    double maxIndex = 0;
    double maxValue = 0;
    double krok = f/tab.length;
    boolean boo = false;
    double średniaAmp = 0;
    double suma = 0;
    
    // obliczanie średniej amplitudy
    for (int i = 3; i < tab.length/2; i++) {
      suma += tab[i];
    }
    średniaAmp = suma / (tab.length/2);
    
    
    for (int i = 3; i < tab.length/2 - 3; i++) {

      if (tab[i] > średniaAmp && tab[i-3] < tab[i] && tab[i-2] < tab[i] && tab[i-1] < tab[i] && // jeśli 3 poprzednie i 3 następne wartości są mniejsze od obecnej
              tab[i+1] < tab[i] && tab[i+2] < tab[i] && tab[i+3] < tab[i]) {

        if (maxIndex == 0) {
          maxIndex = i;
          maxValue = tab[i];
          boo = true;
        } else if (tab[i] > maxValue) {

          if ((i <= 5 * maxIndex && tab[i] >= 2 * maxValue) || (maxIndex < 9 && tab[i] >= 1.5 * maxValue)) {
            maxIndex = i;
            maxValue = tab[i];
          }

        }

      } else if (boo == true && i > 5 * maxIndex) {
        break;
      }

    }

    // zamiana indeksu na częstotliwość
    maxIndex = maxIndex * krok;
    return maxIndex;
  }

}
