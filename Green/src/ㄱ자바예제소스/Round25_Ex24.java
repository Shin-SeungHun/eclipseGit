import java.rmi.*;
import java.rmi.server.*;
import java.util.*;
import java.io.*;

public class Round25_Ex24 extends UnicastRemoteObject implements Round25_Ex23 {
	// ������ ����
	public Round25_Ex24() throws RemoteException {
	}

	// ���� Method ����
	public Vector getRoots() throws RemoteException {
		Vector imsi = new Vector();
		// Root�� ���Ѵ�.
		File[] roots = File.listRoots();
		// Vector�� ���ڿ��� ��´�.
		for (int i = 0; i < roots.length; i++) {
			imsi.add(roots[i].toString());
		}
		return imsi;
	}

	public Vector getFolders(String path) throws RemoteException {
		Vector imsi = new Vector();
		// �ش� path�� Folder�� ���Ѵ�.
		File dir = new File(path);
		if (!dir.isDirectory() || !dir.exists())
			return null;
		File[] lists = dir.listFiles();
		// Folder�� Vector�� ���ڿ��� ��´�.
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
		// ��ü ����
		Round25_Ex24 impl = new Round25_Ex24();
		// ��ü Binding
		System.out.println("Server Ready...");
		Naming.rebind("exp", impl);
	}
}
