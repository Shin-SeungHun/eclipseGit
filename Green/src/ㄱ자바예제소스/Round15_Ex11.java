package ㄱ자바예제소스;

import java.io.*;
public class Round15_Ex11{
	private static BufferedReader in;
	static {
		in = new BufferedReader(new InputStreamReader(System.in));
	}
	public static void main(String[] args) throws IOException {
		int su1 = 0, su2 = 0, tot = 0;
		char yon = 0, flag = 0;
		while(true) {
			do {
				flag = 0;
				try{
					System.out.print("SU1 = ");
					su1 = Integer.parseInt(in.readLine());
				}catch(NumberFormatException nfe) {
					System.out.println("숫자만 입력 가능!");
					flag = 1;
				}
			}while(flag != 0);
			
			do {
			
			do {
				flag = 0;
				String str = "";
				try{
					System.out.print("YON(+, -, *, /) = ");
					str = in.readLine();
					yon = str.charAt(0);
				}catch(StringIndexOutOfBoundsException siooe) {
					System.out.println("뭐든 입력은 해야 합니다.");
					flag = 1;
				}
				if(str.length() != 1) {
					System.out.println("연산자는 1자리 여야 합니다.");
					flag = 1;
				}
			}while(flag != 0 || yon != '+' && 
				yon != '-' && yon != '*' && yon != '/');			
			do {
				flag = 0;
				try {
					System.out.print("SU2 = ");
					su2 = Integer.parseInt(in.readLine());
				}catch(NumberFormatException nfe) {
					System.out.println("숫자만 입력 가능!");
					flag = 1;
				}
			}while(flag != 0);
			flag = 0;
			try{
				switch(yon) {
				case '+' : tot = su1 + su2; break;
				case '-' : tot = su1 - su2; break;
				case '*' : tot = su1 * su2; break;
				case '/' : tot = su1 / su2; break;
				}
			}catch(ArithmeticException ae) {
				System.out.println("0으로 나눌수는 없습니다.");
				flag = 1;
			}
			
			}while(flag != 0); 		
			System.out.println(su1 + " " + yon + " " + su2 
											+ " = " + tot);
		}
	}
}
