package ㄱ자바예제소스;

import java.io.*;

public class Round15_Ex18 {
	public static void main(String[] args) throws IOException {
		Runtime rt = Runtime.getRuntime();
		System.out.print("1.유튜브 2.네이버 = ");
		int x = System.in.read() - 48;
		System.in.read();
		System.in.read();
		String str = "";
		if (x == 1) {
			str = "http://www.youtube.com";
		} else if (x == 2) {
			str = "http://www.naver.com";
		}
		rt.exec("explorer.exe " + str);

	}
}
