class A3 {
	public String toString() {
		return "A3 클래스";
	}
}

class B3 {
	public String toString() {
		return "B3 클래스";
	}
}

public class Round13_Ex08 {
	public static void main(String[] ar) {
		Object[] obj = new Object[2];
		obj[0] = new A3();
		obj[1] = new B3();
		for (int a = 0; a < obj.length; a++) {
			System.out.println("obj[" + a + "] = " + obj[a]);
			// obj[a].toString()의 약식 표현
		}
	}
}
