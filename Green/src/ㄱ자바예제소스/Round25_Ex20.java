// import 영역
import java.rmi.*;
import java.rmi.server.*;

//impl Class 선언
public class Round25_Ex20 extends UnicastRemoteObject implements Round25_Ex19 {
	// 생성자 영역
	public Round25_Ex20() throws RemoteException {
	}

	// Remote Method 재정의 영역
	public String openWeb(String addr) throws RemoteException {
		System.out.println("리턴값 = " + addr);
		try {
			Runtime rt = Runtime.getRuntime();
			rt.exec("explorer.exe " + addr);
		} catch (Exception ee) {
		}

		return "서버 실행 성공";
	}
}
