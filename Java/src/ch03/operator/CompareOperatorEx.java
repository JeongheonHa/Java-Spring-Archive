package ch03.operator;

public class CompareOperatorEx {

	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = new String("abc");
		
		System.out.printf("str1 == \"abc\" ? %b%n", str1 == "abc");	// true
		System.out.printf("str2 == \"abc\" ? %b%n", str2 == "abc");	// false
		System.out.printf("str1.equals(\"abc\") ? %b%n", str1.equals("abc"));	// true
		System.out.printf("str2.equals(\"abc\") ? %b%n", str2.equals("abc"));	// true
	}

}
