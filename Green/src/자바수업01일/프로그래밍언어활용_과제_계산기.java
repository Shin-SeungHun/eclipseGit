package 자바수업01일;

import java.util.Scanner;

public class 프로그래밍언어활용_과제_계산기 {

	// 주제에 맞게 프로그램을 코딩하는 구간
	public static void main(String[] args) {
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
	// 리턴 o 전달 o
	static int add(int num1, int num2) {
		// 더하기
		return num1 + num2;
	}

	static int min(int num1, int num2) {
		// 빼기
		return num1 - num2;
	}

	static int mul(int num1, int num2) {
		// 곱하기
		return num1 * num2;
	}

	static int div(int num1, int num2) {
		// 나누기
		return num1 / num2;
	}
}
