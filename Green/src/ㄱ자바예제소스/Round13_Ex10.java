	class A5{
		int x = 100;
	}
	class B5 extends A5{
		int x = 200;
	}
	public class Round13_Ex10{
		public static void main(String[] ar){
			A5 ap = new B5(); // 다형적 표현
			System.out.println("x = " + ap.x); // x = 100
		}
	}
