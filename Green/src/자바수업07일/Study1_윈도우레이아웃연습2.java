package 자바수업07일;

import java.awt.*;

public class Study1_윈도우레이아웃연습2 {

	public static void main(String[] args) {
		WinTest2 wt = new WinTest2();
	}

}

class WinTest2 extends Frame {
	
	Label lbTitle = new Label("회원가입화면");
	Label lbId = new Label("아이디: ");
	Label lbPs = new Label("패스워드: ");
	Label lbName = new Label("이름: ");
	Label lbHp = new Label("연락처: ");
	
	TextField tfId = new TextField();
	TextField tfPs = new TextField();
	TextField tfName = new TextField();
	TextField tfHp = new TextField();
	
	Button btnIdCheck = new Button("중복확인");
	Font font2 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font1 = new Font("SansSerif", Font.BOLD, 15);
	
	Button btnJoin = new Button("가입하기");
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);
	

	WinTest2() {
		super("윈도우 프로그래밍 연습");
		this.setSize(300, 400);
		this.init(); // 화면 구성 레이아웃 구성
		this.setLocation(500, 200);
		this.setVisible(true);
	}

	public void init() { // 레이아웃 구성하기
		this.setLayout(null); // 레이아웃을 직접좌표처리하는 방식
		this.add(lbTitle);// 현재 클래스 내부에 생성해서 넣음...
		lbTitle.setBounds(100, 40, 300, 30);
		lbTitle.setFont(font15);
		
//		lbTitle.setBounds(MAXIMIZED_BOTH, ABORT, WIDTH, HEIGHT);
		
		this.add(lbId);// 현재 클래스 내부에 생성해서 넣음...
		lbId.setBounds(20, 100, 100, 30);
		lbId.setFont(font15);
		// lbId.setBounds(MAXIMIZED_BOTH, ABORT, WIDTH, HEIGHT);
		this.add(tfId);// 현재 클래스 내부에 생성해서 넣음...
		tfId.setBounds(120, 105, 90, 25);
		tfId.setFont(font15);
		
		this.add(btnIdCheck);
		btnIdCheck.setBounds(220, 100 , 70 , 30);
		btnIdCheck.setFont(font15);
		
		this.add(lbPs);// 현재 클래스 내부에 생성해서 넣음...
		lbPs.setBounds(20, 135, 100, 30);
		lbPs.setFont(font15);
		
		this.add(tfPs);// 현재 클래스 내부에 생성해서 넣음...
		tfPs.setBounds(120, 140, 120, 25);
		tfPs.setFont(font15);
		
		this.add(lbName);// 현재 클래스 내부에 생성해서 넣음...
		lbName.setBounds(20, 170, 100, 30);
		lbName.setFont(font15);
		
		this.add(tfName);// 현재 클래스 내부에 생성해서 넣음...
		tfName.setBounds(120, 175, 120, 25);
		tfName.setFont(font15);
		
		this.add(lbHp);// 현재 클래스 내부에 생성해서 넣음...
		lbHp.setBounds(20, 200, 100, 30);
		lbHp.setFont(font15);
		
		this.add(tfHp);// 현재 클래스 내부에 생성해서 넣음...
		tfHp.setBounds(120, 205, 120, 25);
		tfHp.setFont(font15);
		
		
		
		this.add(btnJoin);
		btnJoin.setBounds(100, 300 , 100 , 30);
		btnJoin.setFont(font15);
	}
}