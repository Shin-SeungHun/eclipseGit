package ㄱ자바예제소스;

import java.io.*;

public class Round04_Ex05 {
	public static void main(String[] ar) throws IOException {
		byte[] bb = { 65, 66, 67, 68 };
		char[] cc = {'a', 'b'};
		System.out.write(bb);
		System.out.println();
		System.out.println((char) bb[0] + "" + (char) bb[1] + "" + (char) bb[2] + "" + (char) bb[3]);
		System.out.println();
		char test = 44277;
		System.out.println(test);
	}
}
