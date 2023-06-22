package ㄱ자바예제소스;

import java.io.*;

public class Round11_Ex02 {
	private int x;

	private int y;

	private static int tot;

	private static BufferedReader in;
	static {
		Round11_Ex02.in = new BufferedReader(new InputStreamReader(System.in));
		Round11_Ex02.tot = 0;
	}

	public Round11_Ex02() throws IOException {
		System.out.print("x = ");
		this.x = Integer.parseInt(Round11_Ex02.in.readLine());
		System.out.print("y = ");
		this.y = Integer.parseInt(Round11_Ex02.in.readLine());
		Round11_Ex02.tot = this.x + this.y;
	}

	public static int getTot() {
		return Round11_Ex02.tot;
	}

	public static void setTot(int tot) {
		Round11_Ex02.tot = tot;
	}

	public void display() {
		System.out.print(this.x + " + " + this.y + " = ");
		System.out.println(Round11_Ex02.tot);
	}
}
