import java.net.*;
import java.io.*;

public class Round25_Ex03 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		DataInputStream dis = null;

		System.out.print("���۴�� = ");
		String ip = in.readLine();
		System.out.print("�������� = ");
		String filename = in.readLine();

		File file = new File(filename);
		if (!file.exists()) {
			System.err.println("������ �������� �ʽ��ϴ�.");
			System.exit(-1);
		}
		DatagramSocket ds = new DatagramSocket();
		InetAddress ia = InetAddress.getByName(ip);
		// start ������...
		String str = "start";
		DatagramPacket dp = new DatagramPacket(str.getBytes(),
				str.getBytes().length, ia, 7777);
		ds.send(dp);

		// ���� ������...
		dis = new DataInputStream(new BufferedInputStream(new FileInputStream(
				file)));
		byte[] by = new byte[65508];// �ǹ������� �ַ� 256 byte, 512 byte ������ ����/
		while (true) {
			int xx = dis.read(by, 0, by.length);
			if (xx == -1)
				break;
			dp = new DatagramPacket(by, xx, ia, 7777);
			ds.send(dp);
		}

		// end ������...
		str = "end";
		dp = new DatagramPacket(str.getBytes(), str.getBytes().length, ia, 7777);
		ds.send(dp);

		ds.close();

		System.out.print("���ۿϷ�~!!");
	}
}
