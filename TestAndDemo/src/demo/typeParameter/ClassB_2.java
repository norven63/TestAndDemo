package demo.typeParameter;

public class ClassB_2 implements InterfaceB<ClassC_2> {

	@Override
	public ClassC_2 getC() {
		return new ClassC_2();
	}

}
