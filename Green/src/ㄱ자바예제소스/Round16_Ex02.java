package ㄱ자바예제소스;

import java.io.*;

public class Round16_Ex02 {
	public static void main(String[] args) {
		File f = new File("c:\\java\\work");
		if (!f.exists())
			f.mkdir();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException ie) {
		}
		File f1 = new File(f, "abc.txt");
		if (!f1.exists())
			try {
				f1.createNewFile();
			} catch (IOException io) {
			}
		if (f1.canWrite())
			f1.setReadOnly();
	}
}
