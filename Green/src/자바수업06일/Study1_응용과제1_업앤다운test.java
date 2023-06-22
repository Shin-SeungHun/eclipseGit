package 자바수업06일;

import java.util.Scanner;

public class Study1_응용과제1_업앤다운test {

	public static void main(String[] args) {
		new UpAndDown();

	}

}

/*
 * 3초안에 답을 해야함 안그럼 패배 초에 한번씩 321 카운트 표시 5회이내에 맞추면 승리 5회 초과시 패배로 게임종료
 */
class UpAndDown {
	Scanner sc = new Scanner(System.in);
	static int input;
	static int totCnt = 0, winCnt = 0, losCnt = 0;

	int comNumber;
	int gameCnt = 5;

	CountDown cd = new CountDown();
	Thread th = new Thread(cd);

	public UpAndDown() {
		th.start();
		while (true) {
			System.out.println("1.게임시작");
			System.out.println("2.결과");
			System.out.println("3.종료");
			System.out.print("선택: ");
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
//		comNumber = (int) (Math.random() * 50 + 1); // 컴퓨터 숫자생성..
		comNumber = 1;
		CountDown.check = true; // 카운트다운 시작
		System.out.println("답: ");
		int myNumber = sc.nextInt();

		if (comNumber == myNumber) {
			if (gameCnt > 0) {
				System.out.println("정답입니다. 승리!");
				CountDown.check = false;
				CountDown.secondCheck = 3;
				winCnt++;
				totCnt++;
			}
		} else {
			System.out.println("틀렸습니다. 패배!");
			CountDown.check = false;
			CountDown.secondCheck = 3;
			totCnt++;
			losCnt++;
		}

	}

	public void history() {
		System.out.println("총 시도횟수: " + totCnt + "회");
		System.out.println("승리(5회이내정답): " + winCnt + "회");
		System.out.println("패배(5회 초과시): " + losCnt + "회\n");
	}

	

}

class CountDown implements Runnable {
	static boolean check = false;
	static int secondCheck = 3;

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(100);

			} catch (InterruptedException e) {
			}

			if (check == true) {
				try {

					System.out.println("\n3..."+secondCheck);
					Thread.sleep(1000);
					secondCheck--;
					if (check == false) {
						secondCheck = 3;
						continue;
					}
					System.out.println("2.."+secondCheck);
					Thread.sleep(1000);
					secondCheck--;
					if (check == false) {
						secondCheck = 3;
						continue;
					}
					System.out.println("1."+secondCheck);
					Thread.sleep(1000);
					secondCheck--;
					if (check == false) {
						secondCheck = 3;
						continue;
					}

					if (secondCheck == 0) {
						check = false;
						System.out.println("시간초과..패배!");
						UpAndDown.totCnt++;
						UpAndDown.losCnt++;
						secondCheck = 3;// 시간체크 초기화
					}
				} catch (InterruptedException e) {
				}
			}
		}
	}

}
