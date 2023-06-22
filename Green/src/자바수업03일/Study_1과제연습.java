package 자바수업03일;

import java.util.Scanner;

public class Study_1과제연습 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int menu;

		while (true) {
			System.out.println("1.별표찍기");
			System.out.println("2.구구단");
			System.out.println("3.종료");
			System.out.print("선택: ");
			menu = sc.nextInt();

			if (menu == 1) {

//				for (int i = 1; i < 4; i++) {
//					for (int j = 0; j < i; j++) {
//					}
//					System.out.print("*");
//				}
//				System.out.println();
				star();

			} else if (menu == 2) {
				gugudan();

			} else if (menu == 3) {
				System.out.println("종료");
				break;
			}
		}

	}

	static void star() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	static void gugudan() {
		for (int i = 2; i < 10; i++) {
			System.out.println(i + "단");
			for (int j = 1; j < 10; j++) {
				System.out.println(i + "*" + j + "=" + i * j);
			}
		}
	}

}
