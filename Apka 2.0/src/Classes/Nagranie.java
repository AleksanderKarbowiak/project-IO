package Classes;

import java.io.*;
import java.util.*;

/**
 * Klasa służąca do odczytywania danych użytkownika z pliku i wyświetlania ich.
 *
 * @author Paweł Rogulski
 * @since 2019.03.21
 */

public class Nagranie implements Serializable {

    String nazwa;
    String imie;
    String nazwisko;

    /**
     * Konstruktor klasy Nagranie
     *
     * @param nazwa - nazwa nagrania
     * @param imie - imie użytkownika
     * @param nazwisko - nazwisko użytkownika
     */

    Nagranie(String nazwa, String imie, String nazwisko) {
        this.nazwa = nazwa;
        this.imie = imie;
        this.nazwisko = nazwisko;
    }
    public String getImie(){
        return imie;
    }

    public String getNazwisko(){
        return nazwisko;
    }

    public String getNazwa(){
        return nazwa;
    }

    //metoda do wypisywania zawartości obiektu
    public void getNagranieData(){
        System.out.print(getImie() + " " + getNazwisko()+ " " + getNazwa() +'\n');
    }

}
