package 자바수업03일;

import java.util.Scanner;

public class Study2_과제연습2_계산기2_메소드형태6 {
	// 리턴 o 전달 x 구조변경
	static int num1, num2;
	static String cal;

	public static void main(String[] args) {

		input();
		output();
	}

	static void input() {
		Scanner sc = new Scanner(System.in);

		System.out.println("<계산기>");
		System.out.print("수1: ");
		num1 = sc.nextInt();
		System.out.print("연산자(+,-,*,/): ");
		cal = sc.next();
		System.out.print("수2: ");
		num2 = sc.nextInt();
	}

	static void output() {
		if (cal.equals("+")) {

			System.out.println("\n결과: " + add());
			System.out.println();
		} else if (cal.equals("-")) {

			System.out.println("\n결과: " + min());
			System.out.println();

		} else if (cal.equals("*")) {

			System.out.println("\n결과: " + mul());
			System.out.println();

		} else if (cal.equals("/")) {

			System.out.println("\n결과: " + div());
			System.out.println();

		}
	}

	static int add() {
		return num1 + num2;
	}

	static int min() {
		return num1 - num2;
	}

	static int mul() {
		return num1 * num2;
	}

	static int div() {
		return num1 / num2;
	}
}
