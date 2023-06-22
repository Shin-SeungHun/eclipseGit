import java.rmi.*;
import java.util.*;

public interface Round25_Ex23 extends Remote {
	// Root 주기
	public Vector getRoots() throws RemoteException;

	// Folder 주기
	public Vector getFolders(String path) throws RemoteException;
}
