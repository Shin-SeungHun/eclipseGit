package 자바수업02일;

import java.util.Scanner;

public class Study1_배열3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int input;
		int kor[] = new int[3];
		int eng[] = new int[3];
		int mat[] = new int[3];
		int tot[] = new int[3];
		double avg[] = new double[3];

		while (true) {
			System.out.println("3명의 점수를 입력받아서 처리하시오");
			System.out.println("1.점수입력");
			System.out.println("2.점수출력");
			System.out.println("3.종료");
			System.out.println("선택 :");
			input = sc.nextInt();

			switch (input) {

			case 1:
				for (int i = 0; i < kor.length; i++) {

					do {
						System.out.println(i + 1 + "번 학생 국어: ");
						kor[i] = sc.nextInt();
						if (kor[i] < 0 || kor[i] < 100) {
							System.out.println("점수가 0~100범위를 벗어납니다.");
						}
					} while (kor[i] < 0 || kor[i] < 100);
				}

				for (int i = 0; i < eng.length; i++) {

					do {
						System.out.println(i + 1 + "번 학생 영어: ");
						eng[i] = sc.nextInt();
						if (eng[i] < 0 || eng[i] < 100) {
							System.out.println("점수가 0~100범위를 벗어납니다.");
						}
					} while (eng[i] < 0 || eng[i] < 100);
				}

				for (int i = 0; i < mat.length; i++) {

					do {
						System.out.println(i + 1 + "번 학생 수학: ");
						mat[i] = sc.nextInt();
						if (mat[i] < 0 || mat[i] < 100) {
							System.out.println("점수가 0~100범위를 벗어납니다.");
						}
					} while (mat[i] < 0 || mat[i] < 100);
				}

				for (int i = 0; i < tot.length; i++) {
					tot[i] = kor[i] + eng[i] + mat[i];
				}

				for (int i = 0; i < avg.length; i++) {
					avg[i] = tot[i] / 3.0;
				}

				break;

			case 2:
				for (int i = 0; i < 3; i++) {
					System.out.println(i + 1 + "번 학생 총점: " + tot[i] + " 평균: " + avg[i]);
				}
				break;

			case 3:
				System.out.println("종료");
				break;

			default:
				break;
			}

		}

	}

}
