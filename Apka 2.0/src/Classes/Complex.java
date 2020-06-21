package Classes;
import java.util.*;


/**
 * Klasa do obsługi liczb zespolonych
 * Udostępniona do użytku przez dr Piotra Wrzeciono
 */
public class Complex {

  private  double real;
  private  double imaginary;
  private double moduł;
  private double faza;
  public Complex (double real, double imaginary)
  { 
    this.real = real;
    this.imaginary = imaginary;
        
    faza = 0;
        
    absolute();
    ObliczFazę(real,imaginary);
  }
  

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


   // return a new Complex object whose value is (this + b)
    public Complex plus(Complex b) 
    {
        Complex a = this;             // invoking object
        double real = a.real + b.real;
        double imag = a.imaginary + b.imaginary;
        return new Complex(real, imag);
    }

 // return a new Complex object whose value is (this - b)
    public Complex minus(Complex b) 
    {
        Complex a = this;
        double real = a.real - b.real;
        double imag = a.imaginary - b.imaginary;
        return new Complex(real, imag);
    }
  
 
 // return a new Complex object whose value is (this * b)
    public Complex times(Complex b) 
    {
        Complex a = this;
        double real = a.real * b.real - a.imaginary * b.imaginary;
        double imag = a.real * b.imaginary + a.imaginary * b.real;
        return new Complex(real, imag);
    }


    // return a new object whose value is (this * alpha)
   public Complex scale(double alpha) 
   {
        return new Complex(alpha * real, alpha * imaginary);
   }
  
    // return a new Complex object whose value is the conjugate of this
    public Complex conjugate() 
    {
        return new Complex(real, -imaginary);
    }
  
  
  
  /**
   * Metoda zwraca wartość modułu liczby zespolonej
   * @return  Moduł liczby zespolonej
   */
  public double absolute()
  {
     moduł = Math.sqrt((real*real) + (imaginary*imaginary));
     return moduł;
  }

  private void ObliczFazę(double a, double b)
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
  
    @Override
    public String toString() {
        return "Real: " + real + " Imaginary: " + imaginary;
    }

}
