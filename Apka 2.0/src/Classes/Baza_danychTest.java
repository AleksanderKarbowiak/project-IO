package Classes;

//import static org.junit.Assert.*;
//import java.io.*;
//import java.lang.reflect.Array;
//import java.util.ArrayList;
//import java.util.*;

//import java.io.File;

/**
 * Klasa służąca do testowania bazy danych
 */
public class Baza_danychTest {

    public Baza_danych baza_danych = new Baza_danych();



    @org.junit.Test
    public void dodajNagranieTest()
    {
        try {
            System.out.println("dodajNagranieTest");
            baza_danych.dodajNagranie(new Nagranie("jeden", "aaa", "AAA","11","female"));
            baza_danych.dodajNagranie(new Nagranie("dwa", "bbb", "BBB","22","male"));
            baza_danych.dodajNagranie(new Nagranie("trzy", "ccc", "CCC","18","male"));
            System.out.println("Lista nagran: ");
            for (Nagranie x : baza_danych.nagrania)
            {
                x.getNagranieData();
            }
        }
        catch (Exception exception)
        {
            System.out.println(exception);
        }
    }

    @org.junit.Test
    public void zapiszListeTest()
    {
        try
        {
            System.out.println("zapiszListeTest");
            baza_danych.zapiszListe();
        }
        catch (Exception exception)
        {
            System.out.println(exception);
        }
    }
    @org.junit.Test
    public void pobierzListeTest()
    {
        try {
            System.out.println("pobierzListeTest");
            baza_danych = null;
            Baza_danych baza_danych = new Baza_danych();
            baza_danych.pobierzListe();
            for (Nagranie x : baza_danych.nagrania) {
                x.getNagranieData();
            }
        }
        catch (Exception exception)
        {
            System.out.println(exception);
        }
    }

    @org.junit.Test
    public void setNagrania_() {
    }

    @org.junit.Test
    public void nagrania() {
    }
}
