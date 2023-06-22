package ㄱ자바예제소스;

import java.util.*;
public class Round15_Ex22 {
	public static void main(String[] args) {
		Calendar ca = Calendar.getInstance();
		//Date date = new Date();
		int x = ca.get(Calendar.DAY_OF_YEAR);
		System.out.println("오늘은 일년중 " + x + "번째 날입니다.");
		//Calendar ca1 = new Calendar();
		int year = ca.get(Calendar.YEAR);
		int month = ca.get(Calendar.MONTH);
		int day = ca.get(Calendar.DAY_OF_MONTH);
		int hour = ca.get(Calendar.HOUR_OF_DAY);
		int minute = ca.get(Calendar.MINUTE);
		int second = ca.get(Calendar.SECOND);
		System.out.println("year = " + year);
		System.out.println("month = " + month);
		System.out.println("hour = " + hour);
		System.out.println("ca = " + ca.getTime());
		//String[] month = new String[]{"Jan", "Feb"...."Aug"..."Dec"};
		/*Locale[] loc = Locale.getAvailableLocales();
		for(int i = 0; i < loc.length; i++){
			System.out.println(i + " : " + loc[i]);
		}*/
		
		TimeZone.setDefault(TimeZone.getTimeZone(
			TimeZone.getTimeZone("America/Los_angeles").getID()));
		Locale lo = Locale.US;
		Calendar ca1 = Calendar.getInstance(lo);
		System.out.println("ca1 = " + ca1.getTime());
	}
}
