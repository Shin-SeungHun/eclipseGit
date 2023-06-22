package 자바수업05일;

import java.util.Scanner;

public class Study1_클래스_접근제한응용_로그인 {
	public static void main(String[] args) {
		Login l = new Login();
	}

}

class Login {
	Scanner sc = new Scanner(System.in);
	private String serverId = "admin";
	private String serverPw = "1004";
	private int money = 10000000;

	Login() {
		int input;
		while (true) {
			System.out.println("<로그인테스트>");
			System.out.println("1.로그인");
			System.out.println("2.종료");
			System.out.print("선택:");
			input = sc.nextInt();
			if (input == 1) {
				System.out.println();
				System.out.print("아이디:");
				String id = sc.next();
				System.out.print("패스워드:");
				String pw = sc.next();

				if (getData(id, pw) > -1) {
					System.out.println("현재잔액: " + getData(id, pw));
					System.out.println();
				}

			} else if (input == 2) {
				System.out.println("\n프로그램종료");
				break;
			}
		}
	}

	int getData(String id, String pw) {
		if (id.equals(serverId)) {
			if (pw.equals(serverPw)) {
				System.out.println("\n로그인되었습니다.\n");
				return money;
			} else {
				System.out.println("\n패스워드가 다릅니다. 확인!\n");
				return -1;
			}
		} else {
			System.out.println("\n아이디가 다릅니다. 확인!\n");
			return -2;
		}

	}

}