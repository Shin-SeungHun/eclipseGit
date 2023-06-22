package ㄱ자바예제소스;

import java.io.*;

public class Round10_Ex10 {
	private int x;

	private int y;

	private BufferedReader in =new BufferedReader(new InputStreamReader(System.in));

	public Round10_Ex10() {
		
		this.x = 0;
		this.y = 0;
	}

	public void setX() throws IOException {
		System.out.print("x = ");
		this.x = Integer.parseInt(in.readLine());
	}

	public void setY() throws IOException {
		System.out.print("y = ");
		this.y = Integer.parseInt(in.readLine());
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void display() {
		System.out.println();
		System.out.print("점의 좌표 (x, y) = ");
		System.out.println("(" + x + ", " + y + ")");
		System.out.println();
	}
}

