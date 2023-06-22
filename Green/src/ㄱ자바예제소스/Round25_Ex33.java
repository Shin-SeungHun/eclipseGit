import java.rmi.*;
import java.rmi.server.*;

public class Round25_Ex33 extends UnicastRemoteObject implements Round25_Ex31 {
	public Round25_Ex33() throws RemoteException {
	}

	public void setScreenDate(String str) throws RemoteException {
		System.out.println(str);
	}

	public static void main(String[] args) throws Exception {
		Round25_Ex30 sf = (Round25_Ex30) Naming
				.lookup("rmi://124.61.53.124/both");
		Round25_Ex33 sc = new Round25_Ex33();
		sf.setClient(sc);
		while (true) {
			System.out.print("message = ");
			int xx = System.in.read() - 48;
			System.in.read();
			System.in.read();
			if (xx == 1)
				sf.setDate();
		}
	}
}
