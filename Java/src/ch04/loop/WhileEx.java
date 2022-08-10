package ch04.loop;

import java.util.Scanner;

public class WhileEx {

	public static void main(String[] args) {
		int num;
		int sum = 0;
		boolean flag = true;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("합계를 구할 숫자를 입력하세요.");
		
		while(flag) {
			System.out.print(">>");
			
			String temp = scanner.nextLine();
			num = Integer.parseInt(temp);
			
			if (num != 0) {
				sum += num;
			}
			else {
				flag = false;
			}
		}
		scanner.close();
		
		System.out.println("Total : " + sum);
	}

}
