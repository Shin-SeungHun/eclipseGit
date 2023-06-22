package 자바수업09일;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*클래스 내부에 id="admin" / pw="1004"의 변수값을 지정해 놓고 로그인 시도시 처리되는 다이얼로그를 만들어보시오
 * 다이얼로그창이 뜨는 메소드를 만들어 하나로 호출하도록 만드시오
 * 
 * ex)아이디 틀렸을시
 * 		아이디가 틀림 확인요망
 * ex)비번이 틀렸을시
 * 		비번이 틀림 확인요망
 * ex)로그인 성공시
 * 		로그인되었습니다.
 * */

public class Study4_윈도우_다이얼로그_활용 {
	public static void main(String[] args) {
		new Login3();
	}
}

class Login3 extends Frame implements FocusListener, ActionListener {
	String id = "admin";
	String pw = "1004";

	Label lbTitle = new Label("로그인 화면");
	Label lbId = new Label("아이디:");
	Label lbPw = new Label("패스워드:");

	TextField tfId = new TextField();
	TextField tfPw = new TextField();

	Button btnLogin = new Button("로그인");
	Button btnJoin = new Button("가입하기");

	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);

	Login3() {
		super("로그인화면");
		this.setSize(300, 400);
		this.init();// 화면레이아웃구성메서드
		start();
		this.setLocation(500, 300);
		this.setVisible(true);

	}

	void start() {
		btnLogin.addActionListener(this);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	void init() // 레이아웃 구성하기...
	{
		this.setLayout(null);// 레이아웃을 직접좌표처리하는방식으로하기위해서...
		
		this.add(lbTitle);
		lbTitle.setFont(font25);
		lbTitle.setBounds(50, 50, 200, 30);

		this.add(lbId);
		lbId.setFont(font15);
		lbId.setBounds(30, 100, 80, 30);
		
		this.add(tfId);
		tfId.setFont(font15);
		tfId.setBounds(110, 100, 80, 30);

		this.add(lbPw);
		lbPw.setFont(font15);
		lbPw.setBounds(30, 150, 80, 30);
		
		this.add(tfPw);
		tfPw.setFont(font15);
		tfPw.setBounds(110, 150, 80, 30);

		this.add(btnLogin);
		btnLogin.setFont(font15);
		btnLogin.setBounds(110, 300, 80, 30);

		this.add(btnJoin);
		btnJoin.setFont(font15);
		btnJoin.setBounds(110, 340, 80, 30);

	}

	@Override
	public void focusGained(FocusEvent e) {
		if (e.getSource() == tfId) {
		} else if (e.getSource() == tfPw) {
			if (tfId.getText().equals("")) {
				tfId.requestFocus();
				System.out.println("Id input plz...");
			}
			
			int check = tfId.getText().trim().length();
			
			if (check > 12) {
				tfId.requestFocus();
				tfId.setText("");
				System.out.println("Id length MAX 12.....");
			}

		}

	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnLogin) {
			if (tfId.getText().equals("")) {
				dialog("아이디를 입력하시오.");
				return;
			}
			if (tfPw.getText().equals("")) {
				dialog("패스워드를 입력하시오.");
				return;
			}

		}

		String inputId = tfId.getText();
		String inputPw = tfPw.getText();

		if (inputId.equals(id)) {
			if (inputPw.equals(pw)) {
				dialog("로그인 되었습니다.");
			} else {
				dialog("패스워드가 틀림! 확인요망!");
			}
		} else {
			dialog("아이디가 틀림! 확인요망");
		}

	}

	public void dialog(String msg) {
		Dialog dlg = new Dialog(this, "로그인체크", true);
		Label lbContent = new Label(msg);

		Button bt = new Button("확인");
		dlg.setLayout(null);

		dlg.add(lbContent);
		lbContent.setFont(font15);
		dlg.add(bt);
		bt.setFont(font15);
		lbContent.setBounds(50, 50, 200, 30);
		bt.setBounds(80, 120, 120, 30);

		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlg.setVisible(false);
			}
		});

		dlg.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dlg.setVisible(false);
			}
		});

		dlg.setLocation(480, 250);
		dlg.setSize(300, 200);
		dlg.setVisible(true);
	}

}
