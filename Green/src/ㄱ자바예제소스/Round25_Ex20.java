// import ����
import java.rmi.*;
import java.rmi.server.*;

//impl Class ����
public class Round25_Ex20 extends UnicastRemoteObject implements Round25_Ex19 {
	// ������ ����
	public Round25_Ex20() throws RemoteException {
	}

	// Remote Method ������ ����
	public String openWeb(String addr) throws RemoteException {
		System.out.println("���ϰ� = " + addr);
		try {
			Runtime rt = Runtime.getRuntime();
			rt.exec("explorer.exe " + addr);
		} catch (Exception ee) {
		}

		return "���� ���� ����";
	}
}
