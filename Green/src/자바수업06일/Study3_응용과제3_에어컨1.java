package 자바수업06일;

import java.util.Scanner;

public class Study3_응용과제3_에어컨1 {

	public static void main(String[] args) {
		Aircon a = new Aircon();
		Thread th = new Thread(a);
		th.start();
		a.airconMain();
	}

}

/*
 * 1.스레드 start()를 사용
 * 
 * 2.설정온도는 최저 18도~최고28도 사이만 입력가능
 * 
 * 3.에어컨가동시 에어컨온도는 0~1사이 랜덤으로 생성해서 온도=온도-랜던값으로 누적해서 빼시오 1초에 한번씩 누적해서 빼면됨
 * 
 * 4.에어컨 중당시 현재온도 변경된 부분까지 적용하기
 * 
 * 5.에어컨 가동시 가동기능은 에어컨 중단으로 변경
 */
class Aircon implements Runnable {
	Scanner sc = new Scanner(System.in);
	int input;
	int currentTemp = 28; // 현재온도
	int settingTemp = 0; // 세팅온도
	boolean onCheck = false;
	

	public void airconMain() {

		System.out.println("[[ 에어컨 시스템 ]]");
		while (true) {

			System.out.println("현재온도: " + currentTemp + "도");
			System.out.println("설정온도: " + settingTemp + "도");

			System.out.println("1.온도설정");
			System.out.println(onOff());
			System.out.println("3.종료");
			System.out.print("선택: ");
			input = sc.nextInt();

			if (input == 1) {
				settings();
			} else if (input == 2) {
				
				if (onCheck == true) {
					System.out.println("전원이 꺼졌습니다. 중단");
					onCheck = false;
			
				} else if (settingCheck() == true) {
					operate();
				
				}
			
			} else if (input == 3) {
				System.out.println("종료");
				break;
			}
		}

	}

	public boolean settingCheck() {
		if (settingTemp == 0) {
			System.out.println("\n설정온도값을 넣으시오\n");
			return false;
		}
		return true;
	}

	public void settings() {
		do {
			System.out.print("\n설정온도: ");
			settingTemp = sc.nextInt();
			if (settingTemp < 18 || 28 < settingTemp) {
				System.out.println("설정온도는 최저18도 ~ 최고28도 사이만 입력가능");
			}
		} while (settingTemp < 17 || 29 < settingTemp);
		System.out.println("온도가 설정되었습니다. 에어컨 가동가능");
		System.out.println();

	}

	public void operate() {
		onCheck = true;
	}

//	public void stop() {
//		System.out.println("에어컨이 중단됩니다.");
//
//		System.out.println("설정온도에 맞춰졌습니다.");
//	}

	public String onOff() {
		if (onCheck == true) {
			return "2.에어컨중단";
		} else {
			return "2.에어컨가동";
		}
	}

	@Override
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
					System.out.println("<<현재온도" + currentTemp + ">>");
					Thread.sleep(1000);

				} catch (InterruptedException e) {
				}

				if (currentTemp <= settingTemp) {
					onCheck = false;

					System.out.println("<< 설정온도에 맞춰졌습니다.>>");
				}
			}

		}

	}

}