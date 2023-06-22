package 자바수업02일;

import java.util.Scanner;

public class Study1_배열5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int input;
		int MAX = 100; // 인원수 상수변수..
		int kor[] = new int[MAX];
		int eng[] = new int[MAX];
		int mat[] = new int[MAX];
		int tot[] = new int[MAX];
		double avg[] = new double[MAX];
		String student[] = new String[MAX];
		int count = 0;

		while (true) {
			System.out.println("3명의 점수를 입력받아서 처리하시오");
			System.out.println("1.점수입력");
			System.out.println("2.점수출력");
			System.out.println("3.종료");
			System.out.println("선택 :");
			input = sc.nextInt();

			switch (input) {

			case 1:
				System.out.println(count + 1 + "번 학생 이름:");
				student[count] = sc.next();
				System.out.println(count + 1 + "번 학생 국어: ");
				kor[count] = sc.nextInt();
				System.out.println(count + 1 + "번 학생 영어: ");
				eng[count] = sc.nextInt();
				System.out.println(count + 1 + "번 학생 수학: ");
				mat[count] = sc.nextInt();

				tot[count] = kor[count] + eng[count] + mat[count];
				avg[count] = tot[count] / 3.0;
				count++;
				break;
			
			case 2:
				for (int i = 0; i < count; i++) {
					System.out.println(i + 1 + "번 학생" + student[i] + " 총점: " + tot[i] + " 평균: " + avg[i]);
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
