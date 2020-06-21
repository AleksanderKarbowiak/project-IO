package Classes;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


/**
 * Klasa głównego okna - MainWindow
 */
public class MainWindow extends JFrame {
    private JPanel mainWindow;
    private JTextField imieTextField;
    private JButton startButton;
    private JButton stopButton;
    private JButton sredniaGlosnoscButton;
    private JButton czestotliwoscF0Button;
    private JButton zmianaCzestotliwosciF0Button;
    private JButton widmoButton;
    private JButton spektrogramButton;
    private JTextField nazwiskoTextField;
    private JTextField nazwaNagraniaField;
    private JButton kalibrujButton;
    private JButton bazaNagranButton;
    private JLabel ledIndicator;
    private JTextField wiekTextField;
    private JComboBox plec;
    private Baza_danych bazaNagrań;

    private Nagrywarka nagrywarka;

    /**
     * Konstruktor klasy
     * @param title
     */
    public MainWindow(String title) {
        super(title);
        nagrywarka = new Nagrywarka();
        startButton.addActionListener(startListener);
        stopButton.addActionListener(stopListener);
        widmoButton.addActionListener(widmoListener);
        sredniaGlosnoscButton.addActionListener(głośnośćListener);
        kalibrujButton.addActionListener(kalibrujListener);
        bazaNagranButton.addActionListener(addNewForm);
        imieTextField.addFocusListener(ImieListener);
        nazwiskoTextField.addFocusListener(NazwiskoListener);
        nazwaNagraniaField.addFocusListener(NazwaNagraniaListener);
        wiekTextField.addFocusListener(WiekListener);
        spektrogramButton.addActionListener(spektrogramListener);
        bazaNagrań = new Baza_danych();
        bazaNagrań.pobierzListe();
        try {
            Kalibracja.pobierzNagranie();
            Kalibracja.Kalibruj(Kalibracja.nagranieKalibracyjne);
        } catch (Exception e) { // jeśli brak pliku to tworzy go
            e.printStackTrace();
            try {
                File plik = new File("nagranieKalibr.dat");
                plik.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        String[] Pleci=new String[]{"Male", "Female","Agender","Androgyne","Androgynous","Bi gender","Cis",
                "Cis gender","Cis Female","Cis Male","FTM","Gender Fluid","Gender Nonconforming","MTF","Neither","Non-binary","Pangender","Trans","Other"};
        for (int i=0;i<Pleci.length;i++)
        {
            plec.addItem(Pleci[i]);
        }
        plec.setSelectedIndex(0);
        czestotliwoscF0Button.addActionListener(obliczF0Panel);

    }

    /**
     * Metoda main dla klasy MainWindow
     * @param args
     */

    public static void main(String[] args) {
        JFrame frame = new JFrame("Anaraiza");
        frame.setContentPane(new MainWindow("Title").mainWindow);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
    ActionListener widmoListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame = new JFrame("Widmo DTFT");
            frame.setContentPane(new WidmoPanel("Title2", bazaNagrań).WidmoPanel);
            frame.pack();
            frame.setVisible(true);
        }
    };
    ActionListener spektrogramListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame = new JFrame("Spektrogram");
            frame.setContentPane(new SpektrogramPanel("Title", bazaNagrań).SpektrogramPanel);
            frame.pack();
            frame.setVisible(true);
        }
    };
    FocusListener ImieListener = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            if (imieTextField.getText().contains("imię")) {
                imieTextField.setText("");
            }
        }
        @Override
        public void focusLost(FocusEvent e) {
            if(imieTextField.getText().isEmpty())
            {
                imieTextField.setText("imię");
            }
        }
    };
    FocusListener NazwiskoListener = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            if (nazwiskoTextField.getText().contains("nazwisko")) {
                nazwiskoTextField.setText("");
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if(nazwiskoTextField.getText().isEmpty())
            {
                nazwiskoTextField.setText("nazwisko");
            }
        }
    };
    FocusListener NazwaNagraniaListener =new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            if (nazwaNagraniaField.getText().contains("nazwa nagrania")) {
                nazwaNagraniaField.setText("");
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if(nazwaNagraniaField.getText().isEmpty())
            {
                nazwaNagraniaField.setText("nazwa nagrania");
            }
        }
    };
    FocusListener WiekListener = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            if(wiekTextField.getText().contains("wiek")) {
                wiekTextField.setText("");
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if(wiekTextField.getText().isEmpty())
            {
                wiekTextField.setText("wiek");
            }
        }
    };
    ActionListener głośnośćListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame = new JFrame("Średnia Głośność");
            frame.setContentPane(new ŚredniaGłośnośćPanel("Title2", bazaNagrań).ŚredniaGłośnośćPanel);
            frame.pack();
            frame.setVisible(true);
        }
    };

    ActionListener kalibrujListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame = new JFrame("Kalibracja");
            frame.setContentPane(new KalibrujPanel("Title2", bazaNagrań).KalibrujPanel);
            frame.pack();
            frame.setVisible(true);
        }
    };

    ActionListener startListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Nagranie nagranie = nagrywarka.Nagraj(nazwaNagraniaField.getText(), imieTextField.getText(),nazwiskoTextField.getText(),wiekTextField.getText(),(String) plec.getSelectedItem());
            ledIndicator.setText("⚫ ");
            ledIndicator.setForeground(Color.RED);
            System.out.println("Dodawanie nagrania");
            bazaNagrań.dodajNagranie(nagranie);
        }
    };

    ActionListener addNewForm = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame = new JFrame("Baza Danych");
            frame.setContentPane(new BazaDanychPanel("Title2", bazaNagrań).DatabasePanel);
            frame.pack();
            frame.setVisible(true);
        }
    };

    ActionListener obliczF0Panel = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame = new JFrame("Oblicz F0");
            frame.setContentPane(new F0Panel("Oblicz F0", bazaNagrań).F0Panel);
            frame.pack();
            frame.setVisible(true);
        }
    };

    ActionListener stopListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            nagrywarka.Stop();
            ledIndicator.setText("⚪ ");
            ledIndicator.setForeground(new Color(187, 187, 187));
            bazaNagrań.zapiszListe();
        }
    };
}
