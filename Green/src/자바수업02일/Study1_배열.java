package 자바수업02일;

import java.util.Scanner;

public class Study1_배열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int input, kor = 0, eng = 0, mat = 0, tot = 0;
		double avg = 0;

		while (true) {

			System.out.println("1.점수입력");
			System.out.println("2.점수출력");
			System.out.println("3.종료");
			System.out.print("선택: ");
			input = sc.nextInt();
//			if (input == 1) {
//				do {
//					System.out.println("국어: ");
//					kor = sc.nextInt();
//					if (kor < 0 || 100 < kor) {
//						System.out.println("점수가 0~100범위를 벗어납니다.");
//					}
//				} while (kor < 0 || 100 < kor);
//				do {
//					System.out.println("영어: ");
//					eng = sc.nextInt();
//					if (eng < 0 || 100 < eng) {
//						System.out.println("점수가 0~100범위를 벗어납니다.");
//					}
//				} while (eng < 0 || 100 < eng);
//				do {
//					System.out.println("수학: ");
//					mat = sc.nextInt();
//					if (mat < 0 || 100 < mat) {
//						System.out.println("점수가 0~100범위를 벗어납니다.");
//					}
//				} while (mat < 0 || 100 < mat);
//				tot = kor + eng + mat;
//				avg = tot / 3.0;
//			} else if (input == 2) {
//				System.out.println("총점: " + tot + "/평균: " + avg);
//			} else if (input == 3) {
//				System.out.println("종료");
//				break;
//			}

			switch (input) {

			case 1:
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
				break;
			case 2:
				System.out.println("총점: " + tot + "/평균: " + avg);
				break;
			case 3:
				System.out.println("종료");
				break;
			default:
				System.out.println("1~3만 입력가능합니다");
				break;
			}

		}

	}

}
