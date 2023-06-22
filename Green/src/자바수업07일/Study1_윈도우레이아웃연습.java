package 자바수업07일;

import java.awt.*;

public class Study1_윈도우레이아웃연습 {

	public static void main(String[] args) {
		WinTest1 wt = new WinTest1();
	}

}

class WinTest1 extends Frame {
	Label lbTitle = new Label("안녕하세요! JAVA!");
	Label lbName = new Label("이름입력: ");
	Label lbHp = new Label("연락처입력: ");
	TextField tfName = new TextField();
	TextField tfHp = new TextField();
	Button btnOk = new Button("확인");
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);

	WinTest1() {
		super("윈도우 프로그래밍 연습");
		this.setSize(300, 400);
		this.init(); // 화면 구성 레이아웃 구성
		this.setLocation(500, 300);
		this.setVisible(true);
	}

	public void init() { // 레이아웃 구성하기
		this.setLayout(null); // 레이아웃을 직접좌표처리하는 방식
		this.add(lbTitle);// 현재 클래스 내부에 생성해서 넣음...
		lbTitle.setBounds(40, 40, 220, 30);
		lbTitle.setFont(font25);
		
//		lbTitle.setBounds(MAXIMIZED_BOTH, ABORT, WIDTH, HEIGHT);
		
		this.add(lbName);// 현재 클래스 내부에 생성해서 넣음...
		lbName.setBounds(40, 120, 70, 30);
		lbName.setFont(font15);
		this.add(tfName);// 현재 클래스 내부에 생성해서 넣음...
		tfName.setBounds(150, 120, 100, 30);
		tfName.setFont(font15);
		
		this.add(lbHp);// 현재 클래스 내부에 생성해서 넣음...
		lbHp.setBounds(40, 200, 100, 30);
		lbHp.setFont(font15);
		this.add(tfHp);// 현재 클래스 내부에 생성해서 넣음...
		tfHp.setBounds(150, 200, 100, 30);
		tfHp.setFont(font15);
		
		this.add(btnOk);
		btnOk.setBounds(100, 300 , 100 , 30);
		btnOk.setFont(font15);
	}
}