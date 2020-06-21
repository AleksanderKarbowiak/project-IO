package Classes;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Klasa służąca do testowania klasy widmo
 */
public class widmoTest {

    double a=2;
    double b=1;
    double częstotliwość=45;

    @Test
    public void TestWidmo(){
        widmo TestWidma = new widmo(a,b,częstotliwość);

        System.out.println("Test jednostkowy klasy widma dla a= "+a+" ,b= "+b+" ,częstotliwości= "+częstotliwość);
        System.out.println();
        TestMetodGet(TestWidma);
        TestMetody_ToString(TestWidma);
    }


    public void TestMetodGet(widmo Widmo){
        System.out.println("Test metod GET:");
        System.out.println("Częstotliwość: "+Widmo.getCzęstotliwość()+" Hz");
        System.out.println("Widmo Amplitudowe: "+Widmo.getWidmoAmplitudowe());
        System.out.println("Widmo Fazowe: "+Widmo.getWidmoFazowe());
        System.out.println("dB: "+Widmo.get_dB());
    }

    public void TestMetody_ToString(widmo Widmo){
        System.out.println();
        System.out.println("Test metody ToString: ");
        System.out.println(Widmo);
    }


}