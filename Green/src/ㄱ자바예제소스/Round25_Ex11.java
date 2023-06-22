import java.net.*;
import java.io.*;

public class Round25_Ex11 {
	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket(); // 굳이 Port를 지정할 필요없음.
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.print("Message = ");
			String msg = in.readLine();
			InetAddress ia = InetAddress.getByName("222.110.146.255");
			// 255번 Broadcast用. for문을 돌리지 않고도 그룹전체에 보내는 것과 동일한 효과.
			DatagramPacket data = new DatagramPacket(msg.getBytes(), msg
					.getBytes().length, ia, 40000);
			ds.send(data);
		}
		// ds.close();
	}
}
