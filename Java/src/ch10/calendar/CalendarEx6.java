package ch10.calendar;

import java.util.*;

public class CalendarEx6 {

	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.println("Usage : java CalendarEx6 2022 8");
			return;
		}
		// 인자로 받은 값 int형으로 저장
		int year = Integer.parseInt(args[0]);
		int month = Integer.parseInt(args[1]);
		int START_DAY_OF_WEEK = 0;
		int END_DAY = 0;
		// Calendar인스턴스 생성(현재 시각)
		Calendar sDay = Calendar.getInstance();
		Calendar eDay = Calendar.getInstance();
		// 인자로 받은 year, month와 day 설정
		sDay.set(year, month - 1, 1);
		eDay.set(year, month, 1);
		// 끝 날짜를 31로 만듬
		eDay.add(Calendar.DATE, -1);
		// 첫 번째 요일이 무슨 요일인지 알아내기
		START_DAY_OF_WEEK = sDay.get(Calendar.DAY_OF_WEEK);
		// eDay에 지정된 날짜를 얻어온다.
		END_DAY = eDay.get(Calendar.DATE);
		
		System.out.println("      " + args[0] + "년 " + args[1] + "월");
		System.out.println(" SU MO TU WE TH FR SA");
		// 해당 월의 1일이 무슨 요일인지에 따라 공백을 출력
		for(int i = 1; i < START_DAY_OF_WEEK; i++) {
			System.out.print("   ");
		}
		// 공백 이후 날짜를 추가
		for(int i = 1, n = START_DAY_OF_WEEK; i <= END_DAY; i++, n++) {
			// 날짜가 10미만일 경우 빈칸 두개 + 날짜, 10이상일 경우 빈칸 하나 + 날짜
			System.out.print((i < 10) ? "  " + i : " " + i );
			// n이 토요일일 경우 한칸 줄바꿈
			if(n%7 == 0) System.out.println();
		}
	}

}
/*
      2022년 8월
 SU MO TU WE TH FR SA
     1  2  3  4  5  6
  7  8  9 10 11 12 13
 14 15 16 17 18 19 20
 21 22 23 24 25 26 27
 28 29 30 31
 */
