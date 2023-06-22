package ㄱ자바예제소스;

import java.util.*;
public class Round15_Ex21 {
	public static void main(String[] args) {
		Date date = new Date();
		Date date1 = new Date(1125034805687L);
		System.out.println("date = " + date);
		System.out.println("date1 = " + date1);
		boolean bool = date.after(date1);
		System.out.println("bool = " + bool);
		int year = date.getYear();
		int month = date.getMonth();
		int day = date.getDate();
		int hours = date.getHours();
		int minutes = date.getMinutes();
		int seconds = date.getSeconds();
		System.out.println("year = " + year);
		System.out.println("month = " + month);
		System.out.println("day = " + day);
		System.out.println("hours = " + hours);
		System.out.println("minutes = " + minutes);
		System.out.println("seconds = " + seconds);
		
		long lo = date.getTime();
		System.out.println("mili time = " + lo);
		
		
	}
}
