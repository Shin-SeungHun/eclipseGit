import java.io.*;
import java.net.*;

public class Round25_Ex13 {
	public static void main(String[] args) throws IOException {
		MulticastSocket ms = new MulticastSocket(); // Multicast�� ��ü��.
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.print("Message = ");
			String msg = in.readLine();
			InetAddress ia = InetAddress.getByName("224.0.0.1");
			// Multicast�� IP�߿��� ������ �ϳ��� ����.
			DatagramPacket data = new DatagramPacket(msg.getBytes(), msg
					.getBytes().length, ia, 28000);
			ms.send(data);
		}
		// ms.close();
	}
}
