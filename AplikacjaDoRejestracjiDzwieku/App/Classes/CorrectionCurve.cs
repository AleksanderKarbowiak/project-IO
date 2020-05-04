using System;
using System.Text;
using System.Collections;
using System.Collections.Generic;

using CorrectionCurves;

/// <summary>
/// 
/// </summary>
public interface CorrectionCurve
{

  #region Aggregations


  #endregion

  #region Compositions


  #endregion

  #region Public methods

  /// <summary>
  /// 
  /// </summary>
  /// <param name="recording"></param>
  /// <returns>Curve</returns>
  Curve createCurve(Recording recording);

  #endregion


  #region Protected methods

  #endregion


  #region Private methods

  #endregion


}

