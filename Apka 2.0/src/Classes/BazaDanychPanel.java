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
            model.addRow(new Object[]{ nagranie.nazwa, Szyfrowanie(nagranie.imie), Szyfrowanie(nagranie.nazwisko),nagranie.wiek,nagranie.plec });
            databaseTable.setModel(model);
        }
    }
    
    /**
     * Metoda zamienia litery znaki podanego stringa na gwiazdki
     * @param dane
     * @return 
     */
    private String Szyfrowanie(String dane)
    {
        String gwiazdki="*";
        for (int i=0;i<dane.length()-1;i++)
        {
            gwiazdki+="*";
        }
        return gwiazdki;
    }

}
