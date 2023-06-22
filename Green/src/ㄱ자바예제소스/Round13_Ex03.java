package ㄱ자바예제소스;

class UpperClass {
	int x;

	int y;

	public UpperClass() {
		x = 10;
		y = 20;
	}

	public UpperClass(int x) {
		this(); // 자신의 클래스 public UpperClass() 생성자 호출
		this.x = x;
	}

	public UpperClass(int x, int y) {
		this(x); // 자신의 클래스 public UpperClass(int x) 생성자 호출
		this.y = y;
	}
}

class LowerClass extends UpperClass {
	int r;

	public LowerClass() {
		super(); // 상위 클래스의 public UpperClass() 생성자 호출. 생략 가능.
		r = 30;
	}

	public LowerClass(int x) {
		super(x); // 상위 클래스의 public UpperClass(int x) 생성자 호출
		r = 30;
	}

	public LowerClass(int x, int y) {
		super(x, y); // 상위 클래스의 public UpperClass(int x, int y) 생성자 호출
		r = 30;
	}

	public LowerClass(int x, int y, int r) {
		this(x, y); // 자신의 클래스 public LowerClass(int x, int y) 생성자 호출
		this.r = r;
	}
}

public class Round13_Ex03 {
	public static void main(String[] ar) {
		// 필요한 객체 생성 가능.
		LowerClass lc = new LowerClass(10);
		System.out.println("lc.x = "+lc.x);
		System.out.println("lc.y = "+lc.y);
		System.out.println("lc.r = "+lc.r);
	}
}

