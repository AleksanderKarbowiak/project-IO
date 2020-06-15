package Classes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class F0Panel extends JFrame {
    public JPanel F0Panel;
    private JPanel WyborNagraniaPanel;
    private JButton obliczF0Button;
    private JComboBox comboBox1;
    private JLabel WybierzTxt;
    private JLabel WynikTxt;
    private JLabel momentyTxt;
    private JTextField momentField;
    private JButton F0MomentButton;
    private JLabel wynikMomentu;

    private int ileMomentów;
    
    /**
     * Konstruktor panelu F0
     * @param nazwa
     * @param baza
     */
    public F0Panel(String nazwa, Baza_danych baza) {
        super(nazwa);

        for(Nagranie nagranie : baza.nagrania) {
            comboBox1.addItem(nagranie.nazwa);
        }

        String wybrany = (String) comboBox1.getSelectedItem();
        ileMomentów = F0.IleMomentów(wybrany + ".wav");
        if(ileMomentów == 0) {
            momentyTxt.setText("Brak dostępnych momentów");
        } else {
            momentyTxt.setText("Wpisz numer od 1 do " + ileMomentów);
        }

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String wybrany = (String) comboBox1.getSelectedItem();
                ileMomentów = F0.IleMomentów(wybrany + ".wav");
                if(ileMomentów == 0) {
                    momentyTxt.setText("Brak dostępnych momentów");
                } else {
                    momentyTxt.setText("Wpisz numer od 1 do " + ileMomentów);
                }
            }
        });

        obliczF0Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String file = (String) comboBox1.getSelectedItem();

                double f0 = F0.ObliczŚrednieF0(file + ".wav");
                WynikTxt.setText("Średnie F0 wynosi: " + f0 + " Hz");
            }
        });

        F0MomentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String file = (String) comboBox1.getSelectedItem();
                int ile = Integer.parseInt(momentField.getText());
                if (ile > 0 && ile <= ileMomentów) {
                    double f0 = F0.ObliczF0wJednymMomencie(file + ".wav", ile);
                    wynikMomentu.setText("F0 w wybranym momencie wynosi: " + f0 + "Hz");
                } else {
                    wynikMomentu.setText("Podano nieprawidłowy moment");
                }
            }
        });

    }
}
