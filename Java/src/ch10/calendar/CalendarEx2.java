package ch10.calendar;

import java.util.*;

public class CalendarEx2 {

	public static void main(String[] args) {
		// 요일은 1부터 시작하기 때문에, DAY_OF_WEEK[0]은 비워둔다.
		final String[] DAY_OF_WEEK = {"", "일", "월", "화", "수", "목", "금", "토"};
		
		// 기본적으로 현재 날짜와 시간으로 지정
		Calendar date1 = Calendar.getInstance();
		Calendar date2 = Calendar.getInstance();
		
		date1.set(2015, 7, 15);
		System.out.println("date1은 " + toString(date1) + DAY_OF_WEEK[date1.get(Calendar.DAY_OF_WEEK)] + "요일이고,");
		System.out.println("오늘은 " + toString(date2) + DAY_OF_WEEK[date2.get(Calendar.DAY_OF_WEEK)] + "요일입니다.");
		
		// 두 날짜간의 차이를 얻으려면, getTimeInMillis()를 이용해 천분의 일초 단위로 변환해야한다.
		long difference = (date2.getTimeInMillis() - date1.getTimeInMillis()) / 1000;
		System.out.println("그 날(date1)부터 지금 (date2)까지 " + difference + "초가 지났습니다.");
		System.out.println("일(day)로 계산하면 " + difference / (24 * 60 * 60) + "일(day)입니다.");
	}



	public static String toString(Calendar date) {
		return date.get(Calendar.YEAR) + "년 " + (date.get(Calendar.MONTH) + 1) + "월 " + date.get(Calendar.DATE) + "일 ";
    }
}
/*
date1은 2015년 8월 15일 토요일이고,
오늘은 2022년 8월 16일 화요일입니다.
그 날(date1)부터 지금 (date2)까지 221011200초가 지났습니다.
일(day)로 계산하면 2558일(day)입니다.
*/
