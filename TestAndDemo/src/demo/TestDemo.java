package demo;

public class TestDemo {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                TestDemo.test(1);
            }
        }).run();

        new Thread(new Runnable() {
            @Override
            public void run() {
                TestDemo.test(2);
            }
        }).run();
    }

    private synchronized static void test(int threadNum) {
        System.out.println(threadNum);

        try {
            Thread.sleep(500);
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }

        TestDemo.test(threadNum);
    }
}
