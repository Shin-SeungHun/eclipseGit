import java.net.*;
import java.io.*;

public class Round25_Ex07 {
	public static void main(String[] args) throws IOException {
		// command는 아래와 같이 입력...
		// 1. -o time -a 222.110.146.38
		// 2. -o date -a 222.110.146.38
		// 3. -o datetime -a 222.110.146.38
		DatagramSocket ds = new DatagramSocket(12345);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.print("command : ");
			String command = in.readLine();
			DatagramPacket dp = new DatagramPacket(command.getBytes(), command
					.getBytes().length, InetAddress.getByName(command
					.substring(command.lastIndexOf("-a") + 2).trim()), 9000);
			ds.send(dp);
			DatagramPacket dp1 = new DatagramPacket(new byte[65508], 65508);
			ds.receive(dp1);
			System.out.println(new String(dp1.getData()).trim());
		}
	}
}
