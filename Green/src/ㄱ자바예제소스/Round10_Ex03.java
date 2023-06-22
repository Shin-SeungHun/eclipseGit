package ㄱ자바예제소스;

class Round10_Ex03_Other {
	protected int x = 10;// 상속에 한해서만 접근가능
}

public class Round10_Ex03 {
	public static void main(String[] ar) {
		Round10_Ex03_Other rd = new Round10_Ex03_Other();
		System.out.println("x = " + rd.x);
	}
}
