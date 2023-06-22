package 자바수업04일;

import java.util.Scanner;

public class Study1_클래스과제_Car클래스_2단계 {
	public static void main(String[] args) {
		Car2 car = new Car2();
	}
}

class Car2 {
	Scanner sc = new Scanner(System.in);
	String carName = ""; // 자동차이름
	int fuel = 0; // 연료
	int speed = 0; // 현재속도
	boolean accOnOff = false; // 시동상태

	Car2() {
		int sel;
		System.out.println("<<<<자동차시뮬레이션>>>>");
		System.out.print("자동차이름:");
		carName = sc.next();
		System.out.println("\n" + carName + " 클래스가 생성되었습니다.\n");
		while (true) {
			System.out.println("[ 현재 벤츠 상태 - 운행전   ]");
			System.out.println("[시동: " + accOnOff + " 속도:" + speed + " 연료:" + fuel + "]");
			System.out.println("1.연료주입");
			System.out.println("2.시동걸기");
			System.out.println("3.종료");
			System.out.print("선택: ");
			sel = sc.nextInt();
			
			if (sel == 1) {
				System.out.println("\n연료가 주입되었습니다.\n");
				fuel = 20;
			
			} else if (sel == 2) {
				
				if (fuel == 0) {
					System.out.println("\n연료부터 주입해주세요!\n");
					continue;// 이밑으로 } 닫아질때까지 생략 skip!!
				}
				accOn();// 시동이 걸림
				while (true) {
					int sel2;
					System.out.println("[ 현재 벤츠 상태 - 운행중   ]");
					System.out.println("[시동: " + accOnOff + " 속도:" + speed + " 연료:" + fuel + "]");
					System.out.println("1.가속하기");
					System.out.println("2.브레이크");
					System.out.println("3.시동끄기");
					System.out.print("선택: ");
					sel2 = sc.nextInt();
					if (sel2 == 1) {
						go();
					} else if (sel2 == 2) {
						stop();
					} else if (sel2 == 3) {
						accOff();
						break;
					}
				}

			} else if (sel == 3) {
				System.out.println("프로그램종료.");
				break;
			}
		}
	}

	// 시동걸기
	void accOn() {
		System.out.println("\n시동이 걸렸습니다.\n");
		accOnOff = true;
	}// 시동이 걸림
	// 시동끄기

	void accOff() {
		System.out.println("\n시동이 꺼졌습니다.\n");
		accOnOff = false;
	}// 시동이 꺼짐
	// 엑셀밟기

	void go() {
		System.out.println("\n차가 가속합니다.\n");
		speedCheck(speed);
	}

	// 브레이크밟기
	void stop() {
		System.out.println("\n차가 감속합니다.\n");
		breakCheck(speed);
	}

	// 브레이크체크
	void breakCheck(int speed) {
		if (speed <= 0) {
			System.out.println("\n 현재 멈춰있습니다.\n");
			this.speed = 0;
		} else {
			this.speed -= 10;
			fuelCheck(fuel);
		}

	}

	// 속도체크
	void speedCheck(int speed) {
		if (speed > 100) {
			System.out.println("\n 100km의 속도가 최대치입니다!!\n");
			this.speed = 100;
		} else {
			this.speed += 10;
			fuelCheck(fuel);
		}

	}

	// 연료체크
	void fuelCheck(int fuel) {
		if (fuel <= 0) {
			System.out.println("\n연료 엥꼬! 차가 멈춤 연료넣고 다시 시동거시오!\n");
			speed = 0;
			accOnOff = false;
		} else {
			this.fuel--;
		}

	}
}
