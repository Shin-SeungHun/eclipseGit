import java.io.*;
import java.net.*;

public class Round24_Ex04 {
	public static void main(String[] ar) {
		// TCP�� ������ �ִ� ��Ʈ Ȯ���ϱ�
		ServerSocket ss = null;
		for (int i = 1; i <= 65535; i++) {
			try {
				ss = new ServerSocket(i);
				ss.close();
			} catch (IOException ee) {
				System.out.println(i + "�� TCP ��Ʈ�� ���� �ֽ��ϴ�.");
			}
		}
	}
}
