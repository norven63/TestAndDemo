package demo;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolTest {
	public static void main(String[] args) {
		// ������ʱ��
		final ScheduledExecutorService schedule = Executors.newScheduledThreadPool(1);

		// ��ʼ����
		final Future future1 = schedule.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				System.out.println("����1");
			}
		}, 2, 1, TimeUnit.SECONDS);// 2��ʾ2���ִ��,1��ʾѭ�����Ϊ1��

		final Future future2 = schedule.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				System.out.println("����2");
			}
		}, 2, 1, TimeUnit.SECONDS);

		// ȡ������
		schedule.schedule(new Runnable() {
			@Override
			public void run() {
				future1.cancel(false);// ȡ������1
				System.out.println("����1��ȡ��!");
			}
		}, 4, TimeUnit.SECONDS);

		schedule.schedule(new Runnable() {
			@Override
			public void run() {
				schedule.shutdown();// ȡ�������̳߳�
				System.out.println("�̳߳���ȡ��!");
			}
		}, 6, TimeUnit.SECONDS);
	}
}
