package 자바수업06일;

import java.util.Scanner;

public class Study3_응용과제3_에어컨 {
	public static void main(String[] args) {
		Aircon1 a = new Aircon1();
		Thread th = new Thread(a);
		th.start();
		a.airconMain();
	}
}

class Aircon1 implements Runnable {
	Scanner sc = new Scanner(System.in);
	int sel;
	int currentTemp = 28;// 현재온도
	int settingTemp = 0;// 설정온도
	boolean onCheck = false;

	void airconMain() {

		System.out.println("[[ 에어컨 시스템 ]]");
		while (true) {

			System.out.println("[[ 현재온도: " + currentTemp + "도 ]]");
			System.out.println("[[ 설정온도: " + settingTemp + "도 ]]");
			System.out.println("1.온도설정");
			System.out.println(airConMent());
			System.out.println("3.종료");
			System.out.print("선택:");
			sel = sc.nextInt();

			if (sel == 1) {
				setting();
			} else if (sel == 2) {

				if (onCheck == true) {
					System.out.println("전원이 꺼졌습니다. 중단");
					onCheck = false;
				} else if (settingCheck() == true) {
					airconStart();
				}
			} else if (sel == 3) {
				System.out.println("프로그램종료.");
				break;
			}

		}
	}

	String airConMent() {
		if (onCheck == true) {
			return "2.에어컨중단";
		} else {
			return "2.에어컨가동";
		}
	}

	void airconStart() {
		onCheck = true;
	}

	boolean settingCheck() {
		if (settingTemp == 0) {
			System.out.println("\n설정온도값을 넣으시오.\n");
			return false;
		}
		return true;
	}

	void setting() {
		do {
			System.out.print("\n설정온도:");
			settingTemp = sc.nextInt();
		} while (settingTemp < 18 || settingTemp > 28);
		System.out.println("온도가설정되었습니다. 에어컨가동가능.");
		System.out.println();
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}

			if (onCheck == true) {
				int randTemp = (int) (Math.random() * 2);
				currentTemp -= randTemp;
				try {
					System.out.println("<< 현재온도:" + currentTemp + " >>");
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}

				if (currentTemp <= settingTemp) {
					onCheck = false;// 에어컨 중지.

					System.out.println("<< 설정온도에 맞춰졌습니다.>>");
				}
			}

		}
	}

}
