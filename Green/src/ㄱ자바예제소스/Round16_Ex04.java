package ㄱ자바예제소스;


import java.io.*;

public class Round16_Ex04 {
	public static void main(String[] args) {
		// 특정 폴더에서
		// 확장자명 .java만 골라서
		// 출력하도록 한다.
		// ex)
		// 1. CalcTest.java
		// 2. ExceptionTest.java
		// 3. MyException.java
		// 4. ...
		// ... 등등... 이런식으로 출력되도록한다.
		File f = new File("C:\\java\\Green\\src\\ㄱ자바예제소스");
		// String[] files = f.list();
		File[] files = f.listFiles();
		for (int i = 0, j = 0; i < files.length; i++) {
			if (files[i].getName().endsWith(".java")) {
				System.out.println(j++ + 1 + " : " + files[i].getName());
			}
		}
	}
}
