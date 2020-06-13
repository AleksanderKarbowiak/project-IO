package Classes;

/**
 * Klasa zawierająca równania krzywych korekcyjnych
 */
public class KrzyweKorekcyjne {

    /**
     * Metoda wywołuje metodę RAf i zamienia otrzymany wynik na decybele
     * @param f - częstotliwość
     * @return wartość w decybelach
     */
    public static double ObliczKrzywąA(double f) {
        double Af = 20 * Math.log10(RAf(f)) + 2;
        return Af;
    }

    /**
     * Metoda zwraca wartość z krzywej A dla zadanej częśtotliwości
     * @param f - częstotliwość
     * @return wartość krzywej
     */
    private static double RAf(double f) {
        double l = Math.pow(12194,2) * Math.pow(f,4);
        double m1 = Math.pow(f,2) + Math.pow(20.6,2);
        double m2 = Math.sqrt((Math.pow(f,2) + Math.pow(107.7,2))*(Math.pow(f,2) + Math.pow(737.9,2)));
        double m3 = Math.pow(f,2) + Math.pow(12194,2);
        double raf = l/(m1*m2*m3);

        return raf;
    }

    /**
     * Metoda wywołuje metodę RCf i zamienia otrzymany wynik na decybele
     * @param f - częstotliwość
     * @return wartość w decybelach
     */
    public static double ObliczKrzywąC(double f) {
        double Cf = 20 * Math.log10(RCf(f)) + 0.06;
        return Cf;
    }

    /**
     * Metoda zwraca wartość z krzywej C dla zadanej częśtotliwości
     * @param f - częstotliwość
     * @return wartość krzywej
     */
    private static double RCf(double f) {
        double l = Math.pow(12194,2) * Math.pow(f,2);
        double m1 = Math.pow(f,2) + Math.pow(20.6,2);
        double m2 = Math.pow(f,2) + Math.pow(12194,2);
        double rcf = l/(m1*m2);

        return rcf;
    }

    /**
     * Metoda zwraca wartość z krzywej Z dla zadanej częstotliwości
     * @param f - częstotliwość
     * @return wartość krzywej
     */
    public static double ObliczKrzywąZ(double f) {
        return 0;
    }

    public static void main(String[] args) {

        // TESTY KRZYWYCH
        double[] wyniki = new double[2048];
        double krok = 16000/2048.0;

        for(int i = 1; i < wyniki.length; i++) {
            wyniki[i] = ObliczKrzywąA(i*krok);
            System.out.println(wyniki[i]);
        }

        //Wykres w = new Wykres(wyniki, "A");
        //w.setVisible(true);

        for(int i = 1; i < wyniki.length; i++) {
            wyniki[i] = ObliczKrzywąC(i*krok);
            System.out.println(wyniki[i]);
        }

        //Wykres v = new Wykres(wyniki, "C");
        //v.setVisible(true);

    }

}
