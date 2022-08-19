package ch11.collections_framework.arraylist;

import java.util.*;

public class ArrayListEx1 {

	public static void main(String[] args) {
		// 기본 길이(용량)이 10인 ArrayList생성
		ArrayList list1 = new ArrayList(10);
		//ArrayList에는 객체만 저장가능
		// autoboxing에 의해 기본형이 참조형으로 자동 변환
		list1.add(5);
		list1.add(new Integer(4));
		list1.add(new Integer(2));
		list1.add(new Integer(0));
		list1.add(new Integer(1));
		list1.add(new Integer(3));
		// subList는 읽기 전용이기때문에 변경하기위해서 ArrayList객체배열 생성
		ArrayList list2 = new ArrayList(list1.subList(1, 4));
		print(list1,list2);
		
		Collections.sort(list1);	// Collections는 유틸클래스이다.
		Collections.sort(list2);
		print(list1, list2);
		// 모든 요소를 포함하는지 확인
		System.out.println("list1.containAll(list2) : " + list1.containsAll(list2));
		
		list2.add("B");
		list2.add("C");
		// 위치 3에 "A"추가
		list2.add(3,"A");
		print(list1, list2);
		// 위치 3에 "AA"로 변경
		list2.set(3,  "AA");
		print(list1, list2);
		
		System.out.println("list1,retainAll(list2) : " + list1.retainAll(list2));
		print(list1, list2);
		
		for(int i = list2.size() -1; i >= 0; i--) {
			if(list1.contains(list2.get(i)))
				list2.remove(i);
		}
		
		print(list1, list2);
	} // main
	
	static void print(ArrayList list1, ArrayList list2) {
		System.out.println("list1:" + list1);
		System.out.println("list2:" + list2);
		System.out.println();
	}

} // class

/*
list1:[5, 4, 2, 0, 1, 3]
list2:[4, 2, 0]

list1:[0, 1, 2, 3, 4, 5]
list2:[0, 2, 4]

list1.containAll(list2) : true
list1:[0, 1, 2, 3, 4, 5]
list2:[0, 2, 4, A, B, C]

list1:[0, 1, 2, 3, 4, 5]
list2:[0, 2, 4, AA, B, C]

list1,retainAll(list2) : true
list1:[0, 2, 4]
list2:[0, 2, 4, AA, B, C]

list1:[0, 2, 4]
list2:[AA, B, C]
*/
