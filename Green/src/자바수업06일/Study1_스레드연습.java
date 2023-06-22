package 자바수업06일;

public class Study1_스레드연습 {

	public static void main(String[] args) {
		A1 a1 = new A1();
		B1 b1 = new B1();
		a1.start();
		b1.start();
	}

}

class A1 extends Thread {
	public void run() {
		for (int i = 0; i < 1000; i++) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {

			}
			System.out.println("월요일이군....=" + i);
		}
	}
}

class B1 extends Thread {
	public void run() {
		for (int i = 0; i < 1000; i++) {
			try {
				sleep(100);
			} catch (InterruptedException e) {

			}
			System.out.println("자바수업go=" + i);
		}
	}
}
