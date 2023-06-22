package ㄱ자바예제소스;

import java.io.*;
import java.util.*;
class MyPoint{
	private int x, y;
	protected static BufferedReader in;
	static{
		in = new BufferedReader(new InputStreamReader(System.in));
	}
	public MyPoint() throws IOException{
		System.out.print("x = ");
		x = Integer.parseInt(in.readLine());
		System.out.print("y = ");
		y = Integer.parseInt(in.readLine());
	}
	public void disp(){
		System.out.println("��(" + x + ", " + y + ")");
	}
}
class MyCircle extends MyPoint{
	private int r;
	public MyCircle() throws IOException{
		super();
		System.out.print("r = ");
		r = Integer.parseInt(in.readLine());	
	}
	public void disp(){
		super.disp();
		System.out.println("������ = " + r + "cm");
	}
}
class MyRect extends MyPoint{
	private int w, h;
	public MyRect() throws IOException{
		super();
		System.out.print("w = ");
		w = Integer.parseInt(in.readLine());
		System.out.print("h = ");
		h = Integer.parseInt(in.readLine());	
	}
	public void disp(){
		super.disp();
		System.out.println("�� = " + w + "cm, ���� = " + h + "cm");
	}
}
public class DrawTest {
	public static void main(String[] args) throws IOException{
		Vector vc = new Vector();
		while(true){
			System.out.print("1.�� 2.�簢�� 3.��ü���� 4.���� = ");
			int x = System.in.read() - 48;
			System.in.read();
			System.in.read();
			if(x == 1) vc.add(new MyCircle());
			else if(x == 2) vc.add(new MyRect());
			else if(x == 3){
				for(int i = 0; i < vc.size(); i++){
					Object obj = vc.elementAt(i);
					MyPoint imsi = (MyPoint)obj;
					//if(imsi instanceof MyCircle){
						imsi.disp();
					//}
				}
			}
			else if(x == 4) System.exit(0);
			else System.err.println("�߸� �Է�!!!");
		}
	}
}

