package Classes;

import java.io.*;
import java.util.*;
/**
 * Klasa służąca do odczytywania danych użytkownika z pliku i wyświetlania ich
 */
public class Nagranie implements Serializable {

    String nazwa;
    String imie;
    String nazwisko;
    String wiek;
    String plec;
    /**
     * Konstruktor klasy Nagranie
     *
     * @param nazwa - nazwa nagrania
     * @param imie - imie użytkownika
     * @param nazwisko - nazwisko użytkownika
     * @param wiek - wiek użytkownika
     * @param plec - płeć użytkownika
     */

    Nagranie(String nazwa, String imie, String nazwisko, String wiek,String plec) {
        this.nazwa = nazwa;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
        this.plec = plec;
    }
    /**
     * metoda zwracająca imie użytkownika
     */
    public String getImie(){
        return imie;
    }
    /**
     * metoda zwracająca nazwisko użytkownika
     */
    public String getNazwisko(){
        return nazwisko;
    }
    /**
     * metoda zwracająca nazwe nagrania
     */
    public String getNazwa(){
        return nazwa;
    }

    public  String getWiek(){return wiek;}

    public  String getPlec(){return plec;}
    /**
     *metoda do wypisywania zawartości obiektu
     */
    public void getNagranieData(){
        System.out.print(getImie() + " " + getNazwisko()+ " " + getNazwa() + " " + getWiek() + " " + getPlec() + '\n');
    }

}
