package ㄱ자바예제소스;

import java.io.*;

public class Round06_Ex04 {
	public static void main(String[] ar) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int su1 = 0, su2 = 0, tot = 0;
		char yon = 0;

		System.out.print("첫번째 수 = ");
		su1 = Integer.parseInt(in.readLine());
		System.out.print("연산자(+, -, *, /, %) = ");
		yon = (char) System.in.read();
		System.in.read();
		System.in.read();
		System.out.print("두번째 수 = ");
		su2 = Integer.parseInt(in.readLine());

		switch (yon) {
		case '+':
			tot = su1 + su2;
			break;
		case '-':
			tot = su1 - su2;
			break;
		case '*':
			tot = su1 * su2;
			break;
		case '/':
			tot = su1 / su2;
			break;
		case '%':
			tot = su1 % su2;
			break;
		default:
			System.out.println("잘못된 연산자 입력");
			System.exit(-1);
		}

		System.out.println();
		System.out.println(su1 + " " + yon + " " + su2 + " = " + tot);
	}
}
