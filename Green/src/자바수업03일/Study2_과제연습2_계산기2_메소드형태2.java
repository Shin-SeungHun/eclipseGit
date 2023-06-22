package 자바수업03일;

import java.util.Scanner;

public class Study2_과제연습2_계산기2_메소드형태2 {

	public static void main(String[] args) {
		// 리턴 x 전달 o
		Scanner sc = new Scanner(System.in);
		int num1, num2;
		String cal;

		while (true) {
			System.out.println("<계산기>");
			System.out.print("수1: ");
			num1 = sc.nextInt();
			System.out.print("연산자(+,-,*,/): ");
			cal = sc.next();
			System.out.print("수2: ");
			num2 = sc.nextInt();

			if (cal.equals("+")) {
				add(num1, num2);
			} else if (cal.equals("-")) {
				min(num1, num2);

			} else if (cal.equals("*")) {
				mul(num1, num2);

			} else if (cal.equals("/")) {
				div(num1, num2);

			}
		}
	}

	static void add(int num1, int num2) {
		System.out.println("\n결과: " + (num1 + num2));
		System.out.println();
	}

	static void min(int num1, int num2) {
		System.out.println("\n결과: " + (num1 - num2));
		System.out.println();
	}

	static void mul(int num1, int num2) {
		System.out.println("\n결과: " + (num1 * num2));
		System.out.println();
	}

	static void div(int num1, int num2) {
		System.out.println("\n결과: " + (num1 + num2));
		System.out.println();
	}

}
