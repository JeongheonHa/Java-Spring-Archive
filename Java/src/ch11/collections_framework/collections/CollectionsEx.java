package ch11.collections_framework.collections;

import java.util.*;
// Collections의 메서드를 사용할 때 Collections클래스 생략 가능
import static java.util.Collections.*;

public class CollectionsEx {

	public static void main(String[] args) {
		// list 생성
		List list = new ArrayList();
		System.out.println(list);
		// list에 값 저장
		addAll(list, 1,2,3,4,5);	// 가변인자이다.
		System.out.println(list);
		// 오른쪽으로 2칸 씩 이동
		rotate(list, 2);
		System.out.println(list);
		// 첫 번째와 세 번째 교환
		swap(list, 0, 2);
		System.out.println(list);
		// 무작위로 섞기
		shuffle(list);
		System.out.println(list);
		// 역순 정렬
		sort(list, reverseOrder());	// reverse(list)와 같은 결과
		System.out.println(list);
		// 정렬
		sort(list);
		System.out.println(list);
		// 이진탐색으로 3의 index값을 반환
		int idx = binarySearch(list, 3);	// binarySearch를 하기전에는 반드시 정렬을 한다.
		System.out.println("index of 3 = " + idx);
		// list에서 최대, 최소 반환
		System.out.println("max = " + max(list));
		System.out.println("min = " + min(list));
		System.out.println("min = " + max(list, reverseOrder()));
		// list를 9로 채운다.
		fill(list, 9);
		System.out.println("list = " + list);
		// list와 같은 크기의 새로운 list를 생성하고 2로 채운다. 결과는 변경불가
		List newList = nCopies(list.size(), 2);
		System.out.println("newList = " + newList);
		// list안에 newList와 공통된 요소가 있는지 확인, 공통 요소가 없으면 true
		System.out.println(disjoint(list, newList));
		// newList를 list에 복사
		copy(list, newList);
		System.out.println("newList = " + newList);
		System.out.println("list = " + list);
		// list의 내용을 2에서 1로 바꾼다.
		replaceAll(list, 2, 1);
		System.out.println("liist = " + list);
		// list에서 enumeration을 얻을 때 사용
		Enumeration e = enumeration(list);
		ArrayList list2 = list(e);
		
		System.out.println("list2 = " + list2);
	}

}
/*
[1, 2, 3, 4, 5]
[4, 5, 1, 2, 3]
[1, 5, 4, 2, 3]
[4, 5, 3, 1, 2]
[5, 4, 3, 2, 1]
[1, 2, 3, 4, 5]
index of 3 = 2
max = 5
min = 1
min = 1
list = [9, 9, 9, 9, 9]
newList = [2, 2, 2, 2, 2]
true
newList = [2, 2, 2, 2, 2]
list = [2, 2, 2, 2, 2]
liist = [1, 1, 1, 1, 1]
list2 = [1, 1, 1, 1, 1]
*/