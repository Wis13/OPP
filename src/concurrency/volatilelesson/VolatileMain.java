package concurrency.volatilelesson;

import static concurrency.threadslesson.ColorSheme.GREEN;
import static concurrency.threadslesson.ColorSheme.RED;

public class VolatileMain {

    private static volatile int counter;

    public static void main(String[] args) {


        new SimpleWriter().start();
        new SimpleReader().start();
    }

    private static class SimpleWriter extends Thread {
        @Override
        public void run() {
            int localCounter = counter;
            for (int i = 0; i<10; i++) {
                System.out.println(GREEN + "Writer incriments counter " + (localCounter + 1));
                counter = ++localCounter;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    private static class SimpleReader extends Thread {
        @Override
        public void run() {
            int localCounter = counter;
                while (localCounter < 10) {
                    if (localCounter != counter) {
                        System.out.println(RED+"Reader read counter " + counter);
                        localCounter = counter;
                    }
                }

            }
        }

}
