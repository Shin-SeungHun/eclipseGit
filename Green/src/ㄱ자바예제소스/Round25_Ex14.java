import java.net.*;
import java.io.*;

public class Round25_Ex14 {
	public static void main(String[] args) throws IOException {
		MulticastSocket ms = new MulticastSocket(28000);
		ms.joinGroup(InetAddress.getByName("224.0.0.1"));
		// Multicast Group�� �����ؾ� �Ѵ�.
		while (true) {
			byte[] by = new byte[65508];
			DatagramPacket data = new DatagramPacket(by, by.length);
			ms.receive(data);
			InetAddress ia = data.getAddress(); // �ּҸ� ��.
			String str = new String(data.getData()).trim(); // Data�� ��.
			System.out.println(ia.getHostName() + " ==> " + str);
		}
		// ms.leaveGroup(InetAddress.getByName("224.126.63.100");
		// ms.close();
	}
}
