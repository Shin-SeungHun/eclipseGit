package 자바수업02일;

public class Study1_배열2 {

	public static void main(String[] args) {
		int num1, num2, num3, num4, num5;
		num1 = 100;
		num2 = 100;
		num3 = 100;
		num4 = 100;
		num5 = 100;

		int num[] = new int[5];
		num[0] = 100;
		num[1] = 100;
		num[2] = 100;
		num[3] = 100;
		num[4] = 100;

		int number[] = { 1, 2, 3, 4, 5, 6 };
		int nember2[]= {1, 2, 3, 4, 5, 6};
		int nember3[]= {1, 2, 3, 4, 5, 6};
		
		for(int i=0; i<num.length; i++) {
			System.out.println("num["+i+"]"+num[i]);
		}
	}

}
