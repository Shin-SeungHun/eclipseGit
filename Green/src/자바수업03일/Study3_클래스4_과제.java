package 자바수업03일;

import java.util.Scanner;

public class Study3_클래스4_과제 {

	public static void main(String[] args) {
		Minam m = new Minam();
		m.input();
		m.output();
	}

}

class Minam {
	Scanner sc = new Scanner(System.in);
	int input;
	int MAX = 100;
	String name[] = new String[MAX];
	int age[] = new int[MAX];
	double height[] = new double[MAX];
	double weight[] = new double[MAX];
	String score[] = new String[MAX];
	int cnt = 0; // 사람 추가할때마다 증가

	public Minam() {
		while (true) {
			System.out.println("1.미남입력");
			System.out.println("2.미남리스트");
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

	void input() {
		System.out.println("<" + (cnt + 1) + "번째 사람추가>");
		System.out.print("이름: ");
		name[cnt] = sc.next();
		System.out.print("나이: ");
		age[cnt] = sc.nextInt();
		System.out.print("키: ");
		height[cnt] = sc.nextInt();
		System.out.print("몸무게: ");
		weight[cnt] = sc.nextInt();

		if (22 <= age[cnt] && age[cnt] <= 30 && 180 <= height[cnt] && height[cnt] <= 190 && 75 <= weight[cnt]
				&& weight[cnt] <= 85) {

			System.out.println("미남");
			score[cnt] = "미남";

		} else if (height[cnt] < 180 && 75 <= weight[cnt] && weight[cnt] <= 85) {

			System.out.println("보통");
			score[cnt] = "보통";

		} else if (height[cnt] < 170 && 90 <= weight[cnt]) {

			System.out.println("추남");
			score[cnt] = "추남";

		}

		cnt++; // 카운트증가

	}

	void output() {

		for (int i = 0; i < cnt; i++) {

			System.out.println(i + 1 + "번 " + name[i] + " / " + age[i] + "살/ " + height[i] + "cm/ " + weight[i] + "kg/ "
					+ score[i]);
		}

	}
}