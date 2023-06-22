import java.io.*;
import java.net.*;
import java.text.*;
import java.util.*;

public class Round25_Ex08 {
	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket(9000);
		while (true) {
			DatagramPacket dp = new DatagramPacket(new byte[65508], 65508);
			ds.receive(dp);

			String str = new String(dp.getData()).trim();
			str = str.substring(str.indexOf("-o") + 2, str.lastIndexOf("-a"))
					.trim();

			SimpleDateFormat format = null;
			String datestr = "";
			if (str.equals("date")) {
				format = new SimpleDateFormat("yyyy-MM-dd");
			} else if (str.equals("time")) {
				format = new SimpleDateFormat("HH-mm-ss");
			} else if (str.equals("datetime")) {
				format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
			}
			datestr = format.format(new Date());

			DatagramPacket dp1 = new DatagramPacket(datestr.getBytes(), datestr
					.getBytes().length, dp.getAddress(), 12345);
			ds.send(dp1);
		}
	}
}
