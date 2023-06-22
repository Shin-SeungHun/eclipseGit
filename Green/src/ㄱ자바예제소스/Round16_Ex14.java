package ㄱ자바예제소스;

import java.io.*;

public class Round16_Ex14 implements Serializable {
	private String name[] = new String[100];
	private String ph[]= new String[100];
	int cnt = 0;
//		private String jumin;
//		private String tel;
//		private String addr;
	private static transient BufferedReader in;
	static {
		in = new BufferedReader(new InputStreamReader(System.in));
	}

	public Round16_Ex14() throws IOException {
		System.out.print("이름: ");
		name[cnt] =in.readLine();
		System.out.print("연락처: ");
		ph[cnt] = in.readLine();
//			System.out.print("jumin = ");
//			jumin = in.readLine();
//			System.out.print("tel = ");
//			tel = in.readLine();
//			System.out.print("addr = ");
//			addr = in.readLine();
		cnt++;
	}

	public void disp() {
		for(int i=0; i<cnt; i++) {
			System.out.println(i + 1 + "번 " + name[i] + ph[i]+"/n");
			
			
		}

//			System.out.print(jumin + "\t");
//			System.out.print(tel + "\t");
//			System.out.println(addr);
	}
}
