package Classes;

import java.util.ArrayList;
import java.util.List;

public class TestDatabase extends Baza_danych {

    public TestDatabase() {
        List<Nagranie> nagrania = new ArrayList<>();
        nagrania.add(new Nagranie("Testowe", "Jan", "Kowalski"));
        nagrania.add(new Nagranie("Testowe 2", "Adam", "Nowak"));
        nagrania.add(new Nagranie("Nazwa nagrania", "Imie", "Nazwisko"));
        setNagrania_(nagrania);
    }

}
