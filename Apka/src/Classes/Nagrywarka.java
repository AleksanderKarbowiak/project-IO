package Classes;

/**
 * Class Nagrywarka
 */
public class Nagrywarka {

  //
  // Fields
  //

  public Baza_danych baza_nagran;
  public Kalibracja kalibracja;
  
  //
  // Constructors
  //
  public Nagrywarka () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of baza_nagran
   * @param newVar the new value of baza_nagran
   */
  public void setBaza_nagran (Baza_danych newVar) {
    baza_nagran = newVar;
  }

  /**
   * Get the value of baza_nagran
   * @return the value of baza_nagran
   */
  public Baza_danych getBaza_nagran () {
    return baza_nagran;
  }

  /**
   * Set the value of kalibracja
   * @param newVar the new value of kalibracja
   */
  public void setKalibracja (Kalibracja newVar) {
    kalibracja = newVar;
  }

  /**
   * Get the value of kalibracja
   * @return the value of kalibracja
   */
  public Kalibracja getKalibracja () {
    return kalibracja;
  }

  //
  // Other methods
  //

  /**
   * wstrzymuje nagrywanie
   */
  public void Pauza()
  {
  }


  /**
   * Ko�czy nagrywanie
   */
  public void Stop()
  {
  }


  /**
   * Usuwa nagranie o podanej nazwie
   * @param nazwa
   */
  public void UsunNagranie(String nazwa)
  {
  }


  /**
   * Funkcja rozpoczynaj�ca nagrywanie oraz zwracaj�ca obiekt nagranie
   * @return       Nagranie
   * @param        nazwa
   * @param        informacje
   */
  public Nagranie Nagraj(String nazwa, String informacje)
  {
  }


}
