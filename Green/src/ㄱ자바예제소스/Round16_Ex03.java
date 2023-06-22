package ㄱ자바예제소스;

import java.io.*;

public class Round16_Ex03 {
	public static void main(String[] args) {
		/*
		 * File f = new File("c:\\java\\work1"); boolean bool = f.mkdir();
		 * if(bool) System.out.println("잘 만들어 졌다."); else
		 * System.out.println("만들기 실패다.");
		 */
		// work폴더에 abc.txt가 없다면
		// abc.txt라는 파일은 없습니다. 라고 뜨면 되고
		// work폴더에 abc.txt가 있다면
		// 파일명 : abc.txt
		// 파일 경로 : c:/java/work
		// 파일 크기 : 0kb
		// 최종 수정일 : Aug 31 2005, 15:22:47 이라고 출력하면 된다.
		// 그리고 프로그램 종료시 파일 삭제한다.
		File f = new File("c:\\java\\work\\abc.txt");
		if (f.exists()) {
			f.deleteOnExit();
			System.out.println("파일명 : " + f.getName());
			System.out.println("파일 경로 : " + f.getPath());
			System.out.println("파일 경로 : " + f.getParent());
			System.out.println("파일 크기 : " + +f.length() + "kb");
			System.out.println("최종 수정일 : "
					+ new java.util.Date(f.lastModified()));
		} else {
			System.out.println(f.getName() + "라는 파일이 없습니다.");
		}
	}
}
