package ㄱ자바예제소스;

import java.io.*;
public class Round15_Ex08 {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int x = 0, y = 0, tot = 0;
		boolean bool = false;
		do{
			bool = false;
			System.out.print("x = ");
			try {
				x = Integer.parseInt(in.readLine());
			}catch(NumberFormatException nfe) {
				System.out.println("x는 숫자여야 합니다.");
				bool = true;
			}
		}while(bool);
		
		do{
			bool = false;
			System.out.print("y = ");
			try {
				y = Integer.parseInt(in.readLine());
			}catch(NumberFormatException nfe) {
				System.out.println("y는 숫자여야 합니다.");
				bool = true;
			}
		}while(bool);
		
		try {
			tot = x / y;
		}catch(ArithmeticException ae) {
			tot = x;
			System.out.println("0으로는 나눌수 없습니다. 수치오류!");
		}
		System.out.println(x + " / " + y + " = " + tot);  
	}
}
