
package Classes;
/**
 * Class Nagranie
 */
public class Nagranie {

  String nazwa;
  String imie;
  String nazwisko;

  /**
   * Konstruktor klasy Nagranie
   *
   * @param nazwa - nazwa nagrania
   * @param imie - imie użytkownika
   * @param nazwisko - nazwisko użytkownika
   */
  Nagranie(String nazwa, String imie, String nazwisko) {
      this.nazwa = nazwa;
      this.imie = imie;
      this.nazwisko = nazwisko;
  }
  
  //
  // Methods
  //

  /**
   * Set the value of nazwa
   * @param newVar the new value of nazwa
   */
  public void setNazwa (String newVar) {
    nazwa = newVar;
  }

  /**
   * Get the value of nazwa
   * @return the value of nazwa
   */
  public String getNazwa () {
    return nazwa;
  }

  /**
   * Set the value of imie
   * imie użytkownika
   * @param newVar the new value of imie
   */
  public void setImie (String newVar) {
    imie = newVar;
  }

  /**
   * Get the value of imie
   * imie użytkownika
   * @return the value of imie
   */
  public String getImie () {
    return imie;
  }
  
  /**
   * Set the value of nazwisko
   * nazwisko użytkownika
   * @param newVar the new value of nazwisko
   */
  public void setNazwisko (String newVar) {
    nazwisko = newVar;
  }

  /**
   * Get the value of nazwisko
   * nazwisko użytkownika
   * @return the value of nazwisko
   */
  public String getNazwisko () {
    return nazwisko;
  }

}
