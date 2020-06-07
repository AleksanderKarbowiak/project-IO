package Classes;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

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
    private JButton przebiegGlosnosciButton;
    private JButton bazaNagranButton;
    private JLabel ledIndicator;
    private JTextField wiekTextField;
    private JComboBox plec;
    private Baza_danych bazaNagrań;

    private Nagrywarka nagrywarka;

    public MainWindow(String title) {
        super(title);
        nagrywarka = new Nagrywarka();
        startButton.addActionListener(startListener);
        stopButton.addActionListener(stopListener);
        bazaNagranButton.addActionListener(addNewForm);
        bazaNagrań = new Baza_danych();
        bazaNagrań.pobierzListe();

        String[] Pleci=new String[]{"Male", "Female","Agender","Androgyne","Androgynous","Bi gender","Cis",
                "Cis gender","Cis Female","Cis Male","FTM","Gender Fluid","Gender Nonconforming","MTF","Neither","Non-binary","Pangender","Trans","Other"};
        for (int i=0;i<Pleci.length;i++)
        {
            plec.addItem(Pleci[i]);
        }
        plec.setSelectedIndex(0);
        czestotliwoscF0Button.addActionListener(obliczF0Panel);

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainWindow");
        frame.setContentPane(new MainWindow("Title").mainWindow);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

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
            JFrame frame = new JFrame("BazaDanychPanel");
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
