package 자바수업01일;

public class Study1_5반복문doWhile구구단과제 {

	public static void main(String[] args) {

		int i = 2, j = 1;

		do {
			do {
				System.out.println(i + "*" + j + "=" + i * j);
				j++;
			} while (j < 10);
			j = 1;
			i++;
		} while (i < 10);
	}

}
