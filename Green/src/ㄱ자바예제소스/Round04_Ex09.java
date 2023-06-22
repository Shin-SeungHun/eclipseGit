package ㄱ자바예제소스;

import java.io.*;

public class Round04_Ex09 {
	public static void main(String[] ar) throws java.io.IOException {
		// 문자열 입력을 위한 포맷 지정
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

//		String name = ""; // name 변수의 선언과 초기화
//		System.out.print("이름을 입력하세요 : "); // println이 아닙니다.
//		name = in.readLine(); // 이름을 입력 받는답니다.
//		System.out.println("당신이 입력하신 이름은 " + name + "입니다.");

		System.out.print("수1 : ");
		int su1 = Integer.parseInt(in.readLine());
		System.out.print("수2 : ");
		int su2 = Integer.parseInt(in.readLine());
		System.out.println("결과 : " + (su1 + su2));

		System.out.print("수3 : ");
		String szSu1 = in.readLine();
		int su3 = Integer.parseInt(szSu1);
		
		System.out.print("수4 : ");
		String szSu2 = in.readLine();
		int su4 = Integer.parseInt(szSu2);
		
		System.out.println("결과 : " + (su3 + su4));
	}
}
