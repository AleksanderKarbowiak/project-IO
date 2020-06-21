package Classes;

//import org.jfree.chart.axis.SymbolAxis;
import org.junit.Test;

//import java.io.FileInputStream;
import  java.lang.Thread;
//import java.io.File;

/**
 * Klasa służąca do testowania kalibracji
 */
public class KalibracjaTest {
    double P=0;
    String nazwa="TestKalibracji";
    @Test
    public void pobierzNagranie() {

        try{

            Kalibracja.pobierzNagranie();
            System.out.println("Proces porbierania nazwy pliku zakończony sukcesem");
        }
        catch (Exception pobr)
        {
            System.out.println(pobr);
        }

    }
    @Test
    public void kalibruj() {

        try{
            System.out.println("Wykonuję przykładowe nagranie");
            Nagrywarka n = new Nagrywarka();
            n.Nagraj(nazwa,"SSS","KKK","23","male");
            Thread.sleep(2*1000);
            n.Stop();
            System.out.println("Kalibracja przykładowego nagrania");
            Kalibracja.Kalibruj(nazwa+".wav");
        }
        catch (Exception kal){

            System.out.println(kal);
        }
    }

    @Test
    public void zapamiętajNagranie() {

    }

    @Test
    public void obliczMocKalibracja() {

    }

    @Test
    public void korektaPoziomu() {

    }

}