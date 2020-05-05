using System;
using System.Text;
using System.Collections;
using System.Collections.Generic;


/// <summary>
/// 
/// </summary>
public class Analiza
{

  #region Aggregations


  #endregion

  #region Compositions


  #endregion

  #region Attributes

  /// <summary>
  /// 
  /// </summary>
  public Recording Nagranie
  {
    get
    {
      return m_Nagranie;
    }
    set
    {
      m_Nagranie = value;
    }
  }
  private Recording m_Nagranie;


  /// <summary>
  /// 
  /// </summary>
  public CorrectionCurveFactory Krzywe_korekcyjne
  {
    get
    {
      return m_Krzywe_korekcyjne;
    }
    set
    {
      m_Krzywe_korekcyjne = value;
    }
  }
  private CorrectionCurveFactory m_Krzywe_korekcyjne;


  /// <summary>
  /// 
  /// </summary>
  private Correction Korekcja;



  #endregion


  #region Public methods

  #endregion


  #region Protected methods

  #endregion


  #region Private methods

  #endregion


}

