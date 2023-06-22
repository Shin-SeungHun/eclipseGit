package ㄱ자바예제소스;

import java.io.*;

public class Round16_Ex06 {
	public static void main(String[] args) throws FileNotFoundException,
			IOException {
		/*
		 * FileInputStream fis = new FileInputStream(FileDescriptor.in);
		 * System.out.print(“입력 = “); byte by = fis.read();
		 */
		File file = new File("c:\\java\\work\\abc.txt");
		FileInputStream fis = new FileInputStream(file);
		byte[] by = new byte[65536];
		int count = fis.read(by);
		for (int i = 0; i < count; i++) {
			System.out.println(i + " : " + (char) by[i]);
		}
	}
}
