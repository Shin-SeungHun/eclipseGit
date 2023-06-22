import java.io.*;
import java.rmi.*;
import java.net.*;

public class Round25_Ex22 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.print("������ IP = ");
			String ip = in.readLine();
			try {
				Round25_Ex19 fr = (Round25_Ex19) Naming.lookup("rmi://" + ip
						+ "/web");
				System.out.print("��� ����Ʈ = ");
				String addr = in.readLine();
				fr.openWeb(addr);
			} catch (RemoteException ee) {
			} catch (MalformedURLException ee) {
			} catch (NotBoundException ee) {
			}
		}
	}
}
