package demo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;

public class TestDemo {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年 MM月 dd日");
		System.out.println(sdf.format(new Date()));
		
		// Calendar calendar = Calendar.getInstance();
		// calendar.set(Calendar.WEEK_OF_MONTH, 2015);
		// calendar.set(Calendar.MONTH, 0);
		// calendar.set(Calendar.DAY_OF_MONTH, 1);
		// System.out.println(calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT,
		// Locale.CHINESE));
		// System.out.println(calendar.get(Calendar.HOUR_OF_DAY));

		// A a = new A();
		// List<A> list = a.testA(a);// 杩欓噷澹版槑list鏃讹紝鎵�鐢ㄧ殑A鍗充細缁欎笅闈㈢殑testA鏂规硶绗竴涓猇璧嬪��
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
		// 绗竴涓猇鎵嶆槸鏂规硶閲屽彲浠ョ敤鐨勩�傜浜屼釜V鍙槸鐢ㄦ潵鎺у埗杩斿洖鍊肩殑绫诲瀷銆�
		public <V> List<V> testA(V v) {
			List<V> returnVlaue = new ArrayList<V>();
			returnVlaue.add(v);
			return returnVlaue;
		}
	}
}
