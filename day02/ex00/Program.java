package ex00;

import java.util.Map;
import java.util.Scanner;

public class Program {


    public static void main(String[] args) {

        Map<String, String> signaturesMap = SignaturesReader.readParseSignatures();

        System.out.print("Input -> ");

        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNext()) {
            System.exit(0);
        }

        String input = scanner.next();

        boolean isProcessed = false;

        while (!input.equals("42")) {

            isProcessed = false;

            String signaturesFromInput = InputReader.readInput(input);

            System.out.println("From input: " + signaturesFromInput);

            for (Map.Entry<String, String> entry : signaturesMap.entrySet()) {
                if (signaturesFromInput.startsWith(entry.getValue())) {
                    InputReader.outputWriter(entry.getKey());
                    InputReader.outputWriter("\n");
                    System.out.println("PROCESSED");
                    isProcessed = true;
                }
            }

            if (!isProcessed) {
                System.out.println("UNDEFINED");
            }

            System.out.print("Input -> ");
            input = scanner.next();
        }



    }

}
