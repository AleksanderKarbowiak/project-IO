package Classes;

/**
 * Class Raspberry_Pi_3
 */
public class Raspberry_Pi_3 {

  //
  // Fields
  //

  private Begringer ECM8000 dzwiekSkalibrowany;
  private Ekran WyswietlanieEkranu;
  private PanelSygnalizujacyZDiodami GPIO;
  private GPIO PrzesterowanieSygnaluWejsciowegp;
  private Wi-Fi PolaczonoZWiFo;
  private Bluetooth PolaczonoPrzezBT;
  private USB PodlaczonePortyUSB_;
  private Mikrofon2 dzwiekNieskalibrowany;
  
  //
  // Constructors
  //
  public Raspberry_Pi_3 () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of dzwiekSkalibrowany
   * @param newVar the new value of dzwiekSkalibrowany
   */
  public void setDzwiekSkalibrowany (Begringer ECM8000 newVar) {
    dzwiekSkalibrowany = newVar;
  }

  /**
   * Get the value of dzwiekSkalibrowany
   * @return the value of dzwiekSkalibrowany
   */
  public Begringer ECM8000 getDzwiekSkalibrowany () {
    return dzwiekSkalibrowany;
  }

  /**
   * Set the value of WyswietlanieEkranu
   * @param newVar the new value of WyswietlanieEkranu
   */
  public void setWyswietlanieEkranu (Ekran newVar) {
    WyswietlanieEkranu = newVar;
  }

  /**
   * Get the value of WyswietlanieEkranu
   * @return the value of WyswietlanieEkranu
   */
  public Ekran getWyswietlanieEkranu () {
    return WyswietlanieEkranu;
  }

  /**
   * Set the value of GPIO
   * @param newVar the new value of GPIO
   */
  public void setGPIO (PanelSygnalizujacyZDiodami newVar) {
    GPIO = newVar;
  }

  /**
   * Get the value of GPIO
   * @return the value of GPIO
   */
  public PanelSygnalizujacyZDiodami getGPIO () {
    return GPIO;
  }

  /**
   * Set the value of PrzesterowanieSygnaluWejsciowegp
   * @param newVar the new value of PrzesterowanieSygnaluWejsciowegp
   */
  public void setPrzesterowanieSygnaluWejsciowegp (GPIO newVar) {
    PrzesterowanieSygnaluWejsciowegp = newVar;
  }

  /**
   * Get the value of PrzesterowanieSygnaluWejsciowegp
   * @return the value of PrzesterowanieSygnaluWejsciowegp
   */
  public GPIO getPrzesterowanieSygnaluWejsciowegp () {
    return PrzesterowanieSygnaluWejsciowegp;
  }

  /**
   * Set the value of PolaczonoZWiFo
   * @param newVar the new value of PolaczonoZWiFo
   */
  public void setPolaczonoZWiFo (Wi-Fi newVar) {
    PolaczonoZWiFo = newVar;
  }

  /**
   * Get the value of PolaczonoZWiFo
   * @return the value of PolaczonoZWiFo
   */
  public Wi-Fi getPolaczonoZWiFo () {
    return PolaczonoZWiFo;
  }

  /**
   * Set the value of PolaczonoPrzezBT
   * @param newVar the new value of PolaczonoPrzezBT
   */
  public void setPolaczonoPrzezBT (Bluetooth newVar) {
    PolaczonoPrzezBT = newVar;
  }

  /**
   * Get the value of PolaczonoPrzezBT
   * @return the value of PolaczonoPrzezBT
   */
  public Bluetooth getPolaczonoPrzezBT () {
    return PolaczonoPrzezBT;
  }

  /**
   * Set the value of PodlaczonePortyUSB_
   * @param newVar the new value of PodlaczonePortyUSB_
   */
  public void setPodlaczonePortyUSB_ (USB newVar) {
    PodlaczonePortyUSB_ = newVar;
  }

  /**
   * Get the value of PodlaczonePortyUSB_
   * @return the value of PodlaczonePortyUSB_
   */
  public USB getPodlaczonePortyUSB_ () {
    return PodlaczonePortyUSB_;
  }

  /**
   * Set the value of dzwiekNieskalibrowany
   * @param newVar the new value of dzwiekNieskalibrowany
   */
  public void setDzwiekNieskalibrowany (Mikrofon2 newVar) {
    dzwiekNieskalibrowany = newVar;
  }

  /**
   * Get the value of dzwiekNieskalibrowany
   * @return the value of dzwiekNieskalibrowany
   */
  public Mikrofon2 getDzwiekNieskalibrowany () {
    return dzwiekNieskalibrowany;
  }

  //
  // Other methods
  //

}
