package concurrency.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static concurrency.threadslesson.ColorSheme.*;

public class SynchronizedBuffer {

    private static final Lock monitor = new ReentrantLock(true);

    private static final Condition canRead = monitor.newCondition();
    private static final Condition canWrite = monitor.newCondition();

    private static int buffer = 0;
    private static boolean isEmpty = true;


    public static void main(String[] args) {
        new Thread(SynchronizedBuffer::blockingWrite).start();
        new Thread(SynchronizedBuffer::blockingRead).start();
    }

    private static void blockingWrite() {
        for (int i = 0; i < 10; i++) {
            monitor.lock();
            try {
                while (!isEmpty){
                    System.out.println(YELLOW + "Writer is trying to access a resourse" );
                    System.out.println(YELLOW + "Buffer is full" );
                    canWrite.await(5, TimeUnit.SECONDS);
                }
            buffer++;
            isEmpty = false;
            System.out.println(GREEN + "Writer produser " + buffer);
            canRead.signal();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                monitor.unlock();
            }


        }


    }

    private static void blockingRead() {
        for (int i = 0; i < 10; i++) {
            monitor.lock();
            try {
                while (isEmpty){
                    System.out.println(BLUE + "Reader is trying to access a resourse" );
                    System.out.println(BLUE + "Buffer is full" );
                    canRead.await(5, TimeUnit.SECONDS);
                }
                int readValue = buffer;
                isEmpty = true;
                System.out.println(RED + "Reader reads from buffer: " + readValue);
                canWrite.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                monitor.unlock();
            }


        }

    }
}
