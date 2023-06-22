import java.io.*;
import java.rmi.*;
import java.sql.*;
import java.util.*;

public class Round25_Ex25 { // Client ��
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// Server IP ����
		System.out.print("IP = ");
		String ip = in.readLine();
		// Server�� roots �����ͼ� ȭ�鿡 �����ֱ�
		Round25_Ex23 exp = (Round25_Ex23) Naming.lookup("rmi://" + ip + "/exp");
		Vector vc = exp.getRoots();
		for (int i = 0; i < vc.size(); i++) {
			String data = (String) vc.elementAt(i);
			System.out.println(i + 1 + " : " + data);
		}
		System.out.println();
		// c:�� Folders�� �����ͼ� ȭ�鿡 �����ֱ�
		Vector vc1 = exp.getFolders("c:\\");
		for (int i = 0; i < vc1.size(); i++) {
			String data = (String) vc1.elementAt(i);
			System.out.println(i + 1 + " : " + data);
		}
	}
}
