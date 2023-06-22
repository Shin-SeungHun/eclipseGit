package 자바수업03일;

public class Study3_클래스2 {

	public static void main(String[] args) {

		Construct con = new Construct();
		System.out.println("메인 메소드입니다.");
	}
}

class Construct {
	// 생성자 : 클래스명과 똑같은 이름으로 사용가능
	// 생성자는 리턴타입이 없는 메소드처럼 사용가능
	//
	Construct() {
		System.out.println("Construct클래스가 생성되었습니다.");
	}

}