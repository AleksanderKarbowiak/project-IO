package Classes;

import javax.swing.*;
import javax.swing.table.*;
import java.util.List;

public class BazaDanychPanel extends JFrame {
    public JPanel DatabasePanel;
    private JLabel label;
    private JTable databaseTable;
    private JList list1;
    private Baza_danych database;

    public BazaDanychPanel(String title, Baza_danych database) {
        super(title);
        this.database = database;
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nazwa");
        model.addColumn("Imie");
        model.addColumn("Nazwisko");
        List<Nagranie> nagrania = database.nagrania();
        for (Nagranie nagranie : nagrania) {
            model.addRow(new Object[]{ nagranie.nazwa, nagranie.imie, nagranie.nazwisko });
            databaseTable.setModel(model);
        }
    }


}
