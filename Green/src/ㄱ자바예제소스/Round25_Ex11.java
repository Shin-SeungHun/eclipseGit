import java.net.*;
import java.io.*;

public class Round25_Ex11 {
	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket(); // ���� Port�� ������ �ʿ����.
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.print("Message = ");
			String msg = in.readLine();
			InetAddress ia = InetAddress.getByName("222.110.146.255");
			// 255�� Broadcast��. for���� ������ �ʰ� �׷���ü�� ������ �Ͱ� ������ ȿ��.
			DatagramPacket data = new DatagramPacket(msg.getBytes(), msg
					.getBytes().length, ia, 40000);
			ds.send(data);
		}
		// ds.close();
	}
}
