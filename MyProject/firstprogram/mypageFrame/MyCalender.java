package mypageFrame;

import java.util.Calendar;

public class MyCalender {
	Calendar cal = Calendar.getInstance();
	
	private String[] calHeader = {"S", "M", "T", "W", "T", "F", "S"};
	private String[][] calDate = new String[6][7];
	
	private int width = calHeader.length; // 배열 가로 넓이
	private int startDay; // 월 시작 요일
	private int lastDay; // 월 마지막 요일
	private int inputDate = 1; // 입력날짜
	private int year, month;
	
	public MyCalender(int year, int month) {
		this.year = year;
		this.month = month;
	}
	
	public String[][] printMyCalender() {
		
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DATE, 1);
		
		startDay = cal.get(Calendar.DAY_OF_WEEK); // 월 시작 요일
//		System.out.println("월 시작 요일 : " + startDay);
		
		lastDay = cal.getActualMaximum(Calendar.DATE); // 월 마지막 날짜
		
		int row = 0;
		for(int i = 1; inputDate <= lastDay; i++) {
			if(i < startDay) {
				calDate[row][i - 1] = ""; // 시작 요일이 오기 전에는 공백 대입
			} else {
				calDate[row][(i - 1) % width] = Integer.toString(inputDate); 
				inputDate++;
				
				if(i % width == 0) {
					row++; // 가로 마지막 열에 오면 행 바꿈. 
				}
			}
		}
		return calDate;
	}
	
	public String[] getWeekName() {
		return calHeader;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public void setYear(int year) {
		this.year = year;
	}
}
