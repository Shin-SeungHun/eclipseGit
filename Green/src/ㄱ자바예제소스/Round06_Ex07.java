package ㄱ자바예제소스;

import java.io.*;

public class Round06_Ex07 {
	public static void main(String[] ar) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int 국어 = 0, 영어 = 0, 수학 = 0, 총점 = 0;
		char 학점 = 0;
		float 평균 = 0.0f;

		do {
			System.out.print("국어 = ");
			국어 = Integer.parseInt(in.readLine());
		} while (국어 < 0 || 국어 > 100);

		do {
			System.out.print("영어 = ");
			영어 = Integer.parseInt(in.readLine());
		} while (영어 < 0 || 영어 > 100);

		do {
			System.out.print("수학 = ");
			수학 = Integer.parseInt(in.readLine());
		} while (수학 < 0 || 수학 > 100);

		총점 = 국어 + 영어 + 수학;
		평균 = 총점 / 3.0f;

		switch ((int) (평균 / 10)) {
		case 10:
		case 9:
			학점 = 'A';
			break;
		case 8:
			학점 = 'B';
			break;
		case 7:
			학점 = 'C';
			break;
		case 6:
			학점 = 'D';
			break;
		default:
			학점 = 'F';
		}

		System.out.println();
		System.out.println("총점 = " + 총점);
		System.out.printf("평균 = %.2f\n", 평균);
		System.out.println("학점 = " + 학점 + "학점");
	}
}
