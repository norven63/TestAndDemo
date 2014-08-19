package demo.typeParameter;

public class ClassA_2 implements InterfaceA<ClassC_2> {

	@Override
	public InterfaceB<ClassC_2> getB() {
		return new ClassB_2();
	}

}
