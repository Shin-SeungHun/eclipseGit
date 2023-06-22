package 자바수업09일;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*성별을 추가해서 만들고 선택시 값 출력하게 아이템 리스너 처리
 * 
 * chocie Man
 * chocie Girl
 * */

public class Study1_윈도우다이얼로그_회원가입 {

	public static void main(String[] args) {
		new Join2();
	}

}

class Join2 extends Frame implements FocusListener, ActionListener{

	private Choice ch = new Choice();
	
	Label lbTitle = new Label("회원가입화면", Label.LEFT);
	Label lbId = new Label("아이디:");
	Label lbPs = new Label("패스워드:");
	Label lbName = new Label("이름:");
	Label lbHp = new Label("연락처:");
	Label lbGender = new Label("성별:");

	TextField tfId = new TextField();
	TextField tfPs = new TextField();
	TextField tfName = new TextField();
	TextField tfHp = new TextField();
	TextField tfGender = new TextField();

	Button btnIdCheck = new Button("중복확인");
	Button btnJoin = new Button("가입하기");

	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);

	Join2() {
		super("회원가입");
		this.setSize(300, 400);
		this.init(); // 화면 구성 레이아웃 구성
		this.start();
		this.setLocation(500, 200);
		this.setVisible(true);
	}

	public void init() { // 레이아웃 구성하기
		this.setLayout(null); // 레이아웃을 직접좌표처리하는 방식
		this.add(lbTitle);// 현재 클래스 내부에 생성해서 넣음...
		lbTitle.setBounds(80, 30, 300, 30);
		lbTitle.setFont(font25);

//		lbTitle.setBounds(MAXIMIZED_BOTH, ABORT, WIDTH, HEIGHT);

		this.add(lbId);// 현재 클래스 내부에 생성해서 넣음...
		lbId.setBounds(20, 80, 55, 30);
		lbId.setFont(font15);
		// lbId.setBounds(MAXIMIZED_BOTH, ABORT, WIDTH, HEIGHT);
		this.add(tfId);// 현재 클래스 내부에 생성해서 넣음...
		tfId.setBounds(95, 83, 90, 25);
		tfId.setFont(font15);

		this.add(btnIdCheck);
		btnIdCheck.setBounds(195, 80, 70, 30);
		btnIdCheck.setFont(font15);

		this.add(lbPs);// 현재 클래스 내부에 생성해서 넣음...
		lbPs.setBounds(20, 115, 69, 30);
		lbPs.setFont(font15);

		this.add(tfPs);// 현재 클래스 내부에 생성해서 넣음...
		tfPs.setBounds(95, 117, 120, 25);
		tfPs.setFont(font15);

		this.add(lbName);// 현재 클래스 내부에 생성해서 넣음...
		lbName.setBounds(20, 147, 50, 30);
		lbName.setFont(font15);

		this.add(tfName);// 현재 클래스 내부에 생성해서 넣음...
		tfName.setBounds(95, 150, 100, 25);
		tfName.setFont(font15);

		this.add(lbHp);// 현재 클래스 내부에 생성해서 넣음...
		lbHp.setBounds(20, 180, 55, 30);
		lbHp.setFont(font15);

		this.add(tfHp);// 현재 클래스 내부에 생성해서 넣음...
		tfHp.setBounds(95, 185, 120, 25);
		tfHp.setFont(font15);

		this.add(lbGender);
		lbGender.setBounds(20, 230, 50, 30);
		lbGender.setFont(font15);
		
		this.add(tfGender);
		tfGender.setBounds(95, 230, 100, 30);
		tfGender.setFont(font15);

		
		
		
		this.add(btnJoin);
		btnJoin.setBounds(100, 300, 100, 30);
		btnJoin.setFont(font15);
	}

	public void start() {
		
		this.btnJoin.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	public void focusGained(FocusEvent e) {
//		if(e.getSource()==tfGender) {
//			if(tfGender.getText().equals("남자")) {
//				System.out.println("chocie Man");
//			}else if(tfGender.getText().equals("여자")) {
//				System.out.println("choice girl");
//			}
//		}
		
//		String Check = tfGender.getText().trim().length();
//		if()
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnJoin) {
			if(tfGender.getText().equals("남자")) {
				System.out.println("choice Man");
			}else if(tfGender.getText().equals("여자")) {
				System.out.println("choice girl");
			}
		}
		
	}
}