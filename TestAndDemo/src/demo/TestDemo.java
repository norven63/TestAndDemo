package demo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import com.google.gson.Gson;

public class TestDemo {
	public static void main(String[] args) {
		// Calendar calendar = Calendar.getInstance();
		// calendar.set(Calendar.WEEK_OF_MONTH, 2015);
		// calendar.set(Calendar.MONTH, 0);
		// calendar.set(Calendar.DAY_OF_MONTH, 1);
		// System.out.println(calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT,
		// Locale.CHINESE));
		// System.out.println(calendar.get(Calendar.HOUR_OF_DAY));

		// A a = new A();
		// List<A> list = a.testA(a);// 这里声明list时，所用的A即会给下面的testA方法第一个V赋值
		// System.out.println(list.get(0));
		
		String a = "{\"a\":\"abc\",\"b\":2}";

		System.out.println(new Gson().fromJson(a, B.class));
	}

	static class B {
		private String a = "yyy";
		private int b = 9999;

		@Override
		public String toString() {
			return "B [a=" + a + ", b=" + b + "]";
		}
	}

	static class A {
		// 第一个V才是方法里可以用的。第二个V只是用来控制返回值的类型。
		public <V> List<V> testA(V v) {
			List<V> returnVlaue = new ArrayList<V>();
			returnVlaue.add(v);
			return returnVlaue;
		}
	}
}
