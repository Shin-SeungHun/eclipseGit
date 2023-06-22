package 자바수업06일;

public class Study1_스레드연습2 {

	public static void main(String[] args) {
		A2 a1 = new A2();
		Thread th1 = new Thread(a1);
		B2 b1 = new B2();
		Thread th2 = new Thread(b1);
		th1.start();
		th2.start();
	}

}

class A2 implements Runnable {
	public void run() {
		for (int i = 0; i < 1000; i++) {
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {

			}
			System.out.println("인터페이스....A2=" + i);
		}
	}
}

class B2 implements Runnable {
	public void run() {
		for (int i = 0; i < 1000; i++) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {

			}
			System.out.println("여기는..B2=" + i);
		}
	}
}
