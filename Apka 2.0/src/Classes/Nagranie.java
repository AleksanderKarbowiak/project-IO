/**
 * Klasa służąca do odczytywania danych użytkownika z pliku i wyświetlania ich
 */

public class Nagranie implements Serializable {

    String nazwa;
    String imie;
    String nazwisko;

    /**
     * Konstruktor klasy Nagranie
     *
     * @param nazwa - nazwa nagrania
     * @param imie - imie użytkownika
     * @param nazwisko - nazwisko użytkownika
     */

    Nagranie(String nazwa, String imie, String nazwisko) {
        this.nazwa = nazwa;
        this.imie = imie;
        this.nazwisko = nazwisko;
    }
    /**
    * metoda zwracająca imie użytkownika
     */
    public String getImie(){
        return imie;
    }

    /**
     * metoda zwracająca nazwisko użytkownika
     */
    public String getNazwisko(){
        return nazwisko;
    }

    /**
     * metoda zwracająca nazwe nagrania
     */
    public String getNazwa(){
        return nazwa;
    }

    /**
    *metoda do wypisywania zawartości obiektu
     */
    public void getNagranieData(){
        System.out.print(getImie() + " " + getNazwisko()+ " " + getNazwa() +'\n');
    }

}
