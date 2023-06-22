import java.net.*;
import java.io.*;

public class Round25_Ex09 {
	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket(); // 굳이 Port를 지정할 필요없음.
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.print("Message = ");
			String msg = in.readLine();
			for (int i = 1; i < 255; i++) { // 0부터 하면 error가 남~! 0번은 보낼수 없는
											// IP번호...
				InetAddress ia = InetAddress.getByName("124.61.53." + i);
				DatagramPacket data = new DatagramPacket(msg.getBytes(), msg
						.getBytes().length, ia, 30000);
				ds.send(data);
			}
		}
		// ds.close();
	}
}
