import javax.swing.*;

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

    public MainWindow(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainWindow);
        this.pack();
    }

    public static void main(String[] args) {
        JFrame frame = new MainWindow("Aplikacja");
        frame.setVisible(true);
    }
}
