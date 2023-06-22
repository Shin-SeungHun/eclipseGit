package 자바수업01일;

public class Study1_5반복문while과제 {

	public static void main(String[] args) {

		int i = 2, j = 1;
		while (i < 10) {
			System.out.println(i + "단");
			while (j < 10) {
				System.out.println(i + " * " + j + " = " + i * j);
				j++;
			}
			j = 1; // 초기화
			i++;
		}

	}

}
