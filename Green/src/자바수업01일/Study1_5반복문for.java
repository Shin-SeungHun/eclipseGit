package 자바수업01일;

import java.util.Scanner;

public class Study1_5반복문for {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int repeatCnt;
		System.out.print("반복횟수입력: ");
		repeatCnt = sc.nextInt();

		for (int i = 0; i < repeatCnt; i++) {
			System.out.println(i + 1 + "번 동작!");
		}

	}

}
