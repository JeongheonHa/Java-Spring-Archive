package ch02_variable;

import java.util.Scanner;

public class ScannerEx {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a number >>");
		
		String input = scanner.nextLine();
		int num = Integer.parseInt(input);
		
		System.out.println("Your number is " + input);
		System.out.printf("num = %d%n", num);
		
		scanner.close();
	}

}
