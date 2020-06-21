/**
 * Klasa służąca do przechowywania wyniku działania dyskretnej transformaty Fouriera
 */
package Classes;

/**
 * Klasa służąca do obsługi widma częstotliwości
 */
public class widmo
{
    private final Complex wynik;
    private final double częstotliwość;
    
    
    public widmo(double a, double b, double częstotliwość)
    {
        wynik = new Complex(a,b);
        this.częstotliwość = częstotliwość;
    }//Koniec konstruktora
    
    
    public double getCzęstotliwość()
    {
        return częstotliwość;
    }
    
    public double getWidmoAmplitudowe()
    {
        return wynik.getModuł();
    }
    
    public double getWidmoFazowe()
    {
        return wynik.getFazę();
    }
    
    public double get_dB()
    {
        double wyn;
        
        wyn = 20*Math.log(getWidmoAmplitudowe())/Math.log(10);
        
        return wyn;
    }//Koniec metody zwracającej dB
    
    public String toString()
    {
        String opis;
        
        opis = częstotliwość + " Hz\t" + wynik.getModuł() + "\t" + get_dB() + " dB";
        
        return opis;
    }//Koniec metody toString
    
}//Koniec klasy
