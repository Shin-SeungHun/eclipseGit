// import 영역
import java.rmi.*;
import java.net.*;

// Binding Class 정의
public class Round25_Ex21 {
	// main Method
	public static void main(String[] args) {
		try {
			// 원격 객체 선언
			Round25_Ex20 sr = new Round25_Ex20();
			System.out.println("Server Ready...");
			// Server에 원격 객체 등록
			Naming.rebind("web", sr);
		} catch (RemoteException ee) {
		} catch (MalformedURLException ee) {
		}
	}
}
