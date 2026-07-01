package org.example.flappybird;

import java.io.*;

public class HighScore {

    private static final String FILE_NAME = "highscore.txt";

    public static int load() {

        try {

            File file = new File (FILE_NAME);

            if (!file.exists ()) {
                return 0;
            }

            BufferedReader reader =
                    new BufferedReader (
                            new FileReader (file)
                    );

            int score =
                    Integer.parseInt (
                            reader.readLine ()
                    );

            reader.close ();

            return score;

        } catch (Exception e) {

            return 0;
        }
    } //завантажує рекорд із текстового файлу. Якщо файл не існує або виникла помилка,
    // повертається значення 0

    public static void save(int score) {

        try {

            BufferedWriter writer =
                    new BufferedWriter (
                            new FileWriter (FILE_NAME)
                    );

            writer.write (
                    String.valueOf (score)
            );

            writer.close ();

        } catch (Exception e) {

            e.printStackTrace ();
        }
    }
} // зберігає рекорд у текстовий файл
// Він отримує кількість виграшів як параметр і записує її у файл хайскор