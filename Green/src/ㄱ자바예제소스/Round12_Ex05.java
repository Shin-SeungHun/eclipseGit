package ㄱ자바예제소스;

public class Round12_Ex05 {
	public static void main(String[] ar) {
		int x = 100;
		class Inner4 {
			int y = 200;
		}
		Inner4 in = new Inner4();
		System.out.println(x);
		System.out.println(in.y);
	}
}
