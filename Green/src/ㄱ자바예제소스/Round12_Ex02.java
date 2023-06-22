package ㄱ자바예제소스;

class Outer1 {
	private static int x = 100;

	class Inner1 {
		private int x = 200;

		public void aaa() {
			System.out.println("x1 = " + Outer1.x);
			System.out.println("x2 = " + this.x);
		}
	}
}

public class Round12_Ex02 {
	public static void main(String[] ar) {
		Outer1 ot = new Outer1();
		Outer1.Inner1 oi = ot.new Inner1();
		oi.aaa();
	}
}
