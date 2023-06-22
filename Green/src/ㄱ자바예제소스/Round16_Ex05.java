package ㄱ자바예제소스;


import java.io.*;

public class Round16_Ex05 {
	public static void main(String[] args) {
		File file = new File("c:\\java\\work\\abc.txt");
		try {
			FileOutputStream fos = new FileOutputStream(FileDescriptor.out);
			FileOutputStream fos1 = new FileOutputStream(file);
			byte[] data = { 66, 68, 70, 72, (byte) '!' };
//			fos.write(data);
			fos1.write(data);
			// fos.close();
			// fos1.close();
		} catch (FileNotFoundException fnfe) {
			System.err.println("파일을 못찾겠다.");
			System.exit(1);
		} catch (IOException io) {
			System.err.println("파일 입출력 에러!!");
			System.exit(1);
		}
		System.out.println("실행끝..!!");
	}
}
