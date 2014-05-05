package test;

public class Test {
	public static void main(String[] args) {
		String string = "a.b.c";
		String[] strings = string.split("\\.");
		for (String item : strings) {
			System.out.println(item);
		}
	}
}
