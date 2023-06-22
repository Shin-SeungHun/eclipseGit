package 자바수업02일;

import java.util.Scanner;

public class Study1_배열6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input, c;
		int C = 3; // 반 상수변수
		int STD = 100; // 인원수 상수변수..
		int kor[][] = new int[C][STD];
		int eng[][] = new int[C][STD];
		int mat[][] = new int[C][STD];
		int tot[][] = new int[C][STD];
		double avg[][] = new double[C][STD];
		String student[][] = new String[C][STD];
		int countA = 0; //A반 학생 카운트
		int countB = 0; //B반 학생 카운트
		int countC = 0; //C반 학생 카운트
		while (true) {

			System.out.println("점수를 입력받아서 처리하시오");
			System.out.println("1.점수입력");
			System.out.println("2.점수출력");
			System.out.println("3.종료");
			System.out.println("선택 :");
			input = sc.nextInt();

			switch (input) {

			case 1:
				System.out.println("1.A반/2.B반/3.C반 선택: ");
				c = sc.nextInt();

				if (c == 1) {
					System.out.println("<A반>");
					System.out.println(countA + 1 + "번 학생 이름:");
					student[0][countA] = sc.next();
					
					do {
						System.out.println(countA + 1 + "번 학생 국어: ");
						kor[0][countA] = sc.nextInt();
						
						if (kor[0][countA] < 0 || kor[0][countA] < 100) {
							System.out.println("1~100이내로 입력");
						}
					} while (kor[0][countA] < 0 || kor[0][countA] < 100);

					do {
						System.out.println(countA + 1 + "번 학생 영어: ");
						eng[0][countA] = sc.nextInt();
						
						if (eng[0][countA] < 0 || eng[0][countA] < 100) {
							System.out.println("1~100이내로 입력");
						}
					} while (eng[0][countA] < 0 || eng[0][countA] < 100);

					do {
						System.out.println(countA + 1 + "번 학생 수학: ");
						mat[0][countA] = sc.nextInt();
						
						if (mat[0][countA] < 0 || mat[0][countA] < 100) {
							System.out.println("1~100이내로 입력");
						}
					} while (mat[0][countA] < 0 || mat[0][countA] < 100);

					tot[0][countA] = kor[0][countA] + eng[0][countA] + mat[0][countA];
					avg[0][countA] = tot[0][countA] / 3.0;
					countA++;

				} else if (c == 2) {
					System.out.println("<B반>");
					System.out.println(countB + 1 + "번 학생 이름:");
					student[1][countB] = sc.next();
					System.out.println(countB + 1 + "번 학생 국어: ");
					kor[1][countB] = sc.nextInt();
					System.out.println(countB + 1 + "번 학생 영어: ");
					eng[1][countB] = sc.nextInt();
					System.out.println(countB + 1 + "번 학생 수학: ");
					mat[1][countB] = sc.nextInt();

					tot[1][countB] = kor[1][countB] + eng[1][countB] + mat[1][countB];
					avg[1][countB] = tot[1][countB] / 3.0;
					countB++;

				} else if (c == 3) {
					System.out.println("<C반>");
					System.out.println(countC + 1 + "번 학생 이름:");
					student[2][countC] = sc.next();
					System.out.println(countC + 1 + "번 학생 국어: ");
					kor[2][countC] = sc.nextInt();
					System.out.println(countC + 1 + "번 학생 영어: ");
					eng[2][countC] = sc.nextInt();
					System.out.println(countC + 1 + "번 학생 수학: ");
					mat[2][countC] = sc.nextInt();

					tot[2][countC] = kor[2][countC] + eng[2][countC] + mat[2][countC];
					avg[2][countC] = tot[2][countC] / 3.0;
					countC++;
				}

				break;

			case 2:
				if (countA != 0) {
					System.out.println("-------------");
					System.out.println("<<<<  A반 >>>>");
					System.out.println("-------------");

					for (int i = 0; i < countA; i++) {
						System.out.println(
								"A반" + i + 1 + "번 학생" + student[0][i] + " 총점: " + tot[0][i] + " 평균: " + avg[0][i]);
					}
				}

				if (countB != 0) {
					System.out.println("-------------");
					System.out.println("<<<<  B반 >>>>");
					System.out.println("-------------");
					for (int i = 0; i < countB; i++) {
						System.out.println(
								"B반 " + i + 1 + "번 학생" + student[1][i] + " 총점: " + tot[1][i] + " 평균: " + avg[1][i]);
					}
				}

				if (countC != 0) {
					System.out.println("-------------");
					System.out.println("<<<<  C반 >>>>");
					System.out.println("-------------");
					for (int i = 0; i < countC; i++) {
						System.out.println(
								"C반 " + i + 1 + "번 학생" + student[2][i] + " 총점: " + tot[2][i] + " 평균: " + avg[2][i]);
					}
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
