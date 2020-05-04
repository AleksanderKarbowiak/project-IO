using System;
using System.Text;
using System.Collections;
using System.Collections.Generic;


/// <summary>
/// 
/// </summary>
public class Aplikacja
{

  #region Aggregations


  #endregion

  #region Compositions


  #endregion

  #region Attributes

  /// <summary>
  /// 
  /// </summary>
  public Analiza Analiza
  {
    get
    {
      return m_Analiza;
    }
    set
    {
      m_Analiza = value;
    }
  }
  private Analiza m_Analiza;


  /// <summary>
  /// 
  /// </summary>
  public Nagrywarka Nagrywarka
  {
    get
    {
      return m_Nagrywarka;
    }
    set
    {
      m_Nagrywarka = value;
    }
  }
  private Nagrywarka m_Nagrywarka;


  /// <summary>
  /// 
  /// </summary>
  public Raspberry Pi 3 Hardware
  {
    get
    {
      return m_Hardware;
    }
    set
    {
      m_Hardware = value;
    }
  }
  private Raspberry Pi 3 m_Hardware;



  #endregion


  #region Public methods

  #endregion


  #region Protected methods

  #endregion


  #region Private methods

  #endregion


}

