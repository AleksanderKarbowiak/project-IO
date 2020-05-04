using System;
using System.Text;
using System.Collections;
using System.Collections.Generic;


/// <summary>
/// 
/// </summary>
public class CorrectionCurveTypeZ : , CorrectionCurve
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
  /// <returns>CorrectionCurves.Curve</returns>
  abstract public CorrectionCurves.Curve createCurve(Recording recording);

  #endregion


  #region Public methods

  /// <summary>
  /// 
  /// </summary>
  /// <param name="recording"></param>
  /// <returns></returns>
  public void createCurve(Recording recording)
  {
    throw new Exception("The method or operation is not implemented.");
  }

  #endregion


  #region Protected methods

  #endregion


  #region Private methods

  #endregion


}

