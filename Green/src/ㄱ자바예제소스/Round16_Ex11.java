package ㄱ자바예제소스;

import java.io.*;

public class Round16_Ex11 {
	public static void main(String[] args) throws IOException {
		File dir = new File("c:\\java\\work");
		File file = new File(dir, "ksh.log");
		FileOutputStream fos = new FileOutputStream(file, true);
		BufferedOutputStream bos = new BufferedOutputStream(fos, 1024);
		PrintStream ps = new PrintStream(bos);
		System.setErr(ps); // System.err에 대한 리다이렉션

		System.out.println("출력한다. 화면으로...");
		System.err.println("출력한다. 파일로...");

		System.err.close();
	}
}

