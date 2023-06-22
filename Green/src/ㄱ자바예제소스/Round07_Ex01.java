package ㄱ자바예제소스;

public class Round07_Ex01 {
	public static void X() {
		int x = 10;
		if (x == 10) {
			return;
		}
		for (int a = 0; a < 5; a++) {
			System.out.print("*");
		}
		return; // 종료 결과형 return 값이 void 일 경우 return 문구 생략 가능
	}

	public static void main(String[] ar) {
		X();
		System.out.println("\nHello");
		X();
		System.out.println("\nJava");
		X();
		System.out.println("\n!!!");
		X();
		return; // main에도 원래는 이 구문이 있어야 하지만 생략 됨
	}
}
