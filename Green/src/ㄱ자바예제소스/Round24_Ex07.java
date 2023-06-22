import java.io.*;
import java.net.*;

public class Round24_Ex07 {
	public static void main(String[] ar) {
		ServerSocket ss = null;
		Socket soc = null;
		try {
			ss = new ServerSocket(12345);
			System.out.println("Server Ready...");
		} catch (IOException ee) {
			System.err.println("�ش� ��Ʈ�� ���� �ֽ��ϴ�.");
			System.exit(-1);
		}

		try {
			soc = ss.accept(); // Ŭ���̾�Ʈ�� ���� ������ ������ ��ٸ��� Method
			System.out.println("������ ���� : " + soc.toString());
			BufferedReader in = new BufferedReader(new InputStreamReader(soc
					.getInputStream()));
			String str = in.readLine();
			System.out.println("���۵� ���� : " + str);
			soc.close();
		} catch (IOException ee) {
		}
	}
}
