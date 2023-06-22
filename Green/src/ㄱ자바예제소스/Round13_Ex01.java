package ㄱ자바예제소스;

class Inherit {

}

public class Round13_Ex01 {
	public static void main(String[] ar) {
		Inherit in = new Inherit();
		System.out.println("두객체가 같니 ? " + in.equals(in));
		System.out.println("in객체의 클래스 이름은 ? " + in.getClass());
		System.out.println("in객체의 hashCode는 ? " + in.hashCode());
		System.out.println("in객체를 표현하는 기본 문자열은 ? " + in.toString());
		System.out.println("in객체를 표현하는 기본 문자열 약식은 ? " + in);
	}
}

