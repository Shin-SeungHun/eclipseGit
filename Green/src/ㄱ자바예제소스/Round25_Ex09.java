import java.net.*;
import java.io.*;

public class Round25_Ex09 {
	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket(); // ���� Port�� ������ �ʿ����.
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.print("Message = ");
			String msg = in.readLine();
			for (int i = 1; i < 255; i++) { // 0���� �ϸ� error�� ��~! 0���� ������ ����
											// IP��ȣ...
				InetAddress ia = InetAddress.getByName("124.61.53." + i);
				DatagramPacket data = new DatagramPacket(msg.getBytes(), msg
						.getBytes().length, ia, 30000);
				ds.send(data);
			}
		}
		// ds.close();
	}
}
