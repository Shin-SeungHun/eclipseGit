package ㄱ자바예제소스;

import java.util.*;

class A66 extends Thread {
	public void run() {
		while(true) {
			Date date = new Date();
//			java.util.Date date = new java.util.Date();
			System.out.println("date = " + date.toString());
			try{
				Thread.sleep(1000);
			}catch(InterruptedException ie) {}
		}
	}
}

class B66 extends Thread {
	public void run() {
		for(int i = 0; i < 1000; i++) {
			System.out.println(i);
			try{
				Thread.sleep(400);
			}catch(InterruptedException ie) {}
		}
	}
}

public class Round15_Ex06 {
	public static void main(String[] args) {
		System.out.println("Main Start!!");
		A66 mt = new A66();
		B66 ms = new B66();
		mt.setDaemon(false);
		ms.setDaemon(false);
		mt.start();
		ms.start();
		System.out.println("Main End!!");
	}
}
