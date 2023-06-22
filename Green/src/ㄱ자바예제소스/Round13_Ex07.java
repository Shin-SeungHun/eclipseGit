package ㄱ자바예제소스;

import java.io.*;

class MyPoint {
	private int x;

	private int y;

	protected static BufferedReader in;
	static {
		in = new BufferedReader(new InputStreamReader(System.in));
	}

	protected MyPoint() throws IOException {
		System.out.print("x = ");
		this.x = Integer.parseInt(in.readLine());
		System.out.print("y = ");
		this.y = Integer.parseInt(in.readLine());
	}

	protected void disp() {
		System.out.println();
		System.out.println("점(x, y) = (" + this.x + ", " + this.y + ")");
	}
}

class Circle extends MyPoint {
	private int r;

	public Circle() throws IOException {
		super(); // MyPoint() 호출. 생략 가능
		System.out.print("r = ");
		this.r = Integer.parseInt(in.readLine());
	}

	public void disp() {
		super.disp();
		System.out.println("반지름 r = " + this.r);
	}
}

class Rect extends MyPoint {
	private int w;

	private int h;

	public Rect() throws IOException {
		super(); // MyPoint() 호출. 생략 가능.
		System.out.print("w = ");
		this.w = Integer.parseInt(in.readLine());
		System.out.print("h = ");
		this.h = Integer.parseInt(in.readLine());
	}

	public void disp() {
		super.disp();
		System.out.println("폭 = " + this.w + ", 높이 = " + this.h);
	}
}

public class Round13_Ex07 {
	public static void main(String[] ar) throws IOException {
		Circle cc = new Circle();
		cc.disp();
		System.out.println();
		System.out.println();
		Rect rt = new Rect();
		rt.disp();
	}
}
