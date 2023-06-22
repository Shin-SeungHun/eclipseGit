package ㄱ자바예제소스;

class A {
	protected int x = 100;

	private int y = 200;
}

class B extends A {
	private int r = 300;
}

public class Round13_Ex04 {
	public static void main(String[] ar) {
		B bp = new B();
		System.out.println("bp.x = "+bp.x);
		
		A a = new A();
		System.out.println("a.x="+ a.x);
	}
}
