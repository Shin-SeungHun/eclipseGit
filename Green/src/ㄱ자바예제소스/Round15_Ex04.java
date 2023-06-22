class A4 extends Thread {
	public void run() {
		System.out.println("Here is a Class A4!!");
	}
}
class B4 implements Runnable {
	public void run() {
		System.out.println("Here is a Class B4!!");
	}
}
public class Round15_Ex04 {
	public static void main(String[] args) {
		A4 ap = new A4();
		Thread bp = new Thread(new B4());
		ap.setPriority(3);
		bp.setPriority(8);
		ap.start();
		bp.start();
	}
}
