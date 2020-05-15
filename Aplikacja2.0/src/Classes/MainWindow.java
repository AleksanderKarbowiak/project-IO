package Classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private JPanel mainWindow;
    private JTextField imięTextField;
    private JButton startButton;
    private JButton stopButton;
    private JButton średniaGłośnośćButton;
    private JButton częstotliwośćF0Button;
    private JButton zmianaCzęstotliwościF0Button;
    private JButton widmoButton;
    private JButton spektrogramButton;
    private JTextField nazwiskoTextField;
    private JButton zapiszButton;
    private JTextField nazwaNagraniaField;

    private Nagrywarka nagrywarka;

    public MainWindow(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainWindow);
        this.pack();
        nagrywarka = new Nagrywarka();
        startButton.addActionListener(startListener);
        stopButton.addActionListener(stopListener);
    }

    public static void main(String[] args) {
        JFrame frame = new MainWindow("Aplikacja");
        frame.setVisible(true);
    }

    ActionListener startListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            nagrywarka.Nagraj(nazwaNagraniaField.getText(),imięTextField.getText(),nazwiskoTextField.getText());
        }
    };

    ActionListener stopListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            nagrywarka.Stop();
        }
    };
}
