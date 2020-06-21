package Classes;

import java.io.File;

/**
 * Klasa służąca do testowania nagrywania
 */
public class NagrywarkaTest {
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
}
