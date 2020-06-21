package Classes;

import java.io.*;
import javax.sound.sampled.*;

/**
 * Klasa służąca do obsługi nagrywania
 */
public class Nagrywarka {

    File wavFile;
    /** Format audio - .WAV */
    AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
    TargetDataLine line;
    /** Scieżka do Bazy Nagrań w której umieszczane będą pliki audio */
    String path = "";

    /**
     * Metoda wywoływująca funkcję rozpoczynająca nagrywanie i zwracająca obiekt klasy Nagranie
     * @param nazwa - nazwa nagrania
     * @param imie - imie użytkownika
     * @param nazwisko - nazwisko użytkownika
     * @return nagranie
     */

    Nagranie Nagraj(String nazwa, String imie, String nazwisko, String wiek, String plec) {
        Nagranie nagranie = new Nagranie(nazwa, imie, nazwisko, wiek, plec);
        wavFile = new File(path + nazwa + ".wav");
        Start();
        return nagranie;
    }

    /**
     * Metoda rozpoczynająca nagrywanie
     */
    private void Start() {
        try {
            /** Format audio - częstotliwość próbkowania, rozmiar próbki w bitach, wybór Mono/Stereo */
            AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_UNSIGNED,44100, 8, 2, 2, 16000, false);
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);

            /** Wyjątek w przypadku błędu przy połączeniu z mikrofonem (np. brak mikrofonu) */
            if (!AudioSystem.isLineSupported(info)) {
                System.out.println("Line not supported");
                System.exit(0);
            }

            line = (TargetDataLine) AudioSystem.getLine(info);
            line.open(format);
            line.start();
            AudioInputStream ais = new AudioInputStream(line);

            /** Implementacja funckcji run dla wątku */
            Runnable runner = new Runnable() {
                @Override
                public void run() {
                    try {
                        AudioSystem.write(ais, fileType, wavFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };

            /** Rozpoczęcie nagrywania */
            System.out.println("Nagrywanie rozpoczęte");
            Thread wątek = new Thread(runner);
            wątek.start();

        } catch (LineUnavailableException e) {
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
