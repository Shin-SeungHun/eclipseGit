import java.io.*;
import java.net.*;

public class Round25_Ex05 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket ds = new DatagramSocket(22222);

		while (true) {
			System.out.print("¸Þ¼¼Áö = ");
			String msg = in.readLine();
			DatagramPacket dp = new DatagramPacket(msg.getBytes(), msg
					.getBytes().length, InetAddress.getByName(args[0]), 11111);
			ds.send(dp);

			DatagramPacket dp1 = new DatagramPacket(new byte[65508], 65508);
			ds.receive(dp1);
			System.out.println(new String(dp1.getData()).trim());
		}
	}
}
