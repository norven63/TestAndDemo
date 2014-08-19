package demo.typeParameter;

public class ClassA_1 implements InterfaceA<ClassC_1> {

	@Override
	public InterfaceB<ClassC_1> getB() {
		return new ClassB_1();
	}

}
