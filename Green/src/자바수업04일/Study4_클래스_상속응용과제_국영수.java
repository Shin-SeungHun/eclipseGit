package 자바수업04일;

import java.util.Scanner;

public class Study4_클래스_상속응용과제_국영수 {
	public static void main(String[] args) {
		// Score s = new Score();
		Aban2 a = new Aban2("A반");
		Bban2 b = new Bban2("B반");
	}
}

class Score2 {
	Scanner sc = new Scanner(System.in);
	int kor, eng, mat, tot, avg;// 국영수총평
	int sel;

	Score2() {
		while (true) {
			System.out.println("1.입력");
			System.out.println("2.출력");
			System.out.println("3.종료");
			System.out.print("선택:");
			sel = sc.nextInt();
			if (sel == 1) {
				input();
			} else if (sel == 2) {
				output();
			} else if (sel == 3) {
				break;
			}
		}
	}

	Score2(String ban) {
		System.out.println("<<" + ban + ">>");
	}

	void input() {
		System.out.print("국어:");
		kor = sc.nextInt();
		System.out.print("영어:");
		eng = sc.nextInt();
		System.out.print("수학:");
		mat = sc.nextInt();
		tot = kor + eng + mat;
		avg = tot / 3;
	}

	void output() {
		System.out.println("총점:" + tot + " / 평균:" + avg);
	}
}

class Aban2 extends Score {
	Scanner sc = new Scanner(System.in);
	int soc, sie, tot, avg;// 사회 과학 총점 평균
	int sel;

	Aban2(String name) {
		super(name);
		while (true) {
			System.out.println("1.입력");
			System.out.println("2.출력");
			System.out.println("3.종료");
			System.out.print("선택:");
			sel = sc.nextInt();
			if (sel == 1) {
				super.input();
				input();
			} else if (sel == 2) {
				output();
			} else if (sel == 3) {
				System.out.println("A반종료");
				break;
			}
		}
	}

	void input() {
		System.out.print("사회:");
		soc = sc.nextInt();
		System.out.print("과학:");
		sie = sc.nextInt();
		this.tot = kor + eng + mat + soc + sie;
		this.avg = tot / 5;
	}

	void output() {
		System.out.println("총점:" + this.tot + " / 평균:" + this.avg);
	}

}

class Bban2 extends Score {
	Scanner sc = new Scanner(System.in);
	int mus, art, tot, avg;// 음악 미술 총점 평균
	int sel;

	Bban2(String name) {
		super(name);
		while (true) {
			System.out.println("1.입력");
			System.out.println("2.출력");
			System.out.println("3.종료");
			System.out.print("선택:");
			sel = sc.nextInt();
			if (sel == 1) {
				super.input();
				input();
			} else if (sel == 2) {
				output();
			} else if (sel == 3) {
				System.out.println("B반종료");
				break;
			}
		}
	}

	void input() {
		System.out.print("음악:");
		mus = sc.nextInt();
		System.out.print("미술:");
		art = sc.nextInt();
		this.tot = kor + eng + mat + mus + art;
		this.avg = tot / 5;
	}

	void output() {
		System.out.println("총점:" + this.tot + " / 평균:" + this.avg);
	}

}
