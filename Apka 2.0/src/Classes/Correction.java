
package Classes;
/**
 * Class Correction
 */
public class Correction {

  //
  // Fields
  //

  private int microphoneIntensity = 94;
  
  //
  // Constructors
  //
  public Correction () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of microphoneIntensity
   * @param newVar the new value of microphoneIntensity
   */
  public void setMicrophoneIntensity (int newVar) {
    microphoneIntensity = newVar;
  }

  /**
   * Get the value of microphoneIntensity
   * @return the value of microphoneIntensity
   */
  public int getMicrophoneIntensity () {
    return microphoneIntensity;
  }

  //
  // Other methods
  //

  /**
   * @return       double
   * @param referenceIntensity
   */
  public double countCorrection(double referenceIntensity)
  {
    //TODO
    return 0;
  }


}
