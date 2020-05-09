
package Classes;
/**
 * Class Nagranie
 */
public class Nagranie {

  //
  // Fields
  //

  public String nazwa;
  /**
   * Informacje o nagraniu
   */
  public String informacje;
  
  //
  // Constructors
  //
  public Nagranie () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
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
   * Set the value of informacje
   * Informacje o nagraniu
   * @param newVar the new value of informacje
   */
  public void setInformacje (String newVar) {
    informacje = newVar;
  }

  /**
   * Get the value of informacje
   * Informacje o nagraniu
   * @return the value of informacje
   */
  public String getInformacje () {
    return informacje;
  }

  //
  // Other methods
  //

}
