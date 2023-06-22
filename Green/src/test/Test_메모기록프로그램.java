package test;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class Test_메모기록프로그램 {
	public static void main(String[] args) throws IOException {
		Memoo m = new Memoo();
	}
	/*
	 * ◦ 클래스를 만들어 생성자, 메서드, 제어문을 응용한다. ◦ Util에서 제공되는 DATE 클래스 라이브러리 이용해서 현재 날짜를 구해서
	 * 파일에 저장 한다. ◦ 파일 입출력을 통해 파일에 기록한다. <입력> 메모 : 날씨가 매우 좋습니다. <출력> 2023-02-10 날씨가
	 * 매우 좋습니다. <파일기록> 2023-02-10 날씨가 매우 좋습니다.
	 */

}
class Memoo {
	Scanner sc = new Scanner(System.in);
	private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	File file = new File("C:\\java\\Green\\src\\test\\memo.text");
	FileWriter fw = new FileWriter("C:\\java\\Green\\src\\test\\memo.text");
	static String memo;
	Memoo() throws IOException {
		int input;
		while (true) {
			System.out.println("1.메모");
			System.out.println("2.출력");
			System.out.println("3.파일기록");
			System.out.print("선택:");
			input = sc.nextInt();
			if (input == 1) {
				memo();
			} else if (input == 2) {
				output();
			} else if (input == 3) {
				System.out.println("<파일기록>");
				record();
			}
		}
	}
	void memo() throws IOException {
		FileInputStream f = new FileInputStream(file);
		System.out.println("<입력>");
		System.out.print("메모:");
		memo = in.readLine();
	}
	void output() {
		System.out.println("<출력>");
		date();
		System.out.println(memo);
	}
	void record() throws IOException {
		FileOutputStream fos = new FileOutputStream(file, true);
		BufferedOutputStream bos = new BufferedOutputStream(fos, 1024);
		PrintStream ps = new PrintStream(bos);
		System.setErr(ps); 
		date();
		System.out.println(memo);
	}
	void date() {
		Date date = new Date();
		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(formatter1.format(date));
	}
}