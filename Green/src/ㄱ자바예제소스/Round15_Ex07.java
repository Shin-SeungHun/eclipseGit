package ㄱ자바예제소스;
//예외처리
public class Round15_Ex07 {
	public static void main(String[] args) {
		try{ //입력
			System.out.print("x = ");
			int x = System.in.read() - 48;
			System.out.println("x = " + x);
			
			//잡아냄
		}
		catch(java.io.IOException io) {
			System.err.println("누가 선 끊었다.");
			System.exit(0); // 프로그램 종료
		}
	}
}
