package ㄱ자바예제소스;

import java.io.*;

public class Round16_Ex10 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(new File(
				new File("c:\\java\\work"), "kim.txt")));
		String data = in.readLine();
		in.close();
		System.out.println("Data = " + data);
	}
}
