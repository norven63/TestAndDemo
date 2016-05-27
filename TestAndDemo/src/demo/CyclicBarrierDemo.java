package demo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    static int i = 0;

    public static void main(String[] args) {
        final CyclicBarrier barrier = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("all end:" + i);
            }
        });

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    i++;
                    System.out.println("thread:" + Thread.currentThread().hashCode());
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
