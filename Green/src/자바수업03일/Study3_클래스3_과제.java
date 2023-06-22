package 자바수업03일;

import java.util.Scanner;

public class Study3_클래스3_과제 {

	public static void main(String[] args) {

		Score score = new Score();

		score.inputScore();
		score.outputScore();

	}
}

class Score {
	Scanner sc = new Scanner(System.in);
	int kor, eng, mat, tot; //국영수총점평균변수
	double avg;
	int input; //메뉴 입력용
	
	public Score() {

		while (true) {
			System.out.println("1.점수입력 ");
			System.out.println("2.점수출력 ");
			System.out.println("3.종료 ");
			System.out.print("선택: ");
			input = sc.nextInt();

			if (input == 1) {
				this.inputScore();

			} else if (input == 2) {
				this.outputScore();

			} else if (input == 3) {
				System.out.println("종료");
				break;
			}
		}
	}

	void inputScore() {
		System.out.print("국어: ");
		kor = sc.nextInt();
		System.out.print("영어: ");
		eng = sc.nextInt();
		System.out.print("수학: ");
		mat = sc.nextInt();

		tot = kor + eng + mat;
		avg = tot / 3;

	}

	void outputScore() {
		System.out.println("총점: " + tot + "/ 평균: " + avg);
	}

}
