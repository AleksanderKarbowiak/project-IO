package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
/**
 * Klasa okna widma
 */
public class WidmoPanel extends JFrame{
    private JComboBox comboBox1;
    private JButton okButton;
    private JLabel name;
    private JPanel text;
    public JPanel WidmoPanel;
    private JTextField textField1;
    private JSpinner FrequencySpinner;
    private JTextField textField3;
    private Baza_danych baza;

    private int iloscProbek;
    private int czestotliwosc;
    private int amplituda;

    /**
     * Konstruktor panelu widma
     * @param text
     * @param baza
     */
    public WidmoPanel(String text, Baza_danych baza) {
        super(text);
        this.baza = baza;
        for(Nagranie nagranie : baza.nagrania) {
            comboBox1.addItem(nagranie.nazwa);
        }
        SpinnerModel model = new SpinnerNumberModel(20, 20, 8000, 1);
        FrequencySpinner.setModel(model);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                czestotliwosc = (Integer) FrequencySpinner.getValue();
                wyswietlWidmo();
            }
        });
    }
    /**
        Metoda wyświetla widmo DTFT
    */
    public void wyswietlWidmo() {
        Ramka Okno;
        DTFT Transformata;

        double fs; //Parametry próbkowania
        double f_max; //Parametry DTFT
        double f_min;
        double f_krok;

        widmo[] wynik = new widmo[2048];

        String file = (String) comboBox1.getSelectedItem();
        PlikWave plik = new PlikWave( file + ".wav");
        plik.OtwórzIstniejącyPlik();

        fs = plik.getCzęstotliwośćPróbkowania();
        f_max = fs/2;
        f_min = czestotliwosc;
        f_krok = fs/2048;
        Transformata = new DTFT(f_min, f_max, f_krok, fs);

        int ileProbek = 4096;
        int indexProbki = 0;
        double[] probkiSuma = new double[2048];

        while (indexProbki + ileProbek < plik.getLiczbęPróbek())
        {
            byte[] probki = plik.PobierzKilkaPróbek(indexProbki, ileProbek);
            indexProbki += ileProbek;

            double[] probkiL = new double[ileProbek/2];
            int licznikL = 0;
            for (int i = 0; i < probkiL.length; i++)
            {
                if (i % 2 == 0)
                {
                    probkiL[licznikL++] = probki[i];
                }
            }

            for (int i = 0; i < probkiSuma.length; i++)
            {
                probkiSuma[i] += probkiL[i];
            }
        }

        wynik = Transformata.ObliczDTFT(probkiSuma);

        /*Okno = new Ramka(600,600,"Wykres widma",10,10, wynik);
        Okno.UstawMnieNaŚrodku();
        Okno.setVisible(true);
        */
        WykresWidma wykres = new WykresWidma(wynik, "Widmo");
        wykres.setSize(800, 400);
        wykres.setLocationRelativeTo(null);
        wykres.setVisible(true);
        //WyprowadźWidmo(wynik);

    }

}
