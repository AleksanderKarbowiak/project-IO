using System;
using System.Text;
using System.Collections;
using System.Collections.Generic;


/// <summary>
/// 
/// </summary>
public class Begringer_ECM8000
{

  #region Aggregations


  #endregion

  #region Compositions


  #endregion

  #region Attributes

  /// <summary>
  /// 
  /// </summary>
  public kalibrator_VOLTCRAFT_SLC Kalibracja
  {
    get
    {
      return m_Kalibracja;
    }
    set
    {
      m_Kalibracja = value;
    }
  }
  private kalibrator_VOLTCRAFT_SLC m_Kalibracja;



  #endregion


  #region Public methods

  /// <summary>
  /// 
  /// </summary>
  /// <returns></returns>
  public void nagrywanie()
  {
    throw new Exception("The method or operation is not implemented.");
  }

  #endregion


}

