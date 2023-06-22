package 자바수업01일;

import java.util.Scanner;

public class Study1_3입력받기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name;
		int age;

		System.out.print("이름을 입력하시오:");
		name = sc.next();
		System.out.print("나이를 입력하시오:");
		age = sc.nextInt();
		System.out.println("이름은 " + name + "\n나이는 " + age + "살");

	}

}
