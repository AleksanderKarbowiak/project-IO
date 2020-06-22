package Classes;

import org.junit.Test;
import java.io.File;
/**
 * Klasa do testowania integracyjnego nagrywania  - wyznaczania widma i kalibracji
 */
public class Integracyjny2_test
{

    public Nagrywarka nagrywarka = new Nagrywarka();
    /**  Podajemy nazwę rekordu dla testowego nagrania*/
    String nazwa = "TestNagrania";
    /**  Podajemy ścieżkę do zapisania pliku*/
    String path = "";
    /**  Podajemy długość rekordu w sekundach*/
    int dlugoscRekordu = 4;
    @org.junit.Test
    public void testNagrania() {
        try{
            nagrywarka.path = path;
            nagrywarka.Nagraj(nazwa,"test","test","17","male");
            Thread.sleep(dlugoscRekordu * 1000);
            nagrywarka.Stop();
            System.out.println("Nagrywanie trwało "+dlugoscRekordu+"s");
            infoAboutFile();
        }
        catch (Exception e){
            System.out.print(e);
        }
    }
    private void infoAboutFile() {
        File nagranie = new File(path + nazwa + ".wav");
        if(nagranie.exists() && !nagranie.isDirectory()) {
            if(path != ""){
                System.out.println("Plik istnieje.");
                System.out.println("Ścieżka do pliku: " + nagranie.getPath());
            }
            else{
                System.out.println("Plik istnieje. Znajduje się w głównym folderze projektu");
            }
            System.out.println("Nazwa pliku: " + nagranie.getName());
            double sizeKB = nagranie.length()/1024;
            System.out.println("Plik ma rozmiar: "+sizeKB+" KB");
        }
        else {
            System.out.println("Plik nie istnieje");
        }
    }

    double P=0;
    String nazwa2="TestKalibracji";
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
            n.Nagraj(nazwa2,"SSS","KKK","23","male");
            Thread.sleep(2*1000);
            n.Stop();
            System.out.println("Kalibracja przykładowego nagrania");
            Kalibracja.Kalibruj(nazwa2+".wav");
        }
        catch (Exception kal){
            System.out.println(kal);
        }
    }

    double a=2;
    double b=1;
    double częstotliwość=45;
    @Test
    public void TestWidmo(){
        widmo TestWidma = new widmo(a,b,częstotliwość);

        System.out.println("Test jednostkowy klasy widma dla a= "+a+" ,b= "+b+" ,częstotliwości= "+częstotliwość);
        System.out.println();
        TestMetodGet(TestWidma);
        TestMetody_ToString(TestWidma);
    }
    public void TestMetodGet(widmo Widmo){
        System.out.println("Test metod GET:");
        System.out.println("Częstotliwość: "+Widmo.getCzęstotliwość()+" Hz");
        System.out.println("Widmo Amplitudowe: "+Widmo.getWidmoAmplitudowe());
        System.out.println("Widmo Fazowe: "+Widmo.getWidmoFazowe());
        System.out.println("dB: "+Widmo.get_dB());
    }
    public void TestMetody_ToString(widmo Widmo){
        System.out.println();
        System.out.println("Test metody ToString: ");
        System.out.println(Widmo);
    }
}