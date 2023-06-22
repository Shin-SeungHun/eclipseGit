package ㄱ자바예제소스;

public class Round12_Ex06 {
	public static void main(String[] ar) {
		final int x = 100;
		class Inner5 {
			int y = 200;

			public void aaa() {
				System.out.println("x = " + x);
				System.out.println("y = " + y);
			}
		}
		Inner5 in = new Inner5();
		in.aaa();
	}
}
