package demo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ���ĵ������ࣺ
 * �̳߳ؽӿ� ExecutorService
 * �̳߳�ʵ�� ThreadPoolExecutor
 * �������� �ӿ� BlockingQueue
 * ��������������� PriorityBlockingQueue
 * 
 * 1��
 * ���ȣ�ÿ���̳߳��ڶ���һ�����������������滹����������������񡣸��ݲ�ͬ���̳߳�ʵ�֣��ڲ�����������ʵ��Ҳ������ͬ������ɲ���Դ�롣
 * 
 * 2��
 * ��ô�������ʵ�����ȼ��̳߳أ��ؼ�ֻҪʵ��������е����ȼ����ܼ��ɣ����Ǳ㿼��ʹ��PriorityBlockingQueue��
 * ������Լ��ڲ���ŵ�Ԫ�ؾ��������ܡ�
 * 
 * 3��
 * Executors�ĸ�������������Ȼ���������ǻ�ȡ��Ҫ�ľ��в�ͬ�ص��ExecutorService����ͬʱҲ�������޷��Զ������ڲ��Ĺ��죬
 * ����������������������������� �����ԣ�������Ҫ�Լ�new��һ��ExecutorService��������������ʹ�õ��������� ʵ�ִ������м��ɡ�
 * 
 * @author Administrator
 * 
 */
public class ExecutorAndPriorityBlockingQueue {
	private static class PriorityRunnable implements Runnable, Comparable<PriorityRunnable> {
		private final int priority;

		public PriorityRunnable(int priority) {
			super();
			this.priority = priority;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(1000);
				System.out.println(priority);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		@Override
		public int compareTo(PriorityRunnable o) {
			return this.priority - o.priority;
		}
	}

	public static void main(String[] args) {
		PriorityRunnable priorityRunnable19 = new PriorityRunnable(19);
		PriorityRunnable priorityRunnable1 = new PriorityRunnable(1);
		PriorityRunnable priorityRunnable11 = new PriorityRunnable(11);

		BlockingQueue<Runnable> priorityBlockingQueue = new PriorityBlockingQueue<>(1);
		int threads = 1;// ע���������������ֵΪ1ʱ,��ô��ӡ�������1��1�����֣�Ϊ2ʱ�����2��2�����֣��Դ����ơ�ԭ�������������ͬʱ���е��߳���
		ExecutorService executorService = new ThreadPoolExecutor(threads, threads, 0L, TimeUnit.MILLISECONDS, priorityBlockingQueue);
		executorService.execute(priorityRunnable11);
		executorService.execute(priorityRunnable11);
		executorService.execute(priorityRunnable19);
		executorService.execute(priorityRunnable1);
		executorService.execute(priorityRunnable19);

		// BlockingQueue<Runnable> priorityBlockingQueue1 = new
		// PriorityBlockingQueue<>(2);
		// BlockingQueue<PriorityRunnable> priorityBlockingQueue2 = new
		// PriorityBlockingQueue<>(2, new Comparator<PriorityRunnable>() {
		// @Override
		// public int compare(PriorityRunnable o1, PriorityRunnable o2) {
		// return -(o1.priority - o2.priority);
		// }
		// });
		//
		// priorityBlockingQueue1.offer(priorityRunnable19);
		// priorityBlockingQueue1.offer(priorityRunnable1);
		// priorityBlockingQueue1.offer(priorityRunnable11);
		//
		// priorityBlockingQueue2.offer(priorityRunnable19);
		// priorityBlockingQueue2.offer(priorityRunnable1);
		// priorityBlockingQueue2.offer(priorityRunnable11);
		//
		// ExecutorService executorService = Executors.newCachedThreadPool();
		// while (true) {
		// try {
		// PriorityRunnable priorityRunnable = (PriorityRunnable)
		// priorityBlockingQueue1.take();
		// // PriorityRunnable priorityRunnable = priorityBlockingQueue2.take();
		//
		// executorService.execute(priorityRunnable);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// }
	}
}
