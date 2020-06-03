package Classes;

import javax.swing.*;
import java.awt.event.*;

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
            Nagranie nagranie = nagrywarka.Nagraj(nazwaNagraniaField.getText(), imieTextField.getText(),nazwiskoTextField.getText());
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
            bazaNagrań.zapiszListe();
        }
    };
}
