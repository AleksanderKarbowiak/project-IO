package Classes;

/**
 * Class Analiza
 */
public class Analiza {

  //
  // Fields
  //

  public Recording Nagranie;
  public CorrectionCurveFactory Krzywe_korekcyjne;
  private Correction Korekcja;
  
  //
  // Constructors
  //
  public Analiza () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of Nagranie
   * @param newVar the new value of Nagranie
   */
  public void setNagranie (Recording newVar) {
    Nagranie = newVar;
  }

  /**
   * Get the value of Nagranie
   * @return the value of Nagranie
   */
  public Recording getNagranie () {
    return Nagranie;
  }

  /**
   * Set the value of Krzywe_korekcyjne
   * @param newVar the new value of Krzywe_korekcyjne
   */
  public void setKrzywe_korekcyjne (CorrectionCurveFactory newVar) {
    Krzywe_korekcyjne = newVar;
  }

  /**
   * Get the value of Krzywe_korekcyjne
   * @return the value of Krzywe_korekcyjne
   */
  public CorrectionCurveFactory getKrzywe_korekcyjne () {
    return Krzywe_korekcyjne;
  }

  /**
   * Set the value of Korekcja
   * @param newVar the new value of Korekcja
   */
  public void setKorekcja (Correction newVar) {
    Korekcja = newVar;
  }

  /**
   * Get the value of Korekcja
   * @return the value of Korekcja
   */
  public Correction getKorekcja () {
    return Korekcja;
  }

  //
  // Other methods
  //

}
