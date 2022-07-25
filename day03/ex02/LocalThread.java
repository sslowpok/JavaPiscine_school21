package ex02;

import java.util.ArrayList;

public class LocalThread extends Thread {

    private final int id;
    private final int startIndex;
    private final int endIndex;
    private final ArrayList<Integer> arrayList;
    private static int threadSum;

    public LocalThread(int id, int startIndex, int endIndex, ArrayList<Integer> arrayList) {
        this.id = id;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.arrayList = arrayList;
    }

    @Override
    public void run() {

        int sum = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            sum += arrayList.get(i);
        }
        printSum(sum);
        threadSum += sum;

    }

    public synchronized void printSum(int sum) {
        System.out.println("Thread " + id + ": from " + arrayList.get(startIndex) +
                " to " + arrayList.get(endIndex) + " sum is " + sum);
    }

    public static int getThreadSum() {
        return threadSum;
    }

}
