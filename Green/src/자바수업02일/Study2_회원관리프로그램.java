package 자바수업02일;

import java.util.Scanner;

public class Study2_회원관리프로그램 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// 문자열 비교 방법
		String data[] = { "홍길동", "아무개", "둘리" };

		while (true) {
			System.out.println("찾을 이름 입력");
			String name = sc.next();

			for (int i = 0; i < data.length; i++) {

				if (name.equals(data[i])) {
					System.out.println("해당이름이 존재합니다");
					break;
				}
			}

			System.out.println("계속하시겠습니까?(y,n):");
			String yNo = sc.next();

			if (yNo.equals("n")) {
				break;
			}
		}
	}

}
