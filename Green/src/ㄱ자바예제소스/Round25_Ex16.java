import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class Round25_Ex16 extends UnicastRemoteObject implements Round25_Ex15 {
	public Round25_Ex16() throws RemoteException {
		super();
	}

	public String sayHello() throws RemoteException {
		printDate();
		return "æ»≥Á«œººø‰! π›∞©Ω¿¥œ¥Ÿ.";
	}

	public void printDate() throws RemoteException {
		Date d = new Date();
		System.out.println("Connect Date = " + d.toString());
	}
}
