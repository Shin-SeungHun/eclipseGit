// import ����
import java.rmi.*;
import java.net.*;

// Binding Class ����
public class Round25_Ex21 {
	// main Method
	public static void main(String[] args) {
		try {
			// ���� ��ü ����
			Round25_Ex20 sr = new Round25_Ex20();
			System.out.println("Server Ready...");
			// Server�� ���� ��ü ���
			Naming.rebind("web", sr);
		} catch (RemoteException ee) {
		} catch (MalformedURLException ee) {
		}
	}
}
