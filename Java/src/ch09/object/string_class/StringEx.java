package ch09.object.string_class;

public class StringEx {

	public static void main(String[] args) {
		int iVal = 100;
		// valueOf를 이용해 int를 String으로 변환
		String strVal = String.valueOf(iVal);
		
		double dVal = 200;
		// ""(빈 문자열)을 더해 int를 String으로 변환
		String strVal2 = dVal + "";
		
		double sum = Integer.parseInt("+" + strVal) + Double.parseDouble(strVal2);
		double sum2 = Integer.valueOf(strVal) + Double.valueOf(strVal2);
		
		// join을 이용해 구분자 지정
		System.out.println(String.join("", strVal, "+", strVal2, "=") + sum);
		// 구분자를 문자열로 지정해 더해서 문자열을 만드는 방법
		System.out.println(strVal + "+" + strVal2 + "=" + sum2);

	}

}
/*
100+200.0=300.0
100+200.0=300.0
*/
