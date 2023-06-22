package ㄱ자바예제소스;

import java.io.*;

public class Round10_Ex11 {
	public static void main(String[] ar) throws IOException {
		System.out.println("좌표 값 처리");
		Round10_Ex10 rd = new Round10_Ex10();
		// 값 입력 받기
		rd.setX();
		rd.setY();
		// 결과 좌표 보기
		rd.display();
		// 좌표를 다른 곳으로 옮기기
		System.out.println("좌표를 50, 100으로 이동합니다.");
		rd.setX(50);
		rd.setY(100);
		// 다시 한번 결과 좌표 보기
		rd.display();
	}
}

