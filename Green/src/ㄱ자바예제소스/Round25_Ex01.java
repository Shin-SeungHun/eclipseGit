import java.net.*;
import java.io.*;

public class Round25_Ex01 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		DatagramSocket ds = new DatagramSocket();//��ü��
		while (true) {
			System.out.print("���� ���� = ");
			String msg = in.readLine();
			for(int i = 2; i < 254; i++){
				InetAddress ia = InetAddress.getByName("124.61.53." + i);
				DatagramPacket dp = new DatagramPacket(//����
						msg.getBytes(), msg.getBytes().length, ia, 4444);
				ds.send(dp);
			}
			System.out.println("���ۿϷ�~!!");
		}
	}
}
