package ㄱ자바예제소스;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Round16_Ex13 {
	public static void main(String[] args) throws IOException {
		File dir = new File("c:\\java\\work");
		File file = new File(dir, "object.txt");
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		ObjectInputStream ois = new ObjectInputStream(bis);
		Object obj = null;
		try {
			obj = ois.readObject();
		} catch (ClassNotFoundException cnfe) {
		}
		ois.close();
		Round16_Ex12_Sub ap = (Round16_Ex12_Sub) obj;
		System.out.println("x = " + ap.x);
		System.out.println("y = " + ap.y);
	}
}
