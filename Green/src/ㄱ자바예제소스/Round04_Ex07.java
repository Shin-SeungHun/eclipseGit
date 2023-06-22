package ㄱ자바예제소스;

public class Round04_Ex07 {
	public static void main(String[] ar) throws java.io.IOException {
		System.out.print("입력1 = "); // println 아님.
		char aa = (char) System.in.read();
		System.in.read();
		System.in.read();
		System.out.print("입력2 = "); // println 아님.
		int bb = System.in.read() - 48; // 숫자만 입력할 것.
		System.out.println("입력된 문자는 " + aa + "입니다.");
		System.out.println("입력된 숫자는 " + bb + "입니다.");
	}
}

