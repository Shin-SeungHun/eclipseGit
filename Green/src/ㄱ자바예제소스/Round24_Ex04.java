import java.io.*;
import java.net.*;

public class Round24_Ex04 {
	public static void main(String[] ar) {
		// TCP의 열려져 있는 포트 확인하기
		ServerSocket ss = null;
		for (int i = 1; i <= 65535; i++) {
			try {
				ss = new ServerSocket(i);
				ss.close();
			} catch (IOException ee) {
				System.out.println(i + "번 TCP 포트가 열려 있습니다.");
			}
		}
	}
}
