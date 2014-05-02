package demo;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolTest {
	public static void main(String[] args) {
		// 创建定时器
		final ScheduledExecutorService schedule = Executors.newScheduledThreadPool(1);

		// 开始任务
		final Future future1 = schedule.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				System.out.println("任务1");
			}
		}, 2, 1, TimeUnit.SECONDS);// 2表示2秒后执行,1表示循环间隔为1秒

		final Future future2 = schedule.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				System.out.println("任务2");
			}
		}, 2, 1, TimeUnit.SECONDS);

		// 取消任务
		schedule.schedule(new Runnable() {
			@Override
			public void run() {
				future1.cancel(false);// 取消任务1
				System.out.println("任务1已取消!");
			}
		}, 4, TimeUnit.SECONDS);

		schedule.schedule(new Runnable() {
			@Override
			public void run() {
				schedule.shutdown();// 取消整个线程池
				System.out.println("线程池已取消!");
			}
		}, 6, TimeUnit.SECONDS);
	}
}
