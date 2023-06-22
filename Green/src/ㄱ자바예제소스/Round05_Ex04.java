package ㄱ자바예제소스;

public class Round05_Ex04 {
	public static boolean aaa() {
		System.out.println("AAA");
		return true;
	}
	public static boolean bbb() {
		System.out.println("BBB");
		return false;
	}
	public static void main(String[] ar) {
		boolean b = aaa() || bbb(); // 
		System.out.println("b = " + b);
	}
}
