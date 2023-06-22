package ㄱ자바예제소스;

class A1 {
	protected int x = 100;
}

class B1 extends A1 {
	private int x = 200;

	public void disp() {
		System.out.println("A1 클래스의 x = " + super.x);
		System.out.println("B1 클래스의 x = " + this.x);
	}
}

public class Round13_Ex05 {
	public static void main(String[] ar) {
		B1 bp = new B1();
		bp.disp();
	}
}
