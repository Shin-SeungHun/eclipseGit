package 자바수업01일;

import java.util.Scanner;

public class Study1_5반복문doWhile점수입력과제2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int kor, eng, mat, tot;
		double avg;

		do {
			System.out.println("국어: ");
			kor = sc.nextInt();
			if (kor < 0 || 100 < kor) {
				System.out.println("점수가 0~100범위를 벗어납니다.");
			}
		} while (kor < 0 || 100 < kor);

		do {
			System.out.println("영어: ");
			eng = sc.nextInt();
			if (eng < 0 || 100 < eng) {
				System.out.println("점수가 0~100범위를 벗어납니다.");
			}
		} while (eng < 0 || 100 < eng);

		do {
			System.out.println("수학: ");
			mat = sc.nextInt();
			if (mat < 0 || 100 < mat) {
				System.out.println("점수가 0~100범위를 벗어납니다.");
			}
		} while (mat < 0 || 100 < mat);

		tot = kor + eng + mat;
		avg = tot / 3.0;
		System.out.println("총점: " + tot + " / 평균: " + avg);

	}

}
