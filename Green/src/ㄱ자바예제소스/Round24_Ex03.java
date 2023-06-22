import java.io.*;
import java.net.*;

public class Round24_Ex03 {
	public static void main(String[] ar) {
		InetAddress ia = null;
		Socket soc = null;
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			ia = InetAddress.getByName("www.freelec.co.kr");
			soc = new Socket(ia, 80);
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(soc
					.getOutputStream())));
			in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
		} catch (IOException ee) {
			System.err.println("연결 오류 : " + ee.toString());
			System.exit(-1);
		}

		try {
			out
					.println("GET http://www.freelec.co.kr/index.asp HTTP/1.0\r\n\n");
			out.flush();// 버퍼를 비운다.

			// 서버에서 응답해 올 데이터를 입력 받는다.
			while (true) {
				String str = in.readLine();
				if (str == null) {// 더 이상 읽어올 데이터가 없다면
					break;
				}
				System.out.println(str);
			}
			soc.shutdownOutput();
			soc.shutdownInput();
			soc.close();
		} catch (IOException ee) {
		}
	}
}
