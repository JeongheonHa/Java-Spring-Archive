package ch11.collections_framework.hashset;

import java.util.*;

public class HashSetEx4 {

	public static void main(String[] args) {
		HashSet set = new HashSet();
		
		set.add(new String("abc"));
		set.add(new String("abc"));
		
		set.add(new Person("David",10));
		set.add(new Person("David",10));
		
		System.out.println(set);
	}
}

class Person {
	String name;
	int age;
	
	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Person) {
			Person p = (Person)obj;
			return this.name.equals(p.name) && this.age == p.age;
		}
		return false;
	}
	
	public int hashCode() {
		return Objects.hash(name,age);
	}
	
	public String toString() {
		return name + ";" + age;
	}
}
/*
[David;10, abc]
*/