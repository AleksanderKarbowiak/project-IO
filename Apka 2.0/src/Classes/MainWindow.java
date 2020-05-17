package Classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JButton zapiszButton;
    private JTextField nazwaNagraniaField;
    private JButton przebiegGlosnosciButton;
    private JButton bazaNagranButton;
    private Baza_danych database;

    private Nagrywarka nagrywarka;

    public MainWindow(String title) {
        super(title);
        nagrywarka = new Nagrywarka();
        startButton.addActionListener(startListener);
        stopButton.addActionListener(stopListener);
        zapiszButton.addActionListener(startListener);
        bazaNagranButton.addActionListener(addNewForm);
        this.database = new TestDatabase();
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
            nagrywarka.Nagraj(nazwaNagraniaField.getText(), imieTextField.getText(),nazwiskoTextField.getText());
            database.dodajNagranie(new Nagranie(nazwaNagraniaField.getText(), imieTextField.getText(), nazwiskoTextField.getText()));
        }
    };

    ActionListener addNewForm = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame = new JFrame("BazaDanychPanel");
            frame.setContentPane(new BazaDanychPanel("Title2", database).DatabasePanel);
            frame.pack();
            frame.setVisible(true);
        }
    };

    ActionListener stopListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            nagrywarka.Stop();
        }
    };
}
