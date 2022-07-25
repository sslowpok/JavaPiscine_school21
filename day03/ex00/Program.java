package ex00;

public class Program {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("I need argument!");
            System.exit(-1);
        } else if (!args[0].startsWith("--count=")) {
            System.err.println("Ok, but argument has to start from --count=...");
            System.exit(-1);
        }

        int count = Integer.parseInt(args[0].substring(8));

        if (count < 1) {
            System.err.println("Invalid argument!");
            System.exit(-1);
        }

        Hen hen = new Hen(count);
        Egg egg = new Egg(count);

        hen.start();
        egg.start();

        try {
            egg.join();
            hen.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < count; i++) {
            System.out.println("Human");
        }

    }

}
