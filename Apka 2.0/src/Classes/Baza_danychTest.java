<<<<<<< HEAD
package Classes;

//import static org.junit.Assert.*;
//import java.io.*;
//import java.lang.reflect.Array;
//import java.util.ArrayList;
//import java.util.*;

//import java.io.File;


public class Baza_danychTest {

    public Baza_danych baza_danych = new Baza_danych();



    @org.junit.Test
    public void dodajNagranieTest()
    {
        try {
            System.out.println("dodajNagranieTest");
            baza_danych.dodajNagranie(new Nagranie("jeden", "aaa", "AAA"));
            baza_danych.dodajNagranie(new Nagranie("dwa", "bbb", "BBB"));
            baza_danych.dodajNagranie(new Nagranie("trzy", "ccc", "CCC"));
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
=======
package Classes;

//import static org.junit.Assert.*;
//import java.io.*;
//import java.lang.reflect.Array;
//import java.util.ArrayList;
//import java.util.*;
import org.junit.Test;
//import java.io.File;


public class Baza_danychTest {

    public Baza_danych baza_danych = new Baza_danych();



    @Test
    public void dodajNagranieTest()
    {
        try {
            System.out.println("dodajNagranieTest");
            baza_danych.dodajNagranie(new Nagranie("jeden", "aaa", "AAA"));
            baza_danych.dodajNagranie(new Nagranie("dwa", "bbb", "BBB"));
            baza_danych.dodajNagranie(new Nagranie("trzy", "ccc", "CCC"));
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

    @Test
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
    @Test
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
>>>>>>> 634daa31d7ba71c753c36dc5fa4b9438937a8359
}