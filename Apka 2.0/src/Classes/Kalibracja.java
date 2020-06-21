package Classes;

import java.io.*;

/**
 * Klasa służąca do kalibracji nagrań
 */
public class Kalibracja {

  static double korekta;
  static String nagranieKalibracyjne;
  public Kalibracja () { };

  /**
   * Metoda uruchamia funkcje obliczające korekte poziomu
   * oraz ustawia wartość statycznej zmiennej korekta
   * @param nazwaPliku
   */
  public static void Kalibruj(String nazwaPliku) {
    nagranieKalibracyjne = nazwaPliku;
    double moc = ObliczMocKalibracja(nazwaPliku);
    korekta = KorektaPoziomu(moc);
    zapamiętajNagranie();
  }

  /**
   * Metoda serializuje nazwe ostatnio użytego nagrania do kalibracji
   */
  public static void zapamiętajNagranie() {
    try{
      //serializujemy bazę do pliku
      FileOutputStream fos = new FileOutputStream("nagranieKalibr.dat");
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(nagranieKalibracyjne);
      oos.close();
      fos.close();
      System.out.println("Zapisano nazwe nagrania do kalibracji");
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
  /** Metoda deserializująca nazwę nagrania do kalibracji */
  public static void pobierzNagranie() {
    try
    {
      //deserializacja do listy
      FileInputStream fis = new FileInputStream("nagranieKalibr.dat");

      ObjectInputStream ois = new ObjectInputStream(fis);

      nagranieKalibracyjne = (String) ois.readObject();

      ois.close();
      fis.close();
      System.out.println("Pobrano nazwę pliku do kalibracji");

    } catch (IOException ioe) {
      System.out.println("Wyjątek IOException podczas deserializacji - kalibracja");
      ioe.printStackTrace();
      return;
    } catch(ClassNotFoundException cnf) {
      System.out.println("Wyjątek ClassNotFoundException podczas deserializacji - kalibracja");
      cnf.printStackTrace();
    }
  }
  /**
   * Metoda zwraca moc synału w celu kalibracji poziomu głośności
   * Na wejście należy podać nagranie sinusa o częstotliwości 1 kHz
   * @param nazwaPliku
   * @return moc
   */
  public static double ObliczMocKalibracja(String nazwaPliku) {

    PlikWave plik = new PlikWave(nazwaPliku);
    plik.OtwórzIstniejącyPlik();
    double P = 0;   // moc
    byte[] próbki = plik.getOdczytajWszystkiePróbki();
    int m = plik.getLiczbęBitów(); // liczba bitów na próbke (M = 8 bitów)
    double maxWartość = Math.pow(2,m-1); // dla 8 bitów = 128
    int n = próbki.length/2;    // liczba próbek

    double[] próbkiL = new double[n];
    for (int i = 0; i< próbki.length; i++) {
      if (i % 2 == 0) {
        // przerzucamy lewy kanał do nowej tablicy i od razu normalizujemy próbki dzieląc przez maxWartość
        próbkiL[i/2] = próbki[i]/maxWartość;    // wyniki będą z przedziału [-1, 1)
      }
    }

    // Wzór na moc ----- P = 1/N * SUMA(|f(n)|^2);
    for (int i = 0; i < próbkiL.length; i++) {
      P += Math.pow(próbkiL[i],2);
    }
    P = P/n;
    System.out.println("Moc " + P);

    plik.ZamknijPlik();
    return P;
  }
  /**
   * Metoda zwraca wynik korekty do kalibracji w decybelach
   * @param P
   * @return korekta w dB
   */
  public static double KorektaPoziomu(double P) {

    double Lznane = 94; // dB
    double PdB = 10 * Math.log10(P);    // zamiana na decybele - maksymalna wartość to 0, reszta wyników powinna być ujemna
    System.out.println(PdB);
    double Lwyliczone = PdB;

    double korekta = Lznane - Lwyliczone;

    return korekta;
  }


}
