package 자바수업05일;

public class Study2_Static {

	public static void main(String[] args) {

		System.out.println("Data name=" + Data.name);
		
		Data d1 = new Data();
		System.out.println("d1 age=" + d1.age);
		System.out.println("d1 age2=" + d1.age2);

		Data d2 = new Data();
		System.out.println("d2 age=" + d2.age);
		System.out.println("d2 age2=" + d2.age2);
	}

}

class Data {
	static String name = "자바맨"; // static 을 붙이면 전부 공유가능
	static int age = 10;
	int age2 = 10;

	Data() {
		age++;
		age2++;
	}
}
