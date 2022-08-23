package ch11.collections_framework.hashset;

import java.util.*;

public class HashSetEx1 {

	public static void main(String[] args) {
		Object[] objArr = {"1", new Integer(1), "2", "2", "3", "3", "4", "4", "4"};
		Set set = new HashSet();
		
		for(int i = 0; i < objArr.length; i++) {
			System.out.println(set.add(objArr[i]));
		}
		
		System.out.println(set);
		
		Iterator it = set.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
	}

}
/*
true
true
true
false
true
false
true
false
false
[1, 1, 2, 3, 4]
1
1
2
3
4
*/
