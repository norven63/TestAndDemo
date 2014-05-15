package test;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		String string = "a.b.c";
		String[] strings = string.split("\\.");
		for (String item : strings) {
			System.out.println(item);
		}

		List list = new ArrayList();
		System.out.println(list.size());
		aaa(list);
		System.out.println(list.size());
	}

	public static void aaa(List s) {
		s.add("1");
	}
}
