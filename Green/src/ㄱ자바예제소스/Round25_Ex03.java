import java.net.*;
import java.io.*;

public class Round25_Ex03 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		DataInputStream dis = null;

		System.out.print("전송대상 = ");
		String ip = in.readLine();
		System.out.print("전송파일 = ");
		String filename = in.readLine();

		File file = new File(filename);
		if (!file.exists()) {
			System.err.println("파일이 존재하지 않습니다.");
			System.exit(-1);
		}
		DatagramSocket ds = new DatagramSocket();
		InetAddress ia = InetAddress.getByName(ip);
		// start 보내고...
		String str = "start";
		DatagramPacket dp = new DatagramPacket(str.getBytes(),
				str.getBytes().length, ia, 7777);
		ds.send(dp);

		// 내용 보내고...
		dis = new DataInputStream(new BufferedInputStream(new FileInputStream(
				file)));
		byte[] by = new byte[65508];// 실무에서는 주로 256 byte, 512 byte 단위로 보냄/
		while (true) {
			int xx = dis.read(by, 0, by.length);
			if (xx == -1)
				break;
			dp = new DatagramPacket(by, xx, ia, 7777);
			ds.send(dp);
		}

		// end 보내고...
		str = "end";
		dp = new DatagramPacket(str.getBytes(), str.getBytes().length, ia, 7777);
		ds.send(dp);

		ds.close();

		System.out.print("전송완료~!!");
	}
}
