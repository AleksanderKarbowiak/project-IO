package Classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
/**
 * Klasa okna spektogramu
 */
public class SpektrogramPanel extends JFrame {

    public JPanel SpektrogramPanel;
    private JPanel wybórPanel;
    private JComboBox comboBox1;
    private JComboBox oknoBox;
    private JComboBox fmaxBox;
    private JButton SpektrogramBtn;
    private JComboBox probkiBox;
    private JLabel probkiTxt;

    /**
     * Konstruktor panelu Spektrogram
     * @param nazwa
     * @param baza
     */
    public SpektrogramPanel(String nazwa, Baza_danych baza) {
        super(nazwa);

        for (Nagranie nagranie : baza.nagrania) {
            comboBox1.addItem(nagranie.nazwa);
        }
        oknoBox.addItem("Okna niezależne");
        oknoBox.addItem("Okna zazębiające się w połowie");
        fmaxBox.addItem("8000");
        fmaxBox.addItem("16000");
        fmaxBox.addItem("22000");
        probkiBox.addItem("1024");
        probkiBox.addItem("2048");
        probkiBox.addItem("4096");

        SpektrogramBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String file = (String) comboBox1.getSelectedItem();
                file += ".wav";
                String okna = (String) oknoBox.getSelectedItem();
                int x;
                if(okna == "Okna niezależne") {
                    x = 1;
                } else {
                    x = 2;
                }
                int probki = Integer.parseInt((String)probkiBox.getSelectedItem());

                double[][] dane = Spektrogram.ObliczDaneDlaSpektrogramu(file, x, probki);
                int fmax = Integer.parseInt((String) fmaxBox.getSelectedItem());
                Spektrogram.RysujSpektrogram(dane, 44100, fmax);

            }
        });

    }
}
