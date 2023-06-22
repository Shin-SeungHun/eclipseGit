import java.util.*;
import java.rmi.*;
import java.rmi.server.*;

public class Round25_Ex32 extends UnicastRemoteObject implements Round25_Ex30 {
	private Vector user;

	public Round25_Ex32() throws RemoteException {
		user = new Vector();
	}

	public void setClient(Round25_Ex31 cf) throws RemoteException {
		user.add(cf);
	}

	public void setDate() throws RemoteException {
		for (int i = 0; i < user.size(); i++) {
			Round25_Ex31 cf = (Round25_Ex31) user.elementAt(i);
			cf.setScreenDate(new Date().toString());
		}
	}

	public static void main(String[] args) throws Exception {
		Runtime rt = Runtime.getRuntime();
		rt.exec("c:\\java\\jdk1.5\\bin\\rmiregistry.exe");
		Round25_Ex32 ss = new Round25_Ex32();
		Naming.rebind("both", ss);
		System.out.println("Server Ready...");
	}
}
