package demo;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class EventBusTest {
	public static void main(String[] args) {
		EventBus bus = new EventBus();
		EventBus bus2 = new EventBus();

		IntegerListenr1 listenr1 = new IntegerListenr1();
		IntegerListenr2 listenr2 = new IntegerListenr2();

		bus.register(listenr1);
		bus.register(listenr2);
		bus2.register(listenr2);

		bus.post(2);
		bus2.post(3);
	}

	public static class IntegerListenr1 {
		@Subscribe
		public void handler1(Integer event) {
			System.out.println("listener1_handler1: " + event);
		}

		@Subscribe
		public void handler2(Integer event) {
			System.out.println("listener1_handler2: " + event);
		}
	}

	public static class IntegerListenr2 {
		@Subscribe
		public void handler(Integer event) {
			System.out.println("listener2: " + event);
		}
	}
}
