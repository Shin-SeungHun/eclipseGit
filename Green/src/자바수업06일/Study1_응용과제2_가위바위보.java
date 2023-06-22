package 자바수업06일;

import java.util.Scanner;

public class Study1_응용과제2_가위바위보 {

	public static void main(String[] args) {

		new Rck();
	}

}

class Rck {
	Scanner sc = new Scanner(System.in);
	String myHand;
	int input;
	int totCnt = 0, winCnt = 0, lossCnt = 0, drawCnt = 0;

	public Rck() {

		while (true) {
			System.out.println("1.게임시작");
			System.out.println("2.결과");
			System.out.println("3.종료");
			System.out.print("선택:");
			input = sc.nextInt();

			if (input == 1) {
				gameStart();
			} else if (input == 2) {
				history();
			} else if (input == 3) {
				System.out.println("종료");
				break;
			}
		}
	}

	public void gameStart() {
		System.out.println("컴퓨터가 생각중입니다.");
		CountDown.check = true;
		System.out.println("내 선택: ");
		String myHand = sc.next();
		int comRand = (int) (Math.random() * 3 + 1);
		String comMent = com(comRand);
		ing();

		if (myHand.equals("가위")) {
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
		} else if (myHand.equals("바위")) {
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
		} else if (myHand.equals("보")) {
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
		System.out.println("컴퓨터 : " + comMent + "  vs 나 : " + myHand);
	}

	public void resultMent(String ment) {
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

	public void ing() {
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

	public void history() {
		System.out.println("총전적: " + totCnt + "회");
		System.out.println("승리: " + winCnt + "회");
		System.out.println("무승부: " + drawCnt + "회");
		System.out.println("패배: " + lossCnt + "회");
	}
}
