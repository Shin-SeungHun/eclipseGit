import java.rmi.*;
import java.rmi.server.*;
import java.io.*;

public class Round25_Ex37 extends UnicastRemoteObject implements Round25_Ex35 {
	public Round25_Ex37() throws RemoteException {
	}

	public void setMessage(String msg) throws RemoteException {
		System.out.println(msg);
	}

	public static void main(String[] args) throws Exception {
		Round25_Ex37 cci = new Round25_Ex37();
		Round25_Ex34 cs = (Round25_Ex34) Naming
				.lookup("rmi://124.61.53.124/chat");
		cs.setClient(cci);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.print("msg = ");
			String msg = in.readLine();
			cs.setMessage(msg);
		}
	}
}