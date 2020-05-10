package Classes;
import java.util.*;


/**
 * Class Complex
 */
public class Complex {

  private final double real;
  private final double imaginary;
  private double moduł;
  private double faza;
  public Complex (double real, double imaginary)
  { 
    this.real = real;
    this.imaginary = imaginary;
        
    faza = 0;
        
    absolute();
    ObliczFazę();
  };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of real
   * @param newVar the new value of real
   */
  public void setReal (double newVar) {
    real = newVar;
  }

  /**
   * Get the value of real
   * @return the value of real
   */
  public double getReal () {
    return real;
  }

  /**
   * Set the value of imaginary
   * @param newVar the new value of imaginary
   */
  public void setImaginary (double newVar) {
    imaginary = newVar;
  }

  /**
   * Get the value of imaginary
   * @return the value of imaginary
   */
  public double getImaginary () {
    return imaginary;
  }

  //
  // Other methods
  //

  /**
   * @return       Complex
   * @param        x
   */
  public Complex add(Complex x)
  {
  }


  /**
   * @return       Complex
   * @param        x
   */
  public Complex subtract(Complex x)
  {
  }


  /**
   * @return       Complex
   * @param        x
   */
  public Complex multiply(Complex x)
  {
  }


  /**
   * @return       Complex
   * @param        x
   */
  public Complex multiply(double x)
  {
  }


  /**
   * @return       double
   */
  public double absolute()
  {
     moduł = Math.sqrt((real*real) + (imaginary*imaginary));
  }
  private void ObliczFazę()
    {
        if(a == 0 && b == 0)
        {
            faza = 0;
        }else if(a == 0 && b > 0)
        {
            faza = Math.PI/2;
        }else if(a == 0 && b < 0)
        {
            faza = 3 * Math.PI/2;
        }else if(a != 0 && b == 0)
        {
            faza = 0;
        }else if(a > 0 && b != 0)
        {
            faza = Math.atan(b/a);
        }else if(a < 0 && b != 0)
        {
            faza = Math.atan(b/a) + Math.PI;
        }//end if
    }//Koniec obliczania fazy
   public double getModuł()
    {
        return moduł;
    }
    
    public double getFazę()
    {
        return faza;
    }

}
