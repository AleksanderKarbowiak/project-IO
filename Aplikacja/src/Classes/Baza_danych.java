package Classes;

import java.io.*;
import java.util.ArrayList;

/**
 * Klasa służąca do obsługi bazy danych
 */
public class Baza_danych {

    ArrayList<Nagranie> nagrania;

  /** Konstruktor bazy */
  public Baza_danych () {
      nagrania = new ArrayList<>();
  };

  /** Metoda deserializująca liste nagrań */
  public void pobierzListe() {
      try
      {
          //deserializacja do listy
          FileInputStream fis = new FileInputStream("nagraniaData.dat");
          ObjectInputStream ois = new ObjectInputStream(fis);

          nagrania = (ArrayList) ois.readObject();

          ois.close();
          fis.close();
          System.out.println("Pobrano liste");
      } catch (IOException ioe) {
          System.out.println("Wyjątek Bazy IOException");
          ioe.printStackTrace();
          return;
      } catch(ClassNotFoundException cnf) {
         System.out.println("Wyjątek Bazy ClassNotFoundException");
          cnf.printStackTrace();
      }
  }

  /** Metoda serializująca liste do pliku nagraniaData */
  public void zapiszListe() {
      try{
          //serializujemy bazę do pliku
          FileOutputStream fos = new FileOutputStream("nagraniaData.dat");
          ObjectOutputStream oos = new ObjectOutputStream(fos);
          oos.writeObject(nagrania);
          oos.close();
          fos.close();
          System.out.println("Zapisano liste");
      } catch(Exception e) {
          e.printStackTrace();
      }
  }

  /**
   * Metoda ustawia wartość obiektu nagrania
   * @param newVar Nowa wartość dla obiektu nagrania_
   */
  public void setNagrania_ (ArrayList<Nagranie> newVar) {
      nagrania = newVar;
  }
  /** Metoda dodaje nagranie do listy */
  public void dodajNagranie(Nagranie nagranie) {
      nagrania.add(nagranie);
      System.out.println("Dodano nagranie");
  }

  /**
   * Metoda pobiera obiekt nagrania_
   * @return Obiekt nagrania_
   */
  public ArrayList<Nagranie> nagrania() {
      return nagrania;
  }

}
