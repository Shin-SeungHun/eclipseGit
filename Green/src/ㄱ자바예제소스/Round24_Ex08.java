import java.io.*;
import java.net.*;

public class Round24_Ex08 {
	public static void main(String[] ar) {
		InetAddress ia = null;
		Socket soc = null;
		PrintWriter out = null;
		try {
			ia = InetAddress.getByName("218.51.174.232");
			soc = new Socket(ia, 12345);
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(soc
					.getOutputStream())));
		} catch (IOException ee) {
			System.err.println("���� ���� : " + ee.toString());
			System.exit(-1);
		}

		out.println("�����" + "\n"); // "\n"�� Ư�� ������ ������ ���� ��Ÿ���� �����̴�.
		out.flush();
		out.close();
	}
}
