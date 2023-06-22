import java.net.*;
import java.io.*;

public class Round25_Ex06 {
	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket(11111);
		while (true) {
			DatagramPacket dp = new DatagramPacket(new byte[65508], 65508);
			ds.receive(dp);
			DatagramPacket dp1 = new DatagramPacket(new String(dp.getData())
					.trim().getBytes(), new String(dp.getData()).trim()
					.getBytes().length, dp.getAddress(), 22222);
			ds.send(dp1);
		}
	}
}
