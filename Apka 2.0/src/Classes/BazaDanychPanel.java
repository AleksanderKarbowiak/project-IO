package Classes;

import javax.swing.*;
import javax.swing.table.*;
import java.util.ArrayList;
import java.util.List;

public class BazaDanychPanel extends JFrame {
    public JPanel DatabasePanel;
    private JLabel label;
    private JTable databaseTable;
    private JList list1;

    /**
     * Konstruktor panelu bazy danych
     * @param title
     * @param database
     */
    public BazaDanychPanel(String title, Baza_danych database) {
        super(title);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nazwa");
        model.addColumn("Imie");
        model.addColumn("Nazwisko");
        model.addColumn("Wiek");
        model.addColumn("Płeć");
        model.addRow(new Object[]{"Nazwa","Imię","Nazwisko","Wiek","Płeć"});
        for (Nagranie nagranie : database.nagrania()) {
            model.addRow(new Object[]{ nagranie.nazwa, nagranie.imie, nagranie.nazwisko,nagranie.wiek,nagranie.plec });
            databaseTable.setModel(model);
        }
    }


}
