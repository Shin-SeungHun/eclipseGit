package ㄱ자바예제소스;

public class Round09_Ex03 {
	int a;

	double b;

	Round09_Ex03() {
		a = 100;
		b = 200.0;
	}

	Round09_Ex03(int x) {
		a = x;
		b = 200.0;
	}

	Round09_Ex03(double x) {
		a = 100;
		b = x;
	}

	Round09_Ex03(int x, double y) {
		a = x;
		b = y;
	}

	public static void main(String[] ar) {
		Round09_Ex03 kor = new Round09_Ex03();
		Round09_Ex03 kor1 = new Round09_Ex03(55);
		Round09_Ex03 kor2 = new Round09_Ex03(78.923);
		Round09_Ex03 kor3 = new Round09_Ex03(123, 45.678);
		System.out.println(kor.a + ", " + kor.b);
		System.out.println(kor1.a + ", " + kor1.b);
		System.out.println(kor2.a + ", " + kor2.b);
		System.out.println(kor3.a + ", " + kor3.b);
	}
}
