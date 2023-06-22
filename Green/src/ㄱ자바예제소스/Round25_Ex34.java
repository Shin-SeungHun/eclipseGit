import java.rmi.*;

public interface Round25_Ex34 extends Remote {
	public void setClient(Round25_Ex35 cc) throws RemoteException;

	public void setMessage(String msg) throws RemoteException;
}
