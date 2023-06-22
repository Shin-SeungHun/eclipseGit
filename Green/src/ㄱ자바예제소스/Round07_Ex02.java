package ㄱ자바예제소스;

import java.io.*;

public class Round07_Ex02 {
	public static int aaa() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("첫번째 수 = ");
		int a = Integer.parseInt(in.readLine());
		System.out.print("두번째 수 = ");
		int b = Integer.parseInt(in.readLine());
		if (a > b) {
			return a;
		}
		return b;
	}

	public static void bbb() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("첫번째 수 = ");
		int a = Integer.parseInt(in.readLine());
		System.out.print("두번째 수 = ");
		int b = Integer.parseInt(in.readLine());
		int tot = 0;
		if (a > b) {
			int imsi = a; //자리바꾸기
			a = b;
			b = imsi;
		}
		for (int i = a; i <= b; i++) {
			tot += i;
		}
		System.out.println(a + " ~ " + b + "사이의 합 = " + tot);
		return;
	}

	public static String ccc(int x, int y, int z) {
		if (y >= x && y >= z) {
			int imsi = x;
			x = y;
			y = imsi;
		} else if (z >= x && z >= y) {
			int imsi = x;
			x = z;
			z = imsi;
		}
		if (z >= y) {
			int imsi = y;
			y = z;
			z = imsi;
		}
		String abc = x + " >= " + y + " >= " + z;
		return abc;
	}

	public static void main(String[] ar) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int x = 0;
		while (true) {
			System.out.print("1:최대수 2:사이합 3:수나열 4:종료 => ");
			x = Integer.parseInt(in.readLine());
			if (x == 1) { // 결과형 return 값을 사용한 형태
				int k = aaa();
				System.out.println("둘 중 최대수는 " + k + "입니다.");
			} else if (x == 2) { // Call By Name
				bbb();
			} else if (x == 3) { // Call By Value
				System.out.print("첫번째 수 = ");
				int firstSu = Integer.parseInt(in.readLine());
				System.out.print("두번째 수 = ");
				int secondSu = Integer.parseInt(in.readLine());
				System.out.print("세번째 수 = ");
				int thirdSu = Integer.parseInt(in.readLine());
				String str = ccc(firstSu, secondSu, thirdSu);
				System.out.println("큰 순으로 나열은 " + str);
			} else if (x == 4) {
				break;
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}
			System.out.println();
		}
		System.out.println("수고 하셨습니다.");
	}
}

