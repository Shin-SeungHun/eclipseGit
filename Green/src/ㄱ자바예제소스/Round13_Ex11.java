class A6 {
	public void aaa() {
		System.out.println("aaa");
	}

	public void bbb() {
		System.out.println("bbb");
	}
}

class B6 extends A6 {
	public void bbb() {
		System.out.println("bbb1");
	}

	public void ccc() {
		System.out.println("ccc");
	}
}

public class Round13_Ex11 {
	public static void main(String[] ar) {
		A6 ap = new B6(); // 다형적 표현
		ap.aaa(); // A6 클래스의 aaa() 메서드 호출 ? aaa 출력
		ap.bbb(); // B6 클래스의 bbb() 메서드 호출 ? bbb1 출력
		// ap.ccc(); // Compile Error 발생
	}
}
