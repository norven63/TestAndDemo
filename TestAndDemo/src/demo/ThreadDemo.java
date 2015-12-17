package demo;

public class ThreadDemo {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadDemo.test(1);
            }
        }).run();

        new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadDemo.test(2);
            }
        }).run();
    }

    /**
     * 该函数是synchronized的，所以一次只能有一个线程访问
     */
    private synchronized static void test(int threadNum) {
        System.out.println(threadNum);

        try {
            Thread.sleep(500);
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }

        ThreadDemo.test(threadNum);
    }
}
