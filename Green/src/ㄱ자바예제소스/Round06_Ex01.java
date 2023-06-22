package ㄱ자바예제소스;

import java.io.*;

public class Round06_Ex01 {
	public static void main(String[] ar) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int firstsu = 0, secondsu = 0;

		System.out.print("첫번째 수 = ");
		firstsu = Integer.parseInt(in.readLine());

		System.out.print("두번째 수 = ");
		secondsu = Integer.parseInt(in.readLine());

		if (firstsu > secondsu) {
			System.out.print("첫번째 수(" + firstsu + ")");
			System.out.print("가 두번째 수(" + secondsu + ")");
			System.out.println("보다 큰 수 입니다.");
		} else {
			System.out.print("첫번째 수(" + firstsu + ")");
			System.out.print("가 두번째 수(" + secondsu + ")");
			System.out.println("보다 작은 수 입니다.");
		}
	}
}
