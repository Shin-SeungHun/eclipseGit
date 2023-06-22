class A4 {
	int x = 100;
}

class B4 extends A4 {
	int y = 200;
}

public class Round13_Ex09 {
	public static void main(String[] ar) {
		A4 ap = new B4(); // 다형적 표현
		System.out.println("x = " + ap.x);
		//System.out.println("y = " + ap.y); // Compile Error 발생
	}
}
