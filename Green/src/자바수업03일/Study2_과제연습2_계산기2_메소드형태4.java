package 자바수업03일;

import java.util.Scanner;

public class Study2_과제연습2_계산기2_메소드형태4 {
	// 리턴 x 전달 x 구조변경
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
			add();
		} else if (cal.equals("-")) {
			min();
		} else if (cal.equals("*")) {
			mul();
		} else if (cal.equals("/")) {
			div();
		}
	}

	static void add() {
		System.out.println("\n결과: " + (num1 + num2));
		System.out.println();
	}

	static void min() {
		System.out.println("\n결과: " + (num1 - num2));
		System.out.println();
	}

	static void mul() {
		System.out.println("\n결과: " + (num1 * num2));
		System.out.println();
	}

	static void div() {
		System.out.println("\n결과: " + (num1 / num2));
		System.out.println();
	}

}
