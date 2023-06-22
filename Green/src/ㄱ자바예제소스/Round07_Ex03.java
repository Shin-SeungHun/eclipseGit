package ㄱ자바예제소스;

import java.io.*;

public class Round07_Ex03 {
	public static int plu(int x, int y) {
		return x + y;
	}

	public static int min(int x, int y) {
		return x - y;
	}

	public static int mul(int x, int y) {
		return x * y;
	}

	public static int div(int x, int y) {
		return x / y;
	}

	public static int per(int x, int y) {
		return x % y;
	}

	public static void disp(int a, char b, int c, int d) {
		System.out.println();
		System.out.print(a + " " + b + " " + c);
		System.out.println(" = " + d);
	}

	public static void main(String[] ar) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int su1 = 0, su2 = 0, tot = 0;
		char yon = 0;

		System.out.print("su1 = ");
		su1 = Integer.parseInt(in.readLine());
		do {
			System.out.print("yon(+, -, *, /, %) = ");
			yon = (char) System.in.read();
			System.in.read();
			System.in.read();
		} while (yon != '+' && yon != '-' && yon != '*' && yon != '/'
				&& yon != '%');
		System.out.print("su2 = ");
		su2 = Integer.parseInt(in.readLine());

		switch (yon) {
		case '+':
			tot = plu(su1, su2);
			break;
		case '-':
			tot = min(su1, su2);
			break;
		case '*':
			tot = mul(su1, su2);
			break;
		case '/':
			tot = div(su1, su2);
			break;
		case '%':
			tot = per(su1, su2);
			break;
		}

		disp(su1, yon, su2, tot);
	}
}
