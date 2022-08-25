package ch12.generics;

import java.util.ArrayList;
// Eatable인터페이스 구현한 Fruit클래스
class Fruit implements Eatable {
	// Fruit클래스의 toStirng()메서드 호출시 "Fruit" 문자열 반환
	public String toString() { return "Fruit"; }
}
// Fruit클래스를 상속받는 자식 클래스 Apple, Grape 정의
class Apple extends Fruit { public String toString() { return "Apple"; } }
class Grape extends Fruit { public String toString() { return "Grape"; } }
// 아무것도 상속받지 않는 Toy클래스 정의
class Toy				  { public String toString() { return "Toy"; } }
// Eatable 인터페이스 정의
interface Eatable {}

public class FruitBoxEx2 {

	public static void main(String[] args) {
		// Fruit, Apple, Grape 타입변수의 FruitBox 제네릭 클래스의 인스턴스 생성
		FruitBox<Fruit> fruitBox = new FruitBox<>();	// 생성자의 타입 변수 생략가능
		FruitBox<Apple> appleBox = new FruitBox<Apple>();
		FruitBox<Grape> grapeBox = new FruitBox<Grape>();
		// FruitBox<Toy> toyBox = new FruitBox<Toy>();	// error
		
		// FruitBox인스턴스의 add메서드 호출
		fruitBox.add(new Fruit());
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		appleBox.add(new Apple());
		grapeBox.add(new Grape());
		fruitBox.add(new Fruit());
		
		System.out.println("fruitBox-" + fruitBox);
		System.out.println("appleBox-" + appleBox);
		System.out.println("grapeBox-" + grapeBox);
	} // main

}
// Fruit클래스를 상속받고 Eatable인터페이스를 구현한 타입 변수만 가능 
class FruitBox<T extends Fruit & Eatable> extends Box<T> {}

class Box<T> {
	ArrayList<T> list = new ArrayList<T>();
	void add(T item) { list.add(item); }	// list.add() : ArrayList클래스의 boolean add(Object o)호출
	T get(int i) { return list.get(i); }
	int size() { return list.size(); }
	public String toString() { return list.toString(); }
}
/*
fruitBox-[Fruit, Apple, Grape, Fruit]
appleBox-[Apple]
grapeBox-[Grape]
*/
