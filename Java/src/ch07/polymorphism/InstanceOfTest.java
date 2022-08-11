package ch07.polymorphism;

public class InstanceOfTest {

	public static void main(String[] args) {
		FireEngine1 fe = new FireEngine1();
		
		if (fe instanceof FireEngine1) {
			System.out.println("This is a FireEngine instance.");
		}
		
		if (fe instanceof Car1) {
			System.out.println("This is a Car instance.");
		}
		
		if (fe instanceof Object) {
			System.out.println("This is a Object instance.");
		}
		
		System.out.println("fe.getClass().getName()");
	}
}

class Car1 {}
class FireEngine1 extends Car1 {}

/*
This is a FireEngine instance.
This is a Car instance.
This is a Object instance.
fe.getClass().getName()
*/