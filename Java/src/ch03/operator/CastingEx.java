package ch03.operator;

public class CastingEx {

	public static void main(String[] args) {
		byte a = 10;
		byte b = 20;
		byte c = (byte)(a + b);
		
		int d = 1_000_000;
		int e = 2_000_000;
		long f = (long)d * (long)e;
		
		char c1 = 'a';
		char c2 = (char)(c1 + 1);
		//char c2 = 'a' + 1;	// literal or const 연산은 형변환을 하지않아도 된다.
		
		System.out.println(c);
		System.out.println(f);
		System.out.println(c2);
	}

}
