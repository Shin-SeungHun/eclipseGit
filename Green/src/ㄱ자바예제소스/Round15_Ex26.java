import java.util.*;
import java.io.*;
public class Round15_Ex26 {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("문자열 = ");
		String str = in.readLine();
		System.out.print("구분자 = ");
		String del = in.readLine();
		
		System.out.println("::결과::");
		StringTokenizer stk = 
						new StringTokenizer(str, del);
		while(stk.hasMoreTokens()){
			System.out.println(stk.nextToken());
		}
		System.out.println("::출력끝::");
		
	}
}
