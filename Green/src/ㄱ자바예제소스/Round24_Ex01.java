import java.net.*;

public class Round24_Ex01 {
	public static void main(String[] ar) {
		InetAddress ia = null;
		InetAddress ia1 = null;
		try {
			ia = InetAddress.getByName("www.freelec.co.kr");
			ia1 = InetAddress.getLocalHost();
		} catch (UnknownHostException ee) {
			System.err.println("해당 사이트는 유효하지 않습니다.");
			System.exit(1);
		}
		System.out.println("freelec.co.kr = " + ia.getHostAddress());
		System.out.println("현재 주소 = " + ia1.getHostAddress());
	}
}
