import java.net.*;
import java.io.*;

public class Round25_Ex02 {
	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket(4444);
		while (true) {
			byte[] data = new byte[65508];
			DatagramPacket dp = new DatagramPacket(data, data.length);
			ds.receive(dp);
			System.out.println(dp.getAddress().getHostAddress() + " >> "
					+ new String(dp.getData()).trim());
		}
	}
}
