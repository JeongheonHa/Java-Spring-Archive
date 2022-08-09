package ch06_class;


public class ClassMethodInstanceMethod {
	int iv = 10;
	static int cv = 20;
	
	int iv2 = cv;
	// static int cv2 = iv;	// error
	static int cv2 = new ClassMethodInstanceMethod().iv;
	
	static void staticMethod1() {
		System.out.println(cv);
		// System.out.println(iv);	// error
		ClassMethodInstanceMethod c = new ClassMethodInstanceMethod();
		System.out.println(c.iv);
	}
	
	void instanceMethod1() {
		System.out.println(cv);
		System.out.println(iv);
	}
	
	static void staticMethod2() {
		staticMethod1();
		// instanceMethod1();	// error
		ClassMethodInstanceMethod c = new ClassMethodInstanceMethod();
		c.instanceMethod1();
	}
	
	void instanceMethod2() {
		staticMethod1();
		instanceMethod1();
	}
}