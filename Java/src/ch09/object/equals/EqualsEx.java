package ch09.object.equals;

public class EqualsEx {

	public static void main(String[] args) {
		// Person타입의 객체 생성
		Person p1 = new Person(8011081111222L);
		Person p2 = new Person(8011081111222L);
		
		System.out.println(p1==p2);
		System.out.println(p1.equals(p2));
	}
}

class Person {
	long id;
	// 다향성을 이용해 매개변수로 복사
	public boolean equals(Object obj) {
		if(obj != null & obj instanceof Person) {
			// p2의 인스턴스 변수 id에 접근하기위해 형변환
			return id == ((Person)obj).id;
		} else {
			return false;
		}
	}
	
	// 생성자 
	Person(long id) {
		this.id = id;
	}
}
/*
false
true
*/