import java.net.*;
import java.rmi.*;

public class Round25_Ex18 {
	public static void main(String[] args) {
		try {
			Round25_Ex15 fr = (Round25_Ex15) Naming
					.lookup("rmi://124.61.53.124/apple"); // ´ÙÇü¼º...
			String msg = fr.sayHello();
			System.out.println("Message = " + msg);
		} catch (RemoteException ee) {
			ee.printStackTrace();
		} catch (MalformedURLException ee) {
			ee.printStackTrace();
		} catch (NotBoundException ee) {
			ee.printStackTrace();
		}
		
	}
}
