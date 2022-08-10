package ch06.constructor;

public class CarTest {

	public static void main(String[] args) {
		Car c1 = new Car();
		Car c2 = new Car(c1);
		System.out.println("c1의 color = " + c1.color + "gearType = " + c1.gearType + "door = " + c1.door);
		System.out.println("c2의 color = " + c2.color + "gearType = " + c2.gearType + "door = " + c2.door);
		
		c1.door = 100;
		System.out.println("c1.door = 100; 실행 후");
		System.out.println("c1의 color = " + c1.color + "gearType = " + c1.gearType + "door = " + c1.door);
		System.out.println("c2의 color = " + c2.color + "gearType = " + c2.gearType + "door = " + c2.door);
	}

}

class Car {
	String color;
	String gearType;
	int door;
	
	// Car class의 기본생성자에서 다른 생성자 호출
	Car() {
		this("white", "auto", 4);
	}
	// 인스턴스 복사를 위한 생성자
	Car(Car c) {
		this(c.color, c.gearType, c.door);
	}
	
	Car(String color, String gearType, int door) {
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
}

/*
c1의 color = whitegearType = autodoor = 4
c2의 color = whitegearType = autodoor = 4
c1.door = 100; 실행 후
c1의 color = whitegearType = autodoor = 100
c2의 color = whitegearType = autodoor = 4
*/