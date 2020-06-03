/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Klasa służąca do zamiany Small Endian na BigEndian i odwrotnie.
 * Klasa zawiera tylko metody statyczne!
 *
 * @author Piotr Wrzeciono
 * @since 2016.02.17
 */
public class LittleBigEndian
{
    /**
     * Metoda zamieniająca signed int na tablicę bajtów w uporządkowaniu Little Endian.
     * @param x Liczba do konwersji.
     * @return Tablica z reprezentacją Little Endian (4 bajty!).
     */
    public static byte[] ZamieńSignedIntNaTablicęLittleEndian(int x)
    {
        byte[] wynik;
        int[] tablica_pom;
        int i;

        wynik = new byte[4];
        tablica_pom = new int[4];

        tablica_pom[0] = x & 0x000000ff; //Najmniej znaczący bajt
        tablica_pom[1] = (x & 0x0000ff00) >> 8;
        tablica_pom[2] = (x & 0x00ff0000) >> 16;
        tablica_pom[3] = (x & 0xff000000) >> 24; //Najbardziej znaczący bajt

        for(i = 0; i < 4; i++) wynik[i] = (byte)tablica_pom[i];

        return wynik;
    }//Koniec metody zamieniającej Int na tablicę small endian

    /**
     * Metoda zamieniająca unsigned int (w reprezentacji long) na tablicę bajtów w konwencji Little Endian.
     * @param x Liczba do konwersji
     * @return Tablica z reprezentacją LittleEndian (4 bajty!).
     */
    public static byte[] ZamieńUnsignedIntNaTablicęLittleEndian(long x)
    {
        byte[] wynik;
        int[] tablica_pom;
        int i;

        wynik = new byte[4];
        tablica_pom = new int[4];

        tablica_pom[0] = (int)(x & 0x000000ff); //Najmniej znaczący bajt
        tablica_pom[1] = (int)((x & 0x0000ff00) >> 8);
        tablica_pom[2] = (int)((x & 0x00ff0000) >> 16);
        tablica_pom[3] = (int)((x & 0xff000000) >> 24); //Najbardziej znaczący bajt

        for(i = 0; i < 4; i++) wynik[i] = (byte)tablica_pom[i];

        return wynik;
    }//Koniec metody zamieniającej Unsigned Int na tablicę small endian

    /**
     * Metoda konwertująca signed short na tablicę w konwencji LittleEndian.
     * @param x Liczba do konwersji
     * @return Tablica z reprezentacją Little Endian (2 bajty!).
     */
    public static byte[] ZamieńShortNaTablicęLittleEndian(short x)
    {
        byte[] wynik;
        short[] tablica_pom;
        int i;

        wynik = new byte[2];
        tablica_pom = new short[2];

        tablica_pom[0] = (short)(x & 0x00ff); //Najmniej znaczący bajt
        tablica_pom[1] = (short)((x & 0xff00) >> 8);


        for(i = 0; i < 2; i++) wynik[i] = (byte)tablica_pom[i];

        return wynik;
    }//Koniec metody zamieniającej short na tablicę small endian

    /**
     * Metoda konwertująca unsigned short (w reprezentacji int) do tablicy w konwencji Little Endian
     * @param x Liczba do konwersji
     * @return Tablica z reprezentacją Little Endian (2 bajty).
     */
    public static byte[] ZamieńUnsignedShortNaTablicęLittleEndian(int x)
    {
        byte[] wynik;
        int[] tablica_pom;
        int i;

        wynik = new byte[2];
        tablica_pom = new int[2];

        tablica_pom[0] =  x & 0x000000ff; //Najmniej znaczący bajt
        tablica_pom[1] = (x & 0x0000ff00) >> 8;


        for(i = 0; i < 2; i++) wynik[i] = (byte)tablica_pom[i];

        return wynik;
    }//Koniec metody zamieniającej short na tablicę small endian

    /**
     * Metoda konwertująca tablicę bajtów (2 elementy) na unsigned short (w reprezentacji int).
     * @param UnsignedShort Tablica w konwencji Little Endian
     * @return Liczba
     */
    public static int UtwórzUnsignedShortZLittleEndian(byte[] UnsignedShort)
    {
        byte[] TablicaPomocnicza;
        int wynik;

        TablicaPomocnicza = new byte[4];

        TablicaPomocnicza[3] = 0;
        TablicaPomocnicza[2] = 0;
        TablicaPomocnicza[1] = UnsignedShort[1];
        TablicaPomocnicza[0] = UnsignedShort[0];

        wynik = ByteBuffer.wrap(TablicaPomocnicza).order(ByteOrder.LITTLE_ENDIAN).getInt();

        return wynik;
    }//Koniec metody

