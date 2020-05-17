package Classes;

import java.util.List;

/**
 * Class Baza_danych
 */
public class Baza_danych {

  //
  // Fields
  //

  private List<Nagranie> nagrania;
  
  //
  // Constructors
  //
  public Baza_danych () {

  };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of nagrania_
   * @param newVar the new value of nagrania_
   */
  public void setNagrania_ (List<Nagranie> newVar) {
    nagrania = newVar;
  }

  public void dodajNagranie(Nagranie nagranie) {
      nagrania.add(nagranie);
  }

  /**
   * Get the value of nagrania_
   * @return the value of nagrania_
   */
  public List<Nagranie> nagrania() {
    return nagrania;
  }

  //
  // Other methods
  //

}
