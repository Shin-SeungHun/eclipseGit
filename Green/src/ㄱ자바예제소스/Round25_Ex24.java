import java.rmi.*;
import java.rmi.server.*;
import java.util.*;
import java.io.*;

public class Round25_Ex24 extends UnicastRemoteObject implements Round25_Ex23 {
	// 생성자 선언
	public Round25_Ex24() throws RemoteException {
	}

	// 원격 Method 구현
	public Vector getRoots() throws RemoteException {
		Vector imsi = new Vector();
		// Root를 구한다.
		File[] roots = File.listRoots();
		// Vector에 문자열로 담는다.
		for (int i = 0; i < roots.length; i++) {
			imsi.add(roots[i].toString());
		}
		return imsi;
	}

	public Vector getFolders(String path) throws RemoteException {
		Vector imsi = new Vector();
		// 해당 path의 Folder를 구한다.
		File dir = new File(path);
		if (!dir.isDirectory() || !dir.exists())
			return null;
		File[] lists = dir.listFiles();
		// Folder만 Vector에 문자열로 담는다.
		for (int i = 0; i < lists.length; i++) {
			if (lists[i].isDirectory()) {
				imsi.add(lists[i].getPath());
			}
		}
		return imsi;
	}

	// Binding
	public static void main(String[] args) throws Exception {
		// RMI Server Start!!
		Runtime rt = Runtime.getRuntime();
		rt.exec("c:\\java\\jdk1.5\\bin\\rmiregistry.exe");
		// 객체 선언
		Round25_Ex24 impl = new Round25_Ex24();
		// 객체 Binding
		System.out.println("Server Ready...");
		Naming.rebind("exp", impl);
	}
}
