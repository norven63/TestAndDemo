package demo;

import java.util.Date;

public class A {
    public static void main(String[] args) {
        long foo = new Date().getTime();

        try {
            Thread.sleep(3 * 1000);

            System.out.println(new Date().getTime() - foo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
