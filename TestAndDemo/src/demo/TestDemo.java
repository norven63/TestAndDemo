package demo;

import java.util.ArrayList;
import java.util.List;

public class TestDemo {
	public static void main(String[] args) {
		A a = new A();
		List<A> list = a.testA(a);// ��������listʱ�����õ�A����������testA������һ��V��ֵ
		System.out.println(list.get(0));
	}

	static class A {
		// ��һ��V���Ƿ���������õġ��ڶ���Vֻ���������Ʒ���ֵ�����͡�
		public <V> List<V> testA(V v) {
			List<V> returnVlaue = new ArrayList<V>();
			returnVlaue.add(v);
			return returnVlaue;
		}
	}
}
