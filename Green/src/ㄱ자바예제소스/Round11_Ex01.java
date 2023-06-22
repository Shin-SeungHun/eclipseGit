package ㄱ자바예제소스;

public class Round11_Ex01 { // main 메서드를 함께 쓰는 형태
	private int x;

	private int y;

	public Round11_Ex01() {
		x = 0;
		y = 0;
	}

	public Round11_Ex01(int a, int b) {
		x = a;
		y = b;
	}

	public void disp() {
		System.out.println("x = " + x + ", y = " + y);
	}

	public static void main(String[] ar) {
		Round11_Ex01 rd = new Round11_Ex01(100, 200);
		rd.disp();
	}
}

