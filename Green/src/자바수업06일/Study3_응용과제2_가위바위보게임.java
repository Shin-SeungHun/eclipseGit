package 자바수업06일;

import java.util.Scanner;

public class Study3_응용과제2_가위바위보게임 {
	public static void main(String[] args) {
		GameGbb game = new GameGbb();
	}
}

class GameGbb {
	Scanner sc = new Scanner(System.in);
	int sel;
	String myMent;
	int totCnt, winCnt, drawCnt, lossCnt;

	GameGbb() {
		while (true) {
			System.out.println("1.게임시작");
			System.out.println("2.결과");
			System.out.println("3.종료");
			System.out.print("선택:");
			sel = sc.nextInt();
			if (sel == 1) {
				gameStart();
			} else if (sel == 2) {
				history();
			} else if (sel == 3) {
				System.out.println("프로그램종료.");
				break;
			}

		}
	}

	void gameStart() {
		System.out.println("컴퓨터가 생각중입니다.");
		System.out.print("선택:");
		myMent = sc.next();
		int comRand = (int) (Math.random() * 3);
		String comMent = com(comRand);
		ing();

		if (myMent.equals("가위")) {
			if (comMent.equals("가위")) {
				resultMent("무");
				drawCnt++;
			} else if (comMent.equals("바위")) {
				resultMent("패");
				lossCnt++;
			} else if (comMent.equals("보")) {
				resultMent("승");
				winCnt++;
			}
		} else if (myMent.equals("바위")) {
			if (comMent.equals("가위")) {
				resultMent("승");
				winCnt++;
			} else if (comMent.equals("바위")) {
				resultMent("무");
				drawCnt++;
			} else if (comMent.equals("보")) {
				resultMent("패");
				lossCnt++;
			}
		} else if (myMent.equals("보")) {
			if (comMent.equals("가위")) {
				resultMent("패");
				lossCnt++;
			} else if (comMent.equals("바위")) {
				resultMent("승");
				winCnt++;
			} else if (comMent.equals("보")) {
				resultMent("무");
				drawCnt++;
			}
		}
		totCnt++;
		System.out.println("컴퓨터 : " + comMent + "  vs 나 : " + myMent);
	}

	void resultMent(String ment) {
		if (ment.equals("승")) {
			System.out.println("\n내가 승리하였습니다.\n");
		} else if (ment.equals("무")) {
			System.out.println("\n비겼습니다.\n");
		} else if (ment.equals("패")) {
			System.out.println("\n내가 패배하였습니다.\n");
		}
	}

	String com(int com) {
		if (com == 0) {
			return "가위";
		} else if (com == 1) {
			return "바위";
		} else if (com == 2) {
			return "보";
		} else {
			return "";
		}
	}

	void ing() {
		try {
			System.out.println("3...");
			Thread.sleep(1000);
			System.out.println("2...");
			Thread.sleep(1000);
			System.out.println("1...");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}

	}

	void history() {
		System.out.println("총전적 :" + totCnt + " 회");
		System.out.println("승리 : " + winCnt + "회");
		System.out.println("무승부 : " + drawCnt + "회");
		System.out.println("패배 : " + lossCnt + "회");
	}
}
