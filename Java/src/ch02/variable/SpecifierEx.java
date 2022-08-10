package ch02.variable;

public class SpecifierEx {

	public static void main(String[] args) {
		
		byte b = 1;
		short s = 2;
		char c = 'A';
		
		int finger = 10;
		long big = 100_000_000__000L;
		long hex = 0xFFFF_FFFF_FFFF_FFFFL;
		
		int oxcNum = 010;
		int hexNum = 0x10;
		int binNum = 0b10;
		
		float f1 = .10f;
		float f2 = 3.14e3f;
		double d = 1.23456789;
		
		String url = "www.naver.com";
		
		System.out.printf("b = %d %n", b);
		System.out.printf("s = %d %n", s);
		System.out.printf("c = %c, %d %n", c, (int)c);
		System.out.printf("finger = [%5d]%n", finger);
		System.out.printf("finger = [%-5d]%n", finger);
		System.out.printf("finger = [%05d]%n", finger);
		System.out.printf("big = %d%n", big);
		System.out.printf("hex = %#x%n", hex);
		System.out.printf("oxcNum = %o, %d%n", oxcNum, oxcNum);
		System.out.printf("hexNum = %x, %d%n", hexNum, oxcNum);
		System.out.printf("binNum = %s, %d%n", Integer.toBinaryString(binNum), binNum);
		
		
		System.out.printf("f1 = %f, %e, %g%n", f1, f1, f1);
		System.out.printf("f2 = %f, %e, %g%n", f2, f2, f2);
		System.out.printf("d = %f%n", d);
		System.out.printf("d = %14.10f%n", d);
		
		System.out.printf("url = [%20s]%n", url);
		System.out.printf("url = [%-20s]%n", url);
		System.out.printf("url = [%.8s]%n", url);
	}

}
