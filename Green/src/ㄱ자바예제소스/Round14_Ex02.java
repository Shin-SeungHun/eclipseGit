package ㄱ자바예제소스;

interface A22 {
	void aaa();

	public abstract void bbb();
}

class B22 implements A22 {
	public void aaa() { // Compile Error ? public 을 붙여 주어야 함.
		System.out.println("aaa 메서드");
	}

	public void bbb() {
		System.out.println("bbb 메서드");
	}
}

public class Round14_Ex02 {
	public static void main(String[] ar) {
		B22 bp = new B22();
		bp.aaa();
		bp.bbb();
	}
}

