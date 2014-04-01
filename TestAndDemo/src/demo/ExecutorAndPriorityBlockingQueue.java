package demo;

import java.util.Comparator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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

	private static class PriorityCompartor implements Comparator<PriorityRunnable> {
		@Override
		public int compare(PriorityRunnable o1, PriorityRunnable o2) {
			return -(o1.priority - o2.priority);
		}
	}

	public static void main(String[] args) {
		PriorityRunnable priorityRunnable19 = new PriorityRunnable(19);
		PriorityRunnable priorityRunnable1 = new PriorityRunnable(1);
		PriorityRunnable priorityRunnable11 = new PriorityRunnable(11);

		int threads = 2;// 注意这个参数！若值为1,那么打印输出时为1个1个出现；为2，则2个2个出现，以此类推。原因是这货代表了同事运行的线程数
		BlockingQueue<Runnable> priorityBlockingQueue = new PriorityBlockingQueue<>(1);
		// BlockingQueue priorityBlockingQueue = new PriorityBlockingQueue<>(1, new
		// PriorityCompartor());
		ExecutorService executorService = new ThreadPoolExecutor(threads, threads, 0L, TimeUnit.MILLISECONDS, priorityBlockingQueue);
		executorService.execute(priorityRunnable11);
		executorService.execute(priorityRunnable11);
		executorService.execute(priorityRunnable19);
		executorService.execute(priorityRunnable1);
		executorService.execute(priorityRunnable19);

		// BlockingQueue<Runnable> priorityBlockingQueue1 = new
		// PriorityBlockingQueue<>(2);
		// BlockingQueue<PriorityRunnable> priorityBlockingQueue2 = new
		// PriorityBlockingQueue<>(2, new PriorityCompartor());
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
