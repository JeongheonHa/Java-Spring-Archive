package ch06.memorystructure;

public class CallStackTest {

	public static void main(String[] args) {
		System.out.println("main(String[] args) start");
		firstMethod();
		System.out.println("main(String[] args) is over");
	}
	
	static void firstMethod() {
		System.out.println("firstMethod() start");
		secondMethod();
		System.out.println("firstmethod() is over");
	}
	
	static void secondMethod() {
		System.out.println("secondMethod() start");
		System.out.println("secondMethod() is over");
	}

}

/*
main(String[] args) start
firstMethod() start
secondMethod() start
secondMethod() is over
firstmethod() is over
main(String[] args) is over
*/
