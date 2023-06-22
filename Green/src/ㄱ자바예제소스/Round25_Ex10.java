import java.net.*;
import java.io.*;

public class Round25_Ex10 {
	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket(30000);
		byte[] by = new byte[65508];
		while (true) {
			DatagramPacket data = new DatagramPacket(by, by.length);
			ds.receive(data);
			InetAddress ia = data.getAddress(); // ÁÖ¼Ò¸¦ ¾ò¾î³¿.
			String str = new String(data.getData()).trim(); // Data¸¦ ¾ò¾î³¿.
			System.out.println(ia.getHostName() + " ==> " + str);
		}
		// ds.close();
	}
}
