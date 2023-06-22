package 자바수업04일;

import java.util.Scanner;

public class Study4_클래스5과제 {

	public static void main(String[] args) {
		Car car = new Car();
	}

}

class Car {
	Scanner sc = new Scanner(System.in);
	String carName = "";
	int fuel = 0;
	int speed = 0;
	boolean operation = false;
	int input;
	int MAX = 50;
	int S = 10;

	public Car() {

		System.out.println("<<<<자동차시뮬레이션>>>>");
		System.out.print("자동차 이름: ");
		carName = sc.next();
		System.out.println("\n" + carName + "클래스가 생성되었습니다.\n");
		while (true) {
			System.out.println("[현재 " + carName + " 상태 - 운행전]");
			System.out.println("[시동: " + operation + " 속도: " + speed + " 연료: " + fuel + "]");
			System.out.println("1.연료주입");
			System.out.println("2.시동걸기");
			System.out.println("3.종료");
			System.out.print("선택: ");
			input = sc.nextInt();

			if (input == 1) {
				fuel = MAX;
				System.out.println("\n연료를 주입하였습니다\n");

			} else if (input == 2) {
				if (fuel == 0) {
					System.out.println(" \n연료부터 주입해주세요!\n");
					continue;
				}
				operationOn();// 시동이 걸림
				while (true) {
					int input2;
					System.out.println("[현재 " + carName + " 상태 - 운행중]");
					System.out.println("[시동: " + operation + " 속도: " + speed + " 연료: " + fuel + "]");
					System.out.println();
					System.out.println("1.가속하기");
					System.out.println("2.브레이크");
					System.out.println("3.시동끄기");
					System.out.print("선택: ");
					input2 = sc.nextInt();

					if (input2 == 1) {
						putExcel(); // 엑셀
					} else if (input2 == 2) {
						putBreak(); // 브레이크
					} else if (input2 == 3) {
						operationOff(); // 시동끄기
						break;
					}
				}

			} else if (input == 3) {
				System.out.println("종료");
				break;
			}
		}

	}

	// 운행중상태에서 가속하거나 브레이크 동작할경우 연료가 1씩차감

	// 연료가 0이되면 시동이 false되고 속도도 0으로 강제로 제어

	// 시동걸기
	void operationOn() {
		System.out.println("\n시동이 걸렸습니다!\n");
		operation = true;
	}// 시동이 걸림

	// 시동끄기
	void operationOff() {
		// 선택시 운행전으로 돌아감
		operation = false;
		System.out.println("\n시동이 꺼졌습니다.\n");
	}// 시동이 꺼짐

	// 엑셀
	void putExcel() {
		// 속도가 100초과시 다음문구 출력후 더이상 가속이 되지 않음
		// 100km의 속도가 최대치입니다
		System.out.println("\n차가 가속합니다.\n");
		speedCheck(speed);

	}

	// 브레이크
	void putBreak() {
		// 한번동작시 10km씩 차감
		// 단 0일경우 다음 멘트 출력후 차감안됨
		// 현재속도가 0으로 멈춰있습니다.
		System.out.println("\n차가 감속합니다.\n");
		breakCheck(speed);

	}

	// 연료체크
	void fuelCheck(int fuel) {
		if (fuel <= 0) {

			System.out.println("\n연료 empty! 차가 멈춤 연료넣고 다시 시동거시오\n");
			speed = 0;
			operation = false;
		} else {
			this.fuel--;

		}
	}

	// 속도체크
	void speedCheck(int speed) {
		if (100 < speed) {
			System.out.println("\n100km의 속도가 최대치입니다.\n");
			this.speed = 100;
		} else {
			this.speed += S;
			fuelCheck(fuel);
		}
	}

	// 브레이크 체크
	void breakCheck(int speed) {
		if (0 >= speed) {
			System.out.println("\n현재 멈춰있습니다.\n");
			this.speed = 0;
		} else {
			this.speed -= S;
			fuelCheck(fuel);
		}
	}

	String onOff(boolean onoff) {
		if (onoff) {
			return "켜짐";
		} else {
			return "꺼짐";
		}
	}
}