package Classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ŚredniaGłośnośćPanel extends JFrame {
    private JButton obliczBtn1;
    private JComboBox comboBox1;
    private JPanel WybórNagraniaPanel;
    private JLabel WybierzTxt;
    public JPanel ŚredniaGłośnośćPanel;
    private JLabel wynikTxt3;
    private JLabel wynikTxt1;
    private JLabel wynikTxt2;
    private JComboBox wybórOkna;

    /**
     * Konstruktor panelu Średnia Głośność
     * @param nazwa
     * @param baza
     */
    public ŚredniaGłośnośćPanel(String nazwa, Baza_danych baza){
        super(nazwa);

        for(Nagranie nagranie : baza.nagrania) {
            comboBox1.addItem(nagranie.nazwa);
        }
        String fast = "Okno szybkie - 0.125 s";
        String slow = "Okno wolne - 1 s";
        wybórOkna.addItem(fast);
        wybórOkna.addItem(slow);

        /**
         * Listener wywołuje metody obliczające średnią głośność oraz wyświetla wykres przebiegu głośności nagrania
         */
        obliczBtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String file = (String) comboBox1.getSelectedItem();
                file += ".wav";
                System.out.println(file);

                String oknoS = (String) wybórOkna.getSelectedItem();
                boolean okno;
                if (oknoS == "Okno szybkie - 0.125 s") {
                    okno = true;
                } else {
                    okno = false;
                }

                double[] wynikiA = ŚredniaGłośność.ObliczMocKorekcjaA(file, okno);
                double średniaA = ŚredniaGłośność.ObliczŚrednią(wynikiA);
                System.out.println(średniaA);
                double[] wynikiC = ŚredniaGłośność.ObliczMocKorekcjaC(file, okno);
                double średniaC = ŚredniaGłośność.ObliczŚrednią(wynikiC);
                double[] wynikiZ = ŚredniaGłośność.ObliczMocKorekcjaZ(file, okno);
                double średniaZ = ŚredniaGłośność.ObliczŚrednią(wynikiZ);

                // Wyniki zaokrąglam do 2 miejsc po przecinku

                średniaA *= 100;
                średniaA = Math.round(średniaA);
                średniaA /= 100;

                średniaC *= 100;
                średniaC = Math.round(średniaC);
                średniaC /= 100;

                średniaZ *= 100;
                średniaZ = Math.round(średniaZ);
                średniaZ /= 100;


                wynikTxt1.setText("Średnia głośność z korekcją A: " + średniaA + " dB");
                wynikTxt2.setText("Średnia głośność z korekcją C: " + średniaC + " dB");
                wynikTxt3.setText("Średnia głośność z korekcją Z: " + średniaZ + " dB");

                GłośnośćWykres wykres = new GłośnośćWykres(wynikiA, wynikiC, wynikiZ, "Przebieg głośności nagrania");
                wykres.setVisible(true);
            }
        });
    }
}
