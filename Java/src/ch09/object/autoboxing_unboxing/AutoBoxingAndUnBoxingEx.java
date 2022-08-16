package ch09.object.autoboxing_unboxing;

public class AutoBoxingAndUnBoxingEx {

	public static void main(String[] args) {
		int i = 10;
		
		// 기본형을 참조형으로 형변환
		Integer intg = (Integer)i;	// Integer intg = Integer.valueOf(i);
		Object obj = (Object)i;		// Object obj =  (Object)integer.valueOf(i);
		
		Long lng = 100L;
		
		int i2 = intg + 10;
		long l = intg + lng;
		
		Integer intg2 = new Integer(20);
		int i3 = (int)intg2;
		
		Integer intg3 = intg2 + i3;
		
		System.out.println("i = " + i);
		System.out.println("intg = " + intg);
		System.out.println("obj = " + obj);
		System.out.println("lng = " + lng);
		System.out.println("intg + 10 = " + +i2);
		System.out.println("intg + lng = " + 1);
		System.out.println("intg2 = " + intg2);
		System.out.println("i3 = " + i3);
		System.out.println("intg2 + i3 = " + intg3);
	}

}
/*
i = 10
intg = 10
obj = 10
lng = 100
intg + 10 = 20
intg + lng = 1
intg2 = 20
i3 = 20
intg2 + i3 = 40
*/