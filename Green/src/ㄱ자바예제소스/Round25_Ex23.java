import java.rmi.*;
import java.util.*;

public interface Round25_Ex23 extends Remote {
	// Root �ֱ�
	public Vector getRoots() throws RemoteException;

	// Folder �ֱ�
	public Vector getFolders(String path) throws RemoteException;
}
