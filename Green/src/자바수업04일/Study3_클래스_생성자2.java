package 자바수업04일;

public class Study3_클래스_생성자2 {

	public static void main(String[] args) {
		나 me = new 나();
	}

}

class 부모 {
	부모() {
		System.out.println("부모 클래스가 생성되었습니다.");
	}

	int money = 20000000;
	String car = "벤츠";
	String house = "아파트";

}

class 나 extends 부모 {
	int money = 20000;
	String car = "아반떼";

	나() {
		System.out.println("나 클래스가 생성되었습니다.");
		System.out.println("내돈: " + this.money);
		System.out.println("내차: " + this.car);
		System.out.println("내집: " + this.house);
		System.out.println("부모님돈: " + super.money); // 중복될시 super로 우선적용
		System.out.println("부모님차: " + super.car);
	}

}