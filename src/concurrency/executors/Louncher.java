package concurrency.executors;

import static concurrency.threadslesson.ColorSheme.RED;

public class Louncher {
    private static final int POOL_SIZE = 2;

    public static void main(String[] args) throws InterruptedException {
        boolean isDaemon = false;
        System.out.println(RED + "Starting main thread");
        GCDRunnable r = new GCDRunnable(isDaemon);
        runInOneThread(r, isDaemon);
        Thread.sleep(1500);
        System.out.println(RED + "Leaving the main thread");
    }
    private static void runInOneThread(GCDRunnable r, boolean isDaemon) throws InterruptedException {
        Thread th = new Thread(r);
        if (isDaemon){
            th.setDaemon(true);
        }
        th.start();
//        Thread.sleep(100);
//        th.interrupt();
    }
}