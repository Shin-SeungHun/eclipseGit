package 자바수업03일;

import java.util.Scanner;

public class Study2_과제연습2_계산기2_메소드형태1 {

	static int num1, num2;
	static String cal;

	public static void main(String[] args) {
		// 리턴 o 전달 o
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("<계산기>");
			System.out.print("수1: ");
			num1 = sc.nextInt();
			System.out.print("연산자(+,-,*,/): ");
			cal = sc.next();
			System.out.print("수2: ");
			num2 = sc.nextInt();

			if (cal.equals("+")) {
				System.out.println("\n결과: " + add(num1, num2));
				System.out.println();
			} else if (cal.equals("-")) {
				System.out.println("\n결과: " + min(num1, num2));
				System.out.println();
			} else if (cal.equals("*")) {
				System.out.println("\n결과: " + mul(num1, num2));
				System.out.println();
			} else if (cal.equals("/")) {
				System.out.println("\n결과: " + div(num1, num2));
				System.out.println();
			}

		}

	}

	static int add(int num1, int num2) {

		return num1 + num2;
	}

	static int min(int num1, int num2) {

		return num1 - num2;
	}

	static int mul(int num1, int num2) {

		return num1 * num2;
	}

	static int div(int num1, int num2) {

		return num1 / num2;
	}

}
