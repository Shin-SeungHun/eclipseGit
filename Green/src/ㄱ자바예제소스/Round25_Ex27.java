import java.rmi.*;
import javax.rmi.*;

public class Round25_Ex27 extends PortableRemoteObject implements Round25_Ex26 {
	public Round25_Ex27() throws RemoteException {
	}

	public String sayHello(String name) throws RemoteException {
		return "Hello " + name + "!";
	}
}
