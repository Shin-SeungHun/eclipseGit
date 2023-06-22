import java.io.*;
import java.net.*;

public class Round25_Ex04 {
	public static void main(String[] args) throws IOException {
		DatagramSocket soc = new DatagramSocket(7777);
		System.out.println("���۹��� �غ� �Ϸ�!");
		File file = null;
		DataOutputStream dos = null;

		while (true) {
			DatagramPacket dp = new DatagramPacket(new byte[65508], 65508);
			soc.receive(dp);
			String str = new String(dp.getData()).trim();
			if (str.equalsIgnoreCase("start")) {// ��ҹ��ڸ� �������� �ʰ� start�� ������...
				System.out.println("���۵ǰ� ����!");
				file = new File("imsi.ksh");
				dos = new DataOutputStream(new BufferedOutputStream(
						new FileOutputStream(file)));
			} else if (str.equalsIgnoreCase("end")) {
				System.out.println("���� �Ϸ�!");
				dos.close();
				break;
			} else if (file != null) {
				dos.write(str.getBytes(), 0, str.getBytes().length);
			}
		}
	}
}
