package demo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 核心的两个类：
 * 线程池接口 ExecutorService
 * 线程池实现 ThreadPoolExecutor
 * 阻塞队列 接口 BlockingQueue
 * 带排序的阻塞队列 PriorityBlockingQueue
 * 
 * 1：
 * 首先，每个线程池内都有一个阻塞队列用来缓存还来不及被蹂躏的任务。根据不同的线程池实现，内部的阻塞队列实现也有所不同，具体可参阅源码。
 * 
 * 2：
 * 那么，如果想实现优先级线程池，关键只要实现任务队列的优先级功能即可，于是便考虑使用PriorityBlockingQueue，
 * 这货对自己内部存放的元素具有排序功能。
 * 
 * 3：
 * Executors的各个工厂方法虽然方便了我们获取想要的具有不同特点的ExecutorService，但同时也让我们无法自定义其内部的构造，
 * 包括他们用来缓存任务的阻塞队列 。所以，我们需要自己new出一个ExecutorService，并将我们所想使用的阻塞队列 实现传入其中即可。
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
		int threads = 1;// 注意这个参数！若其值为1时,那么打印输出将会1个1个出现；为2时，则会2个2个出现，以此类推。原因是这货代表了同时运行的线程数
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
