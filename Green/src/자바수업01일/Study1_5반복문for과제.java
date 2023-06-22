package 자바수업01일;

import java.util.Scanner;

public class Study1_5반복문for과제 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;

		while (true) {
			System.out.println("출력단 입력:");
			num = sc.nextInt();
			System.out.println(num + "단");

			for (int i = 1; i < 10; i++) {
				System.out.println(num + "*" + i + "=" + num * i);
			}
		}

	}

}
