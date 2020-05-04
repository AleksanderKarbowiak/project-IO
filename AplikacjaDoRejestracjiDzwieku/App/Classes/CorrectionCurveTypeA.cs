using System;
using System.Text;
using System.Collections;
using System.Collections.Generic;

using CorrectionCurves;

/// <summary>
/// 
/// </summary>
public class CorrectionCurveTypeA : , CorrectionCurve
{

  #region Aggregations


  #endregion

  #region Compositions


  #endregion

  #region Attributes


  #endregion


  #region CorrectionCurve members

  /// <summary>
  /// 
  /// </summary>
  /// <param name="recording"></param>
  /// <returns>Curve</returns>
  abstract public Curve createCurve(Recording recording);

  #endregion


  #region Public methods

  /// <summary>
  /// 
  /// </summary>
  /// <param name="recording"></param>
  /// <returns>Curve</returns>
  public Curve createCurve(Recording recording)
  {
    throw new Exception("The method or operation is not implemented.");
  }

  #endregion


  #region Protected methods

  #endregion


  #region Private methods

  #endregion


}