    /**
     * Metoda konwertująca tablicę bajtów (4 bajty) na unsigned int (w reprezentacji long).
     * @param UnsignedInt Tablica bajtów w konwencji Little Endian
     * @return Liczba
     */
    public static long UtwórzUnsignedIntZLittleEndian(byte[] UnsignedInt)
    {
        byte[] TablicaPomocnicza;
        int wynik;

        TablicaPomocnicza = new byte[8];

        TablicaPomocnicza[7] = 0;
        TablicaPomocnicza[6] = 0;
        TablicaPomocnicza[5] = 0;
        TablicaPomocnicza[4] = 0;
        TablicaPomocnicza[3] = UnsignedInt[3];
        TablicaPomocnicza[2] = UnsignedInt[2];
        TablicaPomocnicza[1] = UnsignedInt[1];
        TablicaPomocnicza[0] = UnsignedInt[0];

        wynik = ByteBuffer.wrap(TablicaPomocnicza).order(ByteOrder.LITTLE_ENDIAN).getInt();

        return wynik;
    }//Koniec metody

    /**
     * Metoda konwertująca tablicę bajtów (2 elementy) na signed short.
     * @param SignedShort Tablica bajtów w konwencji Little Endian.
     * @return Liczba
     */
    public static short UtwórzSignedShortZLittleEndian(byte[] SignedShort)
    {
        short wynik;

        wynik = ByteBuffer.wrap(SignedShort).order(ByteOrder.LITTLE_ENDIAN).getShort();

        return wynik;
    }//Koniec metody

    /**
     * Metoda konwertująca tablicę bajtów (4 elementy) na signed int.
     * @param SignedInt Tablica bajtów w konwencji Little Endian.
     * @return Liczba
     */
    public static int UtwórzSignedIntZLittleEndian(byte[] SignedInt)
    {
        int wynik;

        wynik = ByteBuffer.wrap(SignedInt).order(ByteOrder.LITTLE_ENDIAN).getInt();

        return wynik;
    }//Koniec metody

    public static int UtwórzSignedInt24bitZLittleEndian(byte[] bit24)
    {
        byte[] pomoc;
        int wynik;

        pomoc = new byte[4];

        pomoc[3] = 0;
        pomoc[2] = bit24[2];
        pomoc[1] = bit24[1];
        pomoc[0] = bit24[0];

        wynik = UtwórzSignedIntZLittleEndian(pomoc);

        if(wynik > 0x007fffff) //Uwaga! - liczba ujemna!
        {
            wynik = (~wynik) & 0x00ffffff ;
            wynik = -(wynik + 1);
        }//end if

        return wynik;
    }//Koniec tworzenia signed int z 24.

    public static void main(String[] arg)
    {
        long x = 352800;
        short y = 18;
        short z = -54;
        int a = -356;
        int res1;
        int res2;
        long res3;
        short res4;
        int res5;

        byte[] test = LittleBigEndian.ZamieńUnsignedIntNaTablicęLittleEndian(x);
        byte[] test1 = LittleBigEndian.ZamieńShortNaTablicęLittleEndian(y);
        byte[] test2 = LittleBigEndian.ZamieńUnsignedShortNaTablicęLittleEndian((int)x);
        byte[] test3 = LittleBigEndian.ZamieńShortNaTablicęLittleEndian(z);
        byte[] test4 = LittleBigEndian.ZamieńSignedIntNaTablicęLittleEndian(a);

        for(int i=0;i < test.length; i++) System.out.println("test[" + i + "] = 0x" + Integer.toHexString(test[i] & 0x000000ff));
        for(int i=0;i < test1.length; i++) System.out.println("test1[" + i + "] = 0x" + Integer.toHexString(test1[i] & 0x000000ff));
        for(int i=0;i < test1.length; i++) System.out.println("test2[" + i + "] = 0x" + Integer.toHexString(test2[i] & 0x000000ff));

        res1 = LittleBigEndian.UtwórzUnsignedShortZLittleEndian(test1);
        res2 = LittleBigEndian.UtwórzUnsignedShortZLittleEndian(test2);
        //res3 = LittleBigEndian.UtwórzSinedShortZLittleEndian(test2);
        res4 = LittleBigEndian.UtwórzSignedShortZLittleEndian(test3);
        res5 = LittleBigEndian.UtwórzSignedIntZLittleEndian(test4);

        System.out.println("res1 = " + res1);
        System.out.println("res2 = " + res2);
        //System.out.println("res3 = " + res3);
        System.out.println("res4 = " + res4);
        System.out.println("res5 = " + res5);

    }//Koniec testowej metodu main

}//Koniec klasy
