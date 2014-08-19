package demo.typeParameter;

public class ClassB_1 implements InterfaceB<ClassC_1> {

	@Override
	public ClassC_1 getC() {
		return new ClassC_1();
	}

}
