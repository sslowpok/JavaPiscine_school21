package ex01;

public class Program {

    public static boolean isEgg = false;

    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("I need one argument!");
            System.exit(-1);
        } else if (!args[0].startsWith("--count=")) {
            System.err.println("Ok, but arg has to start with --count=...");
            System.exit(-1);
        }

        int count = Integer.parseInt(args[0].substring(8));

        if (count < 1) {
            System.err.println("Invalid argument!");
            System.exit(-1);
        }

        Egg egg = new Egg(count);
        Hen hen = new Hen(count);

        egg.start();
        hen.start();

        try {
            egg.join();
            hen.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static synchronized void sayHen() {

        if (!isEgg) {

            try {
                Program.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

            System.out.println("Hen");
            isEgg = false;
            Program.class.notify();

    }

    public static synchronized void sayEgg() {

        if (isEgg) {

            try {
                Program.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
            System.out.println("Egg");
            isEgg = true;
            Program.class.notify();

    }

}
