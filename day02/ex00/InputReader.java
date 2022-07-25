package ex00;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class InputReader {

    private static final String RESULT = "ex00/result.txt";

    static String readInput(String input) {

        StringBuilder readBytes = new StringBuilder();

        try {

            FileInputStream fileInputStream = new FileInputStream(input);

            for (int i = 0; i < 8; i++) {
                readBytes.append(String.format("%02X ", fileInputStream.read()));
            }

            String str = readBytes.toString();
            System.out.println(str);
            fileInputStream.close();
            return readBytes.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    static void outputWriter(String str) {

        try {

            FileOutputStream fileOutputStream = new FileOutputStream(RESULT, true);

            for (int i = 0; i < str.length(); i++) {
                fileOutputStream.write((int) str.charAt(i));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
