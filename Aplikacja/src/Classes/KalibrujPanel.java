package Classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Klasa okna kalibracji
 */
public class KalibrujPanel extends JFrame {
    public JPanel KalibrujPanel;
    private JPanel wybórPanel;
    private JComboBox comboBox1;
    private JButton kalibrujBtn;
    private JLabel wybierzTxt;
    private JLabel wynikTxt;

    /**
     * Konstruktor klasy KalibrujPanel
     * @param nazwa
     * @param baza
     */
    public KalibrujPanel (String nazwa, Baza_danych baza) {
        super(nazwa);

        for (Nagranie nagranie : baza.nagrania) {
            comboBox1.addItem(nagranie.nazwa);
        }

        kalibrujBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String file = (String) comboBox1.getSelectedItem();
                file += ".wav";

                Kalibracja.Kalibruj(file);
                wynikTxt.setText("Korekta została zaaktualizowana.");
            }
        });
    }
}
