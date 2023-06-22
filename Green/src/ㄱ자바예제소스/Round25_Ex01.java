import java.net.*;
import java.io.*;

public class Round25_Ex01 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		DatagramSocket ds = new DatagramSocket();//우체통
		while (true) {
			System.out.print("보낼 물건 = ");
			String msg = in.readLine();
			for(int i = 2; i < 254; i++){
				InetAddress ia = InetAddress.getByName("124.61.53." + i);
				DatagramPacket dp = new DatagramPacket(//소포
						msg.getBytes(), msg.getBytes().length, ia, 4444);
				ds.send(dp);
			}
			System.out.println("전송완료~!!");
		}
	}
}
