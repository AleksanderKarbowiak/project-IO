package Classes;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Klasa do testowania obliczania F0
 */
public class F0Test {

 String nazwaPliku = "plik.wav";

 int moment = 2;

 F0 testF0 = new F0();

 @org.junit.Test
 public void TestMomentów() {

 int i = testF0.IleMomentów(nazwaPliku);
 System.out.println("Liczba momentów: "+i);

 }

 @org.junit.Test
 public void TestŚredniegoF0(){
 double i = testF0.ObliczŚrednieF0(nazwaPliku);
 System.out.println("Średnie F0: "+i);
 }

 @org.junit.Test
 public void TestF0wJednymMomencie(){
 double i = testF0.ObliczF0wJednymMomencie(nazwaPliku,moment);
 System.out.println("F0 w pewnym momencie: "+i);
 }

 @org.junit.Test
 public void TestF0(){
 TestMomentów();
 TestŚredniegoF0();
 //TestF0wJednymMomencie();
 }

 }