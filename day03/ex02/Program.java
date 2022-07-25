package ex02;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.random;

public class Program {

    public static void main(String[] args) {

        if (args.length != 2) {
            System.err.println("I need 2 args");
            System.exit(-1);
        } else if (!args[0].startsWith("--arraySize=") || !args[1].startsWith("--threadsCount=")) {
            System.err.println("Ok, but incorrect");
            System.exit(-1);
        }

        int arraySize = 0;
        int threadsCount = 0;

        try {
            arraySize = Integer.parseInt(args[0].substring(12));
            threadsCount = Integer.parseInt(args[1].substring(15));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        if (threadsCount > arraySize) {
            System.err.println("More threads than elements in array? Seriously?");
            System.exit(-1);
        }

        ArrayList<Integer> array = new ArrayList<>(arraySize);
        for (int i = 0; i < arraySize; i++) {
            int num = (int) ((random() * 2000) - 1000);
            array.add(num);
        }

        List<Thread> threadList = new ArrayList<>(threadsCount);
        int threadArraySize = arraySize / threadsCount;

        for (int i = 0; i < threadsCount; i++) {
            if (i == threadsCount - 1) {
                threadList.add(new LocalThread(i + 1, i * threadArraySize, arraySize - 1, array));
            } else {
                threadList.add(new LocalThread(i + 1, i * threadArraySize, (i + 1) * threadArraySize - 1, array));
            }
        }

        System.out.println("Sum: " + countArraySum(array));


        for (Thread t : threadList) {
            t.start();
        }

        for (Thread t : threadList) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Sum by threads: " + LocalThread.getThreadSum());

    }

    private static int countArraySum(ArrayList<Integer> array) {

        int sum = 0;

        for (Integer integer : array) {
            sum += integer;
        }

        return sum;
    }

}
