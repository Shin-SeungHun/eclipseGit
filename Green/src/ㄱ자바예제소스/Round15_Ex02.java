package ㄱ자바예제소스;

class A234 extends Thread {
	public void run() {
		System.out.println("\nHere is MyThread!!");
		for (int i = 0; i < 100; i++) {
			for (char ch = 'A'; ch <= 'z'; ch++) {
				System.out.print(ch);
			}
		}
	}
}

public class Round15_Ex02 {
	public static void main(String[] args) {
		System.out.println("Main Thread!!!");
		A234 mt = new A234();
		mt.start();
		for (int i = 1; i < 1000; i++) {
			System.out.print(i);
			if (i % 10 == 0)
				System.out.println();
			else
				System.out.print("\t");
		}
		System.out.println("\nMain Thread Destroy!!");
	}
}
