import java.rmi.*;
import java.net.*;

public class Round25_Ex17 {
	public static void main(String[] args) {
		try {
			Round25_Ex16 sr = new Round25_Ex16();
			System.out.println("Server Ready...");
			Naming.rebind("apple", sr);
		} catch (RemoteException ee) {
			ee.printStackTrace();
		} catch (MalformedURLException ee) {
			ee.printStackTrace();
		}
	}
}
