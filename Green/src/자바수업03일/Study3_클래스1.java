package 자바수업03일;

public class Study3_클래스1 {

	public static void main(String[] args) {
		Test test = new Test();
		test.hello();
		System.out.println("Test 변수 name값: " + test.name);

		Test2 test2 = new Test2();
		test2.hello2();
		System.out.println("Test2 변수 name값: " + test2.name);
	}

}

class Test {

	// 변수
	String name = "홍길동";
	int age = 22;

	// 메소드
	void hello() {
		System.out.println("Test 클래스에 온 걸 대환영!");

	}
}

class Test2 {

	// 변수
	String name = "홍길동";
	int age = 22;

	// 메소드
	void hello2() {
		System.out.println("Test2 클래스에 온 걸 대환영!");

	}

}