// import 영역
import java.rmi.*;

// 인터페이스 선언
public interface Round25_Ex19 extends Remote {
	// 필요한 Method를 졍의
	public String openWeb(String addr) throws RemoteException;
}
