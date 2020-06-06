package Classes;

<<<<<<< HEAD
=======
import org.junit.Test;
>>>>>>> 634daa31d7ba71c753c36dc5fa4b9438937a8359
import java.io.File;


public class NagrywarkaTest {
    public Nagrywarka nagrywarka = new Nagrywarka();

    /**  Podajemy nazwę rekordu dla testowego nagrania*/
    String nazwa = "TestNagrania";

    /**  Podajemy ścieżkę do zapisania pliku*/
    String path = "";

    /**  Podajemy długość rekordu w sekundach*/
    int dlugoscRekordu = 4;


<<<<<<< HEAD
    @org.junit.Test
=======
    @Test
>>>>>>> 634daa31d7ba71c753c36dc5fa4b9438937a8359
    public void testNagrania() {

        try{
            nagrywarka.path = path;
            nagrywarka.Nagraj(nazwa,"test","test") ;
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
}