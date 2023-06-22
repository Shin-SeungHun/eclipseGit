import java.io.*;
import java.net.*;

public class Round24_Ex06 {
	public static void main(String[] ar) {
		InetAddress ia = null;
		Socket soc = null;
		try {
			ia = InetAddress.getByName("218.51.174.232");
			soc = new Socket(ia, 12345);
		} catch (IOException ee) {
			System.err.println("접속 오류 : " + ee.toString());
			System.exit(-1);
		}
	}
}
