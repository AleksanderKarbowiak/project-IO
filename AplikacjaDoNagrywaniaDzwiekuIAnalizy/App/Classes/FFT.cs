using System;
using System.Text;
using System.Collections;
using System.Collections.Generic;


/// <summary>
/// 
/// </summary>
abstract public class FFT : FourierTransformation
{


  #region FourierTransformation members

  /// <summary>
  /// 
  /// </summary>
  /// <param name="x"></param>
  /// <returns>Complex</returns>
  abstract public Complex countTransformation(Complex x);

  #endregion






}

