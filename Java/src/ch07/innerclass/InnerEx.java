package ch07.innerclass;

class InnerEx {
	class InstanceInner {
		int iv = 100;
		static int cv = 100;
		final static int CONST = 100;
	}
	
	static class StaticInner {
		int iv = 200;
		static int cv = 200;
	}
	
//	void myMethod() {
//		class LocalInner {
//			int iv = 300;
//			static int cv = 300;
//			final static int CONST = 300;
//		}
//	}
}

class InnerTest {
	public static void main(String[] args) {
		System.out.println(InnerEx.InstanceInner.CONST);
		System.out.println(InnerEx.StaticInner.cv);
	
	}
}
