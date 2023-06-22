import java.rmi.*;
import java.util.*;
import javax.naming.*;

public class Round25_Ex28 {
	public static void main(String[] args) {
		try {
			Hashtable ht = new Hashtable();
			ht.put("java.naming.factory.initial",
					"com.sun.jndi.cosnaming.CNCtxFactory");
			ht.put("java.naming.provider.url", "iiop://124.61.53.124:900");
			Context ct = new InitialContext(ht);
			// Naming 클래스랑 비슷하다.
			Round25_Ex27 sr = new Round25_Ex27();
			ct.rebind("iioprmi", sr);
			System.out.println("Server Ready...");
		} catch (NamingException ee) {
		} catch (RemoteException ee) {
		}
	}
}
