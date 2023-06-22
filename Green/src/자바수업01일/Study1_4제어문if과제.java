package 자바수업01일;

import java.util.Scanner;

public class Study1_4제어문if과제 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int grade; // 학년변수

		while (true) {
			System.out.print("중딩학년을 입력하시오: ");
			grade = sc.nextInt();

			if (grade == 1) {
				System.out.println("1학년입니다.");
			} else if (grade == 2) {
				System.out.println("2학년입니다.");
			} else if (grade == 3) {
				System.out.println("3학년입니다.");
			} else {
				System.out.println("1~3학년만 입력하세요.");
			}

		}
	}

}
