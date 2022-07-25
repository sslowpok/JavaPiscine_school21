package ex00;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SignaturesReader {

    private static final String SIGNATURES = "ex00/signatures.txt";

    static Map<String, String> readParseSignatures() {

        StringBuilder buffer = new StringBuilder();

        try {

            FileInputStream fileInputStream = new FileInputStream(SIGNATURES);

            int i = 0;

            Map<String, String> map = new HashMap<>();

            while ((i = fileInputStream.read()) != -1) {

                if ((char) i == '\n') {
                    String[] str = buffer.toString().split(", ");
                    map.put(str[0], str[1]);
                    buffer.setLength(0);
                } else {
                    buffer.append((char) i);
                }
            }

            if (buffer.length() != 0) {
                String[] str = buffer.toString().split(", ");
                map.put(str[0], str[1]);
            }

            fileInputStream.close();

            return map;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
