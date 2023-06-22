package ㄱ자바예제소스;

import java.io.*;

public class Round06_Ex03 {
	public static void main(String[] ar) throws IOException {
		System.out.print("주민번호 7번째 자리를 입력하세요 : ");
		int x = System.in.read() - 48; // 7번째 자리 수 입력
		int year = 0; // 연대를 저장할 Field
		String sex = ""; // 성별을 저장할 Field

		switch (x) {
		case 9:
		case 0:
			year = 1800;
			break;
		case 1:
		case 2:
			year = 1900;
			break;
		case 3:
		case 4:
			year = 2000;
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
			System.exit(-1); // 프로그램 종료
		}

		sex = x % 2 == 0 ? "여성" : "남성";

		System.out.print("당신은 " + year + "년대생 ");
		System.out.println(sex + "이십니다.");
	}
}

