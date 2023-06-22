package ㄱ자바예제소스;

class Round09_Ex04 {
	int a, b, c, d, e, f, g;

	Round09_Ex04() {
		a = 1;
		b = 2;
		c = 3;
		d = 4;
		e = 5;
		f = 6;
		g = 7;
	}

	Round09_Ex04(int x) {
		this();
		d = x;
	}

	Round09_Ex04(int x, int y) {
		this(x);
		e = y;
	}

	public static void main(String[] ar) {
		Round09_Ex04 kor = new Round09_Ex04();
		Round09_Ex04 kor1 = new Round09_Ex04(100);
		Round09_Ex04 kor2 = new Round09_Ex04(100, 200);

		System.out.println("kor.a = " + kor.a);
		System.out.println("kor.b = " + kor.b);
		System.out.println("kor.c = " + kor.c);
		System.out.println("kor.d = " + kor.d);
		System.out.println("kor.e = " + kor.e);
		System.out.println("kor.f = " + kor.f);
		System.out.println("kor.g = " + kor.g);

	}
}
