package 자바수업04일;

import java.util.Scanner;

public class Study5 {

	public static void main(String[] args) {
//		Score score = new Score();
		Aban a = new Aban("A반");
		Bban b = new Bban("B반");
	}

}

class Score {
	Scanner sc = new Scanner(System.in);
	int kor = 0, eng = 0, mat = 0, tot = 0;
	double avg = 0;
	int input;

	public Score() {
		while (true) {

			System.out.println("1.입력");
			System.out.println("2.출력");
			System.out.println("3.종료");
			System.out.print("선택: ");
			input = sc.nextInt();

			if (input == 1) {
				input();
			} else if (input == 2) {
				output();
			} else if (input == 3) {
				System.out.println("종료");
				break;
			}

		}
	}

	public Score(String ban) {
		System.out.println("<<" + ban + ">>");
	}

	void input() {
		System.out.print("국어: ");
		this.kor = sc.nextInt();
		System.out.print("영어: ");
		this.eng = sc.nextInt();
		System.out.print("수학: ");
		this.mat = sc.nextInt();

		this.tot = this.kor + this.eng + this.mat;
		this.avg = this.tot / 3;
	}

	void output() {
		System.out.println("총점: " + this.tot + " 평균: " + this.avg);
	}
}

class Aban extends Score {
	Scanner sc = new Scanner(System.in);
	int society = 0, science = 0, tot = 0;
	double avg = 0;
	int input2;

	public Aban(String name) {
		super(name);
//		this.input();
//		super.input();
		while (true) {
			System.out.println("1.입력");
			System.out.println("2.출력");
			System.out.println("3.종료");
			System.out.print("선택: ");
			input = sc.nextInt();

			if (input == 1) {
				super.input();
				this.input();
			} else if (input == 2) {
				this.output();
			} else if (input == 3) {
				System.out.println("\nA반 종료\n");
				break;
			}

		}

	}

	void input() {

		System.out.print("사회: ");
		this.society = sc.nextInt();
		System.out.print("과학: ");
		this.science = sc.nextInt();

		this.tot = super.tot + this.society + this.science;
		this.avg = this.tot / 5;
	}

	void output() {
		System.out.println("총점: " + this.tot + " 평균: " + this.avg);
		System.out.println();
	}
}

class Bban extends Score {
	Scanner sc = new Scanner(System.in);
	int music = 0, art = 0, tot = 0;
	double avg = 0;
	int input;

	public Bban(String name) {

		super(name);
		while (true) {

			System.out.println("1.입력");
			System.out.println("2.출력");
			System.out.println("3.종료");
			System.out.print("선택: ");
			input = sc.nextInt();

			if (input == 1) {
				super.input();
				this.input();
			} else if (input == 2) {
				this.output();
			} else if (input == 3) {
				System.out.println("\nB반종료\n");
				break;
			}

		}
	}

	void input() {
		System.out.print("음악: ");
		this.music = sc.nextInt();
		System.out.print("미술: ");
		this.art = sc.nextInt();

		this.tot = super.tot + this.music + this.art;
		this.avg = this.tot / 5;
	}

	void output() {
		System.out.println("총점: " + this.tot + " 평균: " + this.avg);
		System.out.println();
	}
}
