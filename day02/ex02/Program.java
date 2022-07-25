package ex02;

import java.nio.file.*;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("I need 1 arg: --current-folder=...");
            System.exit(-1);
        }

        if (!args[0].startsWith("--current-folder=")) {
            System.err.println("I need --current-folder=...");
            System.exit(-1);
        }

        Path currentDirectory = Paths.get(args[0].substring(17));

        Scanner scanner = new Scanner(System.in);

        System.out.print(currentDirectory + "\n -> ");

        String[] line = scanner.nextLine().split("\\s+");
        Command command = new Command(currentDirectory);

        while (!line[0].equals("42") && !line[0].isEmpty()) {

            try {

                switch (line[0]) {
                    case "ls" :
                        command.ls();
                        break;
                    case "mv" :
                        if (line.length < 2 ) {
                            System.err.println("I need WHAT and WHERE");
                        } else if (line.length > 3) {
                            System.err.println("Too many args");
                        } else {
                            command.mv(line[1], line[2]);
                        }
                        break;
                    case "cd" :
                        command.cd(Paths.get(line[1]));
                        break;
                    case "exit" :
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Command not found.");
                        break;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.print(" -> ");
            line = scanner.nextLine().split("\\s+");

        }

    }

}
