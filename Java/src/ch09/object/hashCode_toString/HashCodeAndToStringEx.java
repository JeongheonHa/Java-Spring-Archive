package ch09.object.hashCode_toString;

import java.util.Objects;

class Card {
	String kind;
	int number;
	
	Card() {
		this("SPADE", 1);
	}
	
	Card(String kind, int number) {
		this.kind = kind;
		this.number = number;
	}
	
	// equals()를 오버라이딩하면 hashCode()도 오버라이딩 해야한다.
	public int hashCode() {
		// iv를 인자로 받아 int로 반환하는 메서드
		return Objects.hash(kind, number);	// Objects클래스 : 객체와 관련되 유용한 메서드를 제공하는 유틸 클래스
											// hash( ) : 가변인자라 여러개 넣을 수 있다.
	}
	// equals 오버라이딩
	public boolean equals(Object obj) {
		if(!(obj instanceof Card))
			return false;
		Card c = (Card)obj;
		return this.kind.equals(c.kind) && this.number == c.number;
	}
	// Object클래스의 toString() 오버라이딩
	public String toString() {
		return "kind:" + kind + ", number:" + number;
	}
}
public class HashCodeAndToStringEx {

	public static void main(String[] args) {
		Card c1 = new Card();
		Card c2 = new Card();
		
		System.out.println(c1.toString());
		System.out.println(c2.toString());

	}

}
