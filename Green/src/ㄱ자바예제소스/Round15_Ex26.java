import java.util.*;
import java.io.*;
public class Round15_Ex26 {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("���ڿ� = ");
		String str = in.readLine();
		System.out.print("������ = ");
		String del = in.readLine();
		
		System.out.println("::���::");
		StringTokenizer stk = 
						new StringTokenizer(str, del);
		while(stk.hasMoreTokens()){
			System.out.println(stk.nextToken());
		}
		System.out.println("::��³�::");
		
	}
}
