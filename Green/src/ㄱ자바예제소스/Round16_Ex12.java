package ㄱ자바예제소스;

import java.io.*;

class Round16_Ex12_Sub implements Serializable {
	int x;

	int y;
}

public class Round16_Ex12 {
	public static void main(String[] args) throws IOException {
		Round16_Ex12_Sub ap = new Round16_Ex12_Sub();
		ap.x = 100;
		ap.y = 200;

		File dir = new File("c:\\java\\work");
		File file = new File(dir, "object.txt");
		FileOutputStream fos = new FileOutputStream(file);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(ap);
		oos.close();

		// 만약 객체단위의 출력을 하지 못한다면 다음과 같이 출력해야 한다.
		/*
		 * File f = new File("aaa.txt"); FileOutputStream fos = new
		 * FileOutputStream(f); BufferedOutputStream bos = new
		 * BufferedOutputStream(fos); DataOutputStream dos = new
		 * DataOutputStream(bos); dos.writeInt(ap.x); dos.writeInt(ap.y);
		 * dos.close();
		 */
	}
}
