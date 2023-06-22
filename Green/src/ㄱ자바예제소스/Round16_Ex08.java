package ㄱ자바예제소스;

import java.io.*;

public class Round16_Ex08 {
	public static void main(String[] args) {
		DataInputStream dis1 = null;
		try {
			dis1 = new DataInputStream(new BufferedInputStream(
					new FileInputStream(new File(new File("c:\\java\\work"),
							"kimsh.txt"))));
		} catch (FileNotFoundException fnfe) {
		}
		int a = 0;
		double b = 0.0;
		byte[] c = null;
		try {
			a = dis1.readInt();
			b = dis1.readDouble();
			c = new byte[10];
			dis1.read(c);
			dis1.close();
		} catch (IOException ie) {
		}

		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + new String(c));
	}
}
