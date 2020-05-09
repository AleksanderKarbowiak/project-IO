package Classes;

/**
 * Class Aplikacja
 */
public class Aplikacja {

  //
  // Fields
  //

  public Analiza Analiza;
  public Nagrywarka Nagrywarka;
  public Raspberry_Pi_3 Hardware;
  
  //
  // Constructors
  //
  public Aplikacja () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of Analiza
   * @param newVar the new value of Analiza
   */
  public void setAnaliza (Analiza newVar) {
    Analiza = newVar;
  }

  /**
   * Get the value of Analiza
   * @return the value of Analiza
   */
  public Analiza getAnaliza () {
    return Analiza;
  }

  /**
   * Set the value of Nagrywarka
   * @param newVar the new value of Nagrywarka
   */
  public void setNagrywarka (Nagrywarka newVar) {
    Nagrywarka = newVar;
  }

  /**
   * Get the value of Nagrywarka
   * @return the value of Nagrywarka
   */
  public Nagrywarka getNagrywarka () {
    return Nagrywarka;
  }

  /**
   * Set the value of Hardware
   * @param newVar the new value of Hardware
   */
  public void setHardware (Raspberry_Pi_3 newVar) {
    Hardware = newVar;
  }

  /**
   * Get the value of Hardware
   * @return the value of Hardware
   */
  public Raspberry_Pi_3 getHardware () {
    return Hardware;
  }

  //
  // Other methods
  //

}
