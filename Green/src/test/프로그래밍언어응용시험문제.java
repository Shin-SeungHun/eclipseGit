package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Scanner;

public class 프로그래밍언어응용시험문제 {

	public static void main(String[] args) {

		new Memo0();

	}

}

class Memo0 {
	Scanner sc = new Scanner(System.in);
	String memo;
	String resultDate;

	Memo0()  {
		while (true) {
			System.out.println("1.메모");
			System.out.println("2.메모보기");
			System.out.println("3.종료");
			System.out.println("선택:");
			int input = sc.nextInt();

			if (input == 1) {
				System.out.println("\n메모: ");
				memo = sc.nextLine();
				memo = sc.nextLine();

				Calendar ca = Calendar.getInstance();
				// Date date = new Date();
//				int x = ca.get(Calendar.DAY_OF_YEAR);

				
				 resultDate = ca.get(Calendar.YEAR) + "-" + ca.get(Calendar.MONTH + 1) + "-"
						+ ca.get(Calendar.DAY_OF_MONTH)+ memo;

//				 Date date = new Date();

//				 String resultDate = date.getYear()+"-"+date.getMonth()+"-"+date.getDay();
				 try {
						PrintWriter out = new PrintWriter(
								new BufferedWriter(new FileWriter(new File(new File("c:\\java"), "cms.txt"))));
						out.println(resultDate);
						out.close();
					} catch (IOException e) {
					}
				 
//				 String result = date+memo;
			} else if (input == 2) {
				System.out.println("\n" + resultDate + "\n");
			} else if (input == 3) {
				System.out.println("종료");
				break;
			}
		}
	}

}