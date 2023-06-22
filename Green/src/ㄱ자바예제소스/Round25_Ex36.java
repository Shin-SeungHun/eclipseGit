import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class Round25_Ex36 extends UnicastRemoteObject implements Round25_Ex34 {
	private static Vector vc = new Vector();

	public Round25_Ex36() throws RemoteException {
	}

	public void setClient(Round25_Ex35 cc) throws RemoteException {
		vc.add(cc);
	}

	public void setMessage(String msg) throws RemoteException {
		for (int i = 0; i < vc.size(); i++) {
			Round25_Ex35 cc = (Round25_Ex35) vc.elementAt(i);
			cc.setMessage(msg);
		}
	}

	public static void main(String[] args) throws Exception {
		Round25_Ex36 csi = new Round25_Ex36();
		Naming.rebind("chat", csi);
		System.out.println("Server Ready...");
	}
}
