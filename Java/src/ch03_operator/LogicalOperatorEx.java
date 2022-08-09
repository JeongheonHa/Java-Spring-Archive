package ch03_operator;

import java.util.*;

public class LogicalOperatorEx {

	public static void main(String[] args) {
		
	Scanner scanner = new Scanner(System.in);
	char ch = ' ';
	
	System.out.printf("enter >>");
	
	String input = scanner.nextLine();
	ch = input.charAt(0);
	
	if('0' <= ch && ch <= '9') {
		System.out.println("number");
	}
	
	if(('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z'))	{
		System.out.println("English");
	}
	
	scanner.close();
	}

}
