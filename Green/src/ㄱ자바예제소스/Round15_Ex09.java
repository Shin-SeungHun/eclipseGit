package ㄱ자바예제소스;

import java.io.*;
public class Round15_Ex09 {
	public static int aaa() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int age = 0;
		try {
			System.out.print("나이 = ");
			age = Integer.parseInt(in.readLine());
			System.out.println("정상 입력되어서 처리되는 구간1");
			System.out.println("정상 입력되어서 처리되는 구간2");
			System.out.println("정상 입력되어서 처리되는 구간3");
			System.out.println("정상 입력되어서 처리되는 구간4");
			System.out.println("정상 입력되어서 처리되는 구간5");

			return age;
		}catch(NumberFormatException nfe) {
			//nfe.printStackTrace();
			System.out.println("error = " + nfe.getMessage());
			//System.out.println();
			return age;
		}catch(IOException ie) {
			return age;
		}finally {//무조건 수행해야하는 구간
			System.out.println("무조건 수행해야한 구간!");
		}
	}
	public static void main(String[] args) {
		System.out.println("Main Start!!");
		aaa();
		System.out.println("Main End!!");
	}
}
