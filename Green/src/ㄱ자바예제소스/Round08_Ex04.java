package ㄱ자바예제소스;

import java.io.*;

public class Round08_Ex04 {
	public static void main(String[] ar) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] subname = { "국어", "영어", "수학" };
		int[] sub = new int[subname.length + 1]; // 0:국어 1:영어 2:수학 3:총합
		float avg = 0.0f;

		for (int i = 0; i < sub.length - 1; i++) {
			do {
				System.out.print(subname[i] + " = ");
				sub[i] = Integer.parseInt(in.readLine());
			} while (sub[i] < 0 || sub[i] > 100);
			sub[sub.length - 1] += sub[i];
		}

		avg = sub[sub.length - 1] / (float) (sub.length - 1);

		System.out.println();
		System.out.println("총점 = " + sub[sub.length - 1]);
		System.out.println("평균 = " + avg);
	}
}

