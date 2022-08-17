package ch10.calendar;

import java.util.*;

public class CalendarEx3 {

	public static void main(String[] args) {
		final int[] TIME_UNIT = {3600, 60, 1};
		final String[] TIME_UNIT_NAME = {"시간 ", "분 ", "초 "};
		
		// 현재시각 지정
		Calendar time1 = Calendar.getInstance();
		Calendar time2 = Calendar.getInstance();
		// time1 시간,분,초 지정(10,20,30)
		time1.set(Calendar.HOUR_OF_DAY, 10);
		time1.set(Calendar.MINUTE, 20);
		time1.set(Calendar.SECOND, 30);
		// time2 시간,분,초 지정(20,30,10)
		time2.set(Calendar.HOUR_OF_DAY, 20);
		time2.set(Calendar.MINUTE, 30);
		time2.set(Calendar.SECOND, 10);
		// get()을 이용해 시간 불러오기
		System.out.println("time1 :" + time1.get(Calendar.HOUR_OF_DAY) + "시 " + time1.get(Calendar.MINUTE) + "분 "
				+ time1.get(Calendar.SECOND) + "초");
		System.out.println("time2 :" + time2.get(Calendar.HOUR_OF_DAY) + "시 " + time2.get(Calendar.MINUTE) + "분 "
				+ time2.get(Calendar.SECOND) + "초");
		// 초 단위로 변환하여 두 시간 차의 절대값 저장
		long difference = Math.abs(time2.getTimeInMillis() - time1.getTimeInMillis()) / 1000;
		System.out.println("time1과 time2의 차이는 " + difference + "초 입니다.");
		// 빈 문자열로 temp 초기화
		String temp = "";
		// 시, 분, 초를 각각 3600,60,1로 나눠서 시, 분, 초 구하기 
		for(int i = 0; i < TIME_UNIT.length; i++) {
			temp += difference/TIME_UNIT[i] + TIME_UNIT_NAME[i];
			difference %= TIME_UNIT[i];
		}
		
		System.out.println("시분초로 변환하면 " + temp + "입니다.");
	}

}
