import javax.naming.*;
import java.rmi.*;
import java.util.*;

public class Round25_Ex29 {
	public static void main(String[] args) {
		Hashtable ht = new Hashtable();
		ht.put("java.naming.factory.initial",
				"com.sun.jndi.cosnaming.CNCtxFactory");
		ht.put("java.naming.provider.url", "iiop://124.61.53.124:900");
		try {
			Context ct = new InitialContext(ht);
			Object obj = ct.lookup("iioprmi");
			Round25_Ex26 fr = (Round25_Ex26) obj;
			System.out.println(fr.sayHello("½ÂÇö"));
		} catch (NamingException ee) {
		} catch (RemoteException ee) {
		}
	}
}
