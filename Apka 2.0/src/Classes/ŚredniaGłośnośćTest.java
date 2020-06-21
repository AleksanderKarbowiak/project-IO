package Classes;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Klasa służąca do testowania obliczania średniej głośności nagrania
 */
public class ŚredniaGłośnośćTest {

    String nazwaPliku = "test.wav";
    double[] tablica = {1.2, -5.9, 13.1, 7.0, -39.3, 21.37, -0.92, 0.0, 3.0, -9.99};
    double srednia = (1.2-5.9+13.1+7.0-39.3+21.37-0.92+3.0-9.99)/10;
    @Test
    public void TestKorekcjiA() {
        double[] wynikiA = ŚredniaGłośność.ObliczMocKorekcjaA(nazwaPliku, false);
        System.out.println("Wynik a: " + ŚredniaGłośność.ObliczŚrednią(wynikiA));

        wynikiA = ŚredniaGłośność.ObliczMocKorekcjaA(nazwaPliku, true);
        System.out.println("Wynik a: " + ŚredniaGłośność.ObliczŚrednią(wynikiA));
    }
    @Test
    public void TestKorekcjiC() {
        double[] wynikiC = ŚredniaGłośność.ObliczMocKorekcjaC(nazwaPliku, false);
        System.out.println("Wynik c: " + ŚredniaGłośność.ObliczŚrednią(wynikiC));

        wynikiC = ŚredniaGłośność.ObliczMocKorekcjaC(nazwaPliku, true);
        System.out.println("Wynik c: " + ŚredniaGłośność.ObliczŚrednią(wynikiC));
    }
    @Test
    public void TestKorekcjiZ() {
        double[] wynikiZ = ŚredniaGłośność.ObliczMocKorekcjaZ(nazwaPliku, false);
        System.out.println("Wynik z: " + ŚredniaGłośność.ObliczŚrednią(wynikiZ));

        wynikiZ = ŚredniaGłośność.ObliczMocKorekcjaZ(nazwaPliku, true);
        System.out.println("Wynik z: " + ŚredniaGłośność.ObliczŚrednią(wynikiZ));
    }

    public void TestŚredniej() {
        assertEquals(srednia, ŚredniaGłośność.ObliczŚrednią(tablica), 0);
    }

    @Test
    public void TestŚredniejGłośności() {
        TestŚredniej();
        //TestKorekcjiA();
        //TestKorekcjiC();
        //TestKorekcjiZ();
    }
}