package demo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 本示例说明：各个线程的barrier.await()超时逻辑都会被执行到。
 * 如果想编写一段统一的超时逻辑（或者说结束逻辑），需要自行实现防止重复调用的控制。
 */
public class CyclicBarrierDemo {
    static int i = 0;

    public static void main(String[] args) {
        int workCount = 3;

        final CyclicBarrier barrier = new CyclicBarrier(workCount, new Runnable() {
            @Override
            public void run() {
                allFinish();//在barrier.await()被调用次数达到workCount后会被执行
            }
        });

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                try {
                    i++;

                    System.out.println("thread:" + Thread.currentThread().hashCode());

                    barrier.await(1, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    allFinish();
                } catch (BrokenBarrierException e) {
                    allFinish();
                } catch (TimeoutException e) {
                    allFinish();
                }
            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                //这里并没有调用barrier.await()方法，从而导致Runnable1中的barrier.await()超时。
            }
        };

        new Thread(runnable1).start();
        new Thread(runnable1).start();
        new Thread(runnable2).start();
    }

    /**
     * 结束逻辑
     */
    private static void allFinish() {
        System.out.println("all end:" + i);
    }
}
