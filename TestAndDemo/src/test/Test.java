package test;

public class Test {
	public static void main(String[] args) {
		// ClassC_1 c_1 = new ClassA_1().getB().getC();
		// ClassC_2 c_2 = new ClassA_2().getB().getC();

		ClassC_1 c = getC();
	}

	public static <T> T getC() {
		InterfaceA<T> a = (InterfaceA<T>) new ClassA_1();
		T c = a.getB().getC();

		return c;
	}
}
