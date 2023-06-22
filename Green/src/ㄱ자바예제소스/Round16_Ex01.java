package ㄱ자바예제소스;

import java.io.*;

public class Round16_Ex01 {
	public static void main(String[] args) {
		File f = new File("c:\\java\\work");
		if (f.exists())
			f.delete();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException ie) {
		}
		System.out.println("시점!!");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException ie) {
		}
		if (!f.exists())
			f.mkdir();

	}
}
