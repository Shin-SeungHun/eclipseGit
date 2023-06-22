import java.io.*;

class MyPoint1 {
	private int x;

	private int y;

	protected static BufferedReader in;
	static {
		in = new BufferedReader(new InputStreamReader(System.in));
	}

	protected MyPoint1() throws IOException {
		System.out.print("x = ");
		this.x = Integer.parseInt(in.readLine());
		System.out.print("y = ");
		this.y = Integer.parseInt(in.readLine());
	}

	protected void disp() {
		System.out.println();
		System.out.println("점(x, y) = (" + x + ", " + y + ")");
	}
}

class Circle1 extends MyPoint1 {
	private int r;

	public Circle1() throws IOException {
		super(); // MyPoint1() 호출
		System.out.print("r = ");
		this.r = Integer.parseInt(in.readLine());
	}

	public void disp() {
		super.disp();
		System.out.println("반지름 r = " + this.r);
	}
}

class Rect1 extends MyPoint1 {
	private int w;

	private int h;

	public Rect1() throws IOException {
		super(); // MyPoint1() 호출
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

public class Round13_Ex13 {
	public static void main(String[] ar) throws IOException {
		MyPoint1[] mp = new MyPoint1[10];
		for (int i = 0; i < mp.length; i++) {
			System.out.println();
			System.out.print("1.원 2.사각형 3.보기 4.종료 ==> ");
			int x = System.in.read() - 48;
			System.in.read();
			System.in.read();
			if (x == 1) {
				mp[i] = new Circle1();
			} else if (x == 2) {
				mp[i] = new Rect1();
			} else if (x == 3) {
				System.out.println();
				System.out.println("=== 보기 ===");
				for (int a = 0; a < i; a++) {
					mp[a].disp();
				}
				System.out.println("=== 보기 ===");
				System.out.println();
				i--;
				// 보기 시에는 값을 입력한 것이 아니므로 i의 증가된 값을 줄인다.
			} else if (x == 4) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			} else {
				System.err.println("잘못 입력하셨습니다.");
			}
		}
		System.out.println();
		System.out.println("수고 하셨습니다.");
	}
}
