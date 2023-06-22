package ㄱ자바예제소스;

import java.io.*;

public class Round16_Ex09 {
	public static void main(String[] args) throws IOException {
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				new File(new File("c:\\java\\work"), "kim.txt"))));
		PrintWriter out1 = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		out.println("파일에 적는다. ");
		out1.println("화면에 뿌린다. ");
		out.close();
		out1.close();
	}
}
