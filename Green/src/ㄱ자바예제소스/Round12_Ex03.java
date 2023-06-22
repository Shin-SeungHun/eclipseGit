package ㄱ자바예제소스;

class Outer2 {
	private static int x = 100;

	static class Inner2 {
		private int y = 200;

		public void aaa() {
			System.out.println("x = " + x); // Compile Error 발생
			System.out.println("y = " + y);
		}
	}
}

public class Round12_Ex03 {
	public static void main(String[] ar) {
		Outer2.Inner2 oi = new Outer2.Inner2();
		oi.aaa();
	}
}

