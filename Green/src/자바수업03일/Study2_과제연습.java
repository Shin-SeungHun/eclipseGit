package 자바수업03일;

import java.util.Scanner;

public class Study2_과제연습 {

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
				System.out.println("\n결과: " + (num1 + num2));
				System.out.println();
			} else if (cal.equals("-")) {
				System.out.println("\n결과: " + (num1 - num2));
				System.out.println();

			} else if (cal.equals("*")) {
				System.out.println("\n결과: " + (num1 * num2));
				System.out.println();

			} else if (cal.equals("/")) {
				System.out.println("\n결과: " + (num1 / num2));
				System.out.println();

			}

		}

	}

}
