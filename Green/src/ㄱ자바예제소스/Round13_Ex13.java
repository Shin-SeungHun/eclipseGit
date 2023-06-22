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
		System.out.println("��(x, y) = (" + x + ", " + y + ")");
	}
}

class Circle1 extends MyPoint1 {
	private int r;

	public Circle1() throws IOException {
		super(); // MyPoint1() ȣ��
		System.out.print("r = ");
		this.r = Integer.parseInt(in.readLine());
	}

	public void disp() {
		super.disp();
		System.out.println("������ r = " + this.r);
	}
}

class Rect1 extends MyPoint1 {
	private int w;

	private int h;

	public Rect1() throws IOException {
		super(); // MyPoint1() ȣ��
		System.out.print("w = ");
		this.w = Integer.parseInt(in.readLine());
		System.out.print("h = ");
		this.h = Integer.parseInt(in.readLine());
	}

	public void disp() {
		super.disp();
		System.out.println("�� = " + this.w + ", ���� = " + this.h);
	}
}

public class Round13_Ex13 {
	public static void main(String[] ar) throws IOException {
		MyPoint1[] mp = new MyPoint1[10];
		for (int i = 0; i < mp.length; i++) {
			System.out.println();
			System.out.print("1.�� 2.�簢�� 3.���� 4.���� ==> ");
			int x = System.in.read() - 48;
			System.in.read();
			System.in.read();
			if (x == 1) {
				mp[i] = new Circle1();
			} else if (x == 2) {
				mp[i] = new Rect1();
			} else if (x == 3) {
				System.out.println();
				System.out.println("=== ���� ===");
				for (int a = 0; a < i; a++) {
					mp[a].disp();
				}
				System.out.println("=== ���� ===");
				System.out.println();
				i--;
				// ���� �ÿ��� ���� �Է��� ���� �ƴϹǷ� i�� ������ ���� ���δ�.
			} else if (x == 4) {
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
			} else {
				System.err.println("�߸� �Է��ϼ̽��ϴ�.");
			}
		}
		System.out.println();
		System.out.println("���� �ϼ̽��ϴ�.");
	}
}
