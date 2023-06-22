import java.net.*;

public class Round24_Ex02 {
	public static void main(String[] ar) {
		InetAddress[] ia = null;
		try {
			ia = InetAddress.getAllByName("www.daum.net");
		} catch (UnknownHostException ee) {
			System.err.println("��ȿ���� ���� Domain�Դϴ�.");
			System.exit(1);
		}
		for (int i = 0; i < ia.length; i++) {
			System.out.println("daum.net[" + i + "] = "
					+ ia[i].getHostAddress());
		}
	}
}
