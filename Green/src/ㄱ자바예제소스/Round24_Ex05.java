import java.io.*;
import java.net.*;

public class Round24_Ex05 {
	public static void main(String[] ar) {
		ServerSocket ss = null;
		Socket soc = null;
		try {
			ss = new ServerSocket(12345);
			System.out.println("Server Ready...");
		} catch (IOException ee) {
			System.err.println("해당 포트가 열려 있습니다.");
			System.exit(-1);
		}

		try {
			soc = ss.accept(); // 클라이언트로 부터 들어오는 정보를 기다리는 Method
			System.out.println("접속자 정보 : " + soc.toString());
		} catch (IOException ee) {
		}
	}
}
