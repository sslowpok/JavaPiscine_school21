package edu.school21.printer.app;

import edu.school21.printer.logic.Logic;

public class Program {

    public static void main(String[] args) {

        if (args.length != 3) {
            System.err.println("I need 3 args");
            System.exit(-1);
        }

        char whiteChar = args[0].charAt(0);
        char blackChar = args[1].charAt(0);

        String path = args[2];

        int[][] array2d = Logic.readBmpImage(path, whiteChar, blackChar);

        for (int i = 0; i < array2d.length; i++) {
            for (int j = 0; j < array2d[i].length; j++) {

                System.out.print((char) array2d[j][i]);

            }
            System.out.println();
        }

    }

}
