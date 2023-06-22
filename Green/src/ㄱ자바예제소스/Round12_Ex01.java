package ㄱ자바예제소스;

class Outer {
	int x = 100;

	class Inner {
		int y = 200;
	}
}

public class Round12_Ex01 {
	public static void main(String[] ar) {
		Outer ot = new Outer();
		Outer.Inner oi = ot.new Inner();
		System.out.println("x = " + ot.x);
		System.out.println("y = " + oi.y);
	}
}
