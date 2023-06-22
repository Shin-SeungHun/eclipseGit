package 자바수업05일;

import java.util.Scanner;

public class Study1_클래스_접근제한응용_로그인2 {
	public static void main(String[] args) {
		MainPg l = new MainPg();
	}

}

class Account {
	private String serverId = "admin";
	private String serverPw = "1004";
	private int money = 10000000;

	int getData(String id, String pw) {
		if (id.equals(serverId)) {
			if (pw.equals(serverPw)) {
				return money;
			} else {
				return -1;
			}
		}
		return -2;
	}
}

class MainPg {
	Scanner sc = new Scanner(System.in);

	MainPg() {
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

				Account acc = new Account();
				int money = acc.getData(id, pw);
				if (money == -1) {
					System.out.println("\n패스워드가 다릅니다. 확인!\n");
				} else if (money == -2) {
					System.out.println("\n아이디가 다릅니다. 확인!\n");
				} else {
					System.out.println("\n로그인되었습니다.\n");
					System.out.println("현재잔액: " + money);
					System.out.println();
				}
			} else if (input == 2) {
				System.out.println("\n프로그램종료");
				break;
			}
		}
	}

}