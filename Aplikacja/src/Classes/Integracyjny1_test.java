package Classes;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

/**
 * Klasa do testowania komunikacji pomiędzy klasami: Nagrywarka,FO i ŚredniaGłośność
 */
public class Integracyjny1_test
{

    public Nagrywarka nagrywarka = new Nagrywarka();
    String nazwa = "TestNagrania";
    String path = "";
    int dlugoscRekordu = 4;

    int moment = 2;
    F0 testF0 = new F0();

    double[] tablica = {1.2, -5.9, 13.1, 7.0, -39.3, 21.37, -0.92, 0.0, 3.0, -9.99};
    double srednia = (1.2-5.9+13.1+7.0-39.3+21.37-0.92+3.0-9.99)/10;


    public void testNagrania()
    {

        try
        {
            nagrywarka.path = path;
            nagrywarka.Nagraj(nazwa,"test","test","17","male");
            Thread.sleep(dlugoscRekordu * 1000);
            nagrywarka.Stop();

            System.out.println("Nagrywanie trwało "+dlugoscRekordu+"s");

            infoAboutFile();

        }
        catch (Exception e)
        {
            System.out.print(e);
        }
    }


    private void infoAboutFile()
    {
        File nagranie = new File(path + nazwa + ".wav");

        if(nagranie.exists() && !nagranie.isDirectory())
        {
            if(path != "")
            {
                System.out.println("Plik istnieje.");
                System.out.println("Ścieżka do pliku: " + nagranie.getPath());
            }
            else
            {
                System.out.println("Plik istnieje. Znajduje się w głównym folderze projektu");
            }
            System.out.println("Nazwa pliku: " + nagranie.getName());

            double sizeKB = nagranie.length()/1024;
            System.out.println("Plik ma rozmiar: "+sizeKB+" KB");
        }
        else
        {
            System.out.println("Plik nie istnieje");
        }
    }

    public void TestMomentów()
    {

        int i = testF0.IleMomentów(nazwa);
        System.out.println("Liczba momentów: "+i);
    }


    public void TestŚredniegoF0()
    {
        double i = testF0.ObliczŚrednieF0(nazwa);
        System.out.println("Średnie F0: "+i);
    }


    public void TestF0wJednymMomencie()
    {
        double i = testF0.ObliczF0wJednymMomencie(nazwa,moment);
        System.out.println("F0 w pewnym momencie: "+i);
    }

    public void TestKorekcjiA() {
        double[] wynikiA = ŚredniaGłośność.ObliczMocKorekcjaA(nazwa, false);
        System.out.println("Wynik a: " + ŚredniaGłośność.ObliczŚrednią(wynikiA));

        wynikiA = ŚredniaGłośność.ObliczMocKorekcjaA(nazwa, true);
        System.out.println("Wynik a: " + ŚredniaGłośność.ObliczŚrednią(wynikiA));
    }

    public void TestKorekcjiC() {
        double[] wynikiC = ŚredniaGłośność.ObliczMocKorekcjaC(nazwa, false);
        System.out.println("Wynik c: " + ŚredniaGłośność.ObliczŚrednią(wynikiC));

        wynikiC = ŚredniaGłośność.ObliczMocKorekcjaC(nazwa, true);
        System.out.println("Wynik c: " + ŚredniaGłośność.ObliczŚrednią(wynikiC));
    }

    public void TestKorekcjiZ() {
        double[] wynikiZ = ŚredniaGłośność.ObliczMocKorekcjaZ(nazwa, false);
        System.out.println("Wynik z: " + ŚredniaGłośność.ObliczŚrednią(wynikiZ));

        wynikiZ = ŚredniaGłośność.ObliczMocKorekcjaZ(nazwa, true);
        System.out.println("Wynik z: " + ŚredniaGłośność.ObliczŚrednią(wynikiZ));
    }

    public void TestŚredniej() {
        assertEquals(srednia, ŚredniaGłośność.ObliczŚrednią(tablica), 0);
    }






    @Test
    public void TestIntegracyjny()
    {
        testNagrania();
        TestMomentów();
        TestŚredniegoF0();
        //TestF0wJednymMomencie();

        TestŚredniej();
        //TestKorekcjiA();
        //TestKorekcjiC();
        //TestKorekcjiZ();
    }
}
