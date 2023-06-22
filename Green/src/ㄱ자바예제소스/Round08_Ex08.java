package ㄱ자바예제소스;

import java.io.*;

public class Round08_Ex08 {
	public static void main(String[] ar) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] subname = { "국어", "영어", "수학" };
		int[][][] sub = new int[2][3][subname.length + 3];
		// 0:국어 1:영어 2:수학 3:총합 4:석차
		float[][] avg = new float[2][3];

		for (int h = 0; h < sub.length; h++) {
			for (int k = 0; k < sub[h].length; k++) {
				for (int i = 0; i < sub[h][k].length - 3; i++) {
					do {
						System.out.print(subname[i] + " = ");
						sub[h][k][i] = Integer.parseInt(in.readLine());
					} while (sub[h][k][i] < 0 || sub[h][k][i] > 100);
					sub[h][k][sub[h][k].length - 3] += sub[h][k][i];
				}
				avg[h][k] = sub[h][k][sub[h][k].length - 3]
						/ (float) (sub[h][k].length - 3);
				sub[h][k][sub[h][k].length - 2] = 1;
				sub[h][k][sub[h][k].length - 1] = 1;
			}
		}

		// 반석차 구하는 방식
		for (int h = 0; h < sub.length; h++) {
			for (int k = 0; k < sub[h].length; k++) {
				for (int i = 0; i < sub[h].length; i++) {
					if (sub[h][k][sub[h][k].length - 3] < sub[h][i][sub[h][i].length - 3]) {
						sub[h][k][sub[h][k].length - 2]++;
					}
				}
			}
		}

		// 전교석차 구하는 방식
		for (int h = 0; h < sub.length; h++) {
			for (int k = 0; k < sub[h].length; k++) {
				for (int i = 0; i < sub.length; i++) {
					for (int j = 0; j < sub[i].length; j++) {
						if (sub[h][k][sub[h][k].length - 3] < sub[i][j][sub[i][j].length - 3]) {
							sub[h][k][sub[h][k].length - 1]++;
						}
					}
				}
			}
		}

		for (int h = 0; h < sub.length; h++) {
			for (int k = 0; k < sub[h].length; k++) {
				System.out.println();
				System.out.println("총점 = " + sub[h][k][sub[h][k].length - 3]);
				System.out.println("평균 = " + avg[h][k]);
				System.out.println("석차 = " + sub[h][k][sub[h][k].length - 2]
						+ "등");
				System.out.println("전교석차 = " + sub[h][k][sub[h][k].length - 1]
						+ "등");
			}
		}
	}
}
