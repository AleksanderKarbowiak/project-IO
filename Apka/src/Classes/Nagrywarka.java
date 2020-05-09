package Classes;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Class Nagrywarka
 */
public class Nagrywarka {

    File wavFile;
    /** Format audio - .WAV */
    AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
    TargetDataLine line;
    /** Scieżka do Bazy Nagrań w której umieszczane będą pliki audio */
    String path = "Tutaj ścieżka do folderu";

    /**
     * Metoda wywoływująca funkcję rozpoczynająca nagrywanie i zwracająca obiekt klasy Nagranie
     * @param nazwa - nazwa nagrania
     * @param imie - imie użytkownika
     * @param nazwisko - nazwisko użytkownika
     * @return nagranie
     */

    Nagranie Nagraj(String nazwa, String imie, String nazwisko) {
        Nagranie nagranie = new Nagranie(nazwa, imie, nazwisko);
        wavFile = new File(path + nazwa + ".wav");
        Start();
        return nagranie;
    }

    /**
     * Metoda rozpoczynająca nagrywanie
     */
    void Start() {
        try {
            /** Format audio - częstotliwość próbkowania, rozmiar próbki w bitach, wybór Mono/Stereo */
            AudioFormat format = new AudioFormat(16000, 8, 2, true, true);
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);

            /** Wyjątek w przypadku błędu przy połączeniu z mikrofonem (np. brak mikrofonu) */
            if (!AudioSystem.isLineSupported(info)) {
                System.out.println("Line not supported");
                System.exit(0);
            }

            /** Rozpoczęcie nagrywania */
            line = (TargetDataLine) AudioSystem.getLine(info);
            line.open(format);
            line.start();
            //System.out.println("Przechwytywanie");
            AudioInputStream ais = new AudioInputStream(line);
            System.out.println("Nagrywanie rozpoczęte");

            AudioSystem.write(ais, fileType, wavFile);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoda kończąca nagrywanie
     */
    void Stop() {
        line.stop();
        line.close();
        System.out.println("Zakończono nagrywanie");
    }
  
    /**
     * Set the value of path
     * @param newVar the new value of path
     */
    public void setPath (String newVar) {
        path = newVar;
    }

    /**
     * Get the value of path
     * @return the value of path
     */
    public String getPath () {
        return path;
    }
}
