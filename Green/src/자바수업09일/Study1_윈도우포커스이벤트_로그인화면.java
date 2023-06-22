package 자바수업09일;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/*
 * 포커스 이벤트 연습히가ㅣ
 * 조건
 * 1.패스워드로 갈때 아이다가 입력되어있지않으면 아이디로 포커스 고정
 * 2.패스워드로 넘어갈때 아이디 총 글자가 12자가 넘어가면 아이디로 포커스 고정하고 공백으로 지워버리기
 * 3.로그인버튼 클릭시 공백일시 문구출력
 * Id input plz
 * Ps input plz
 * */
public class Study1_윈도우포커스이벤트_로그인화면 {

	public static void main(String[] args) {
		new LoginTest1();
	}
}

class LoginTest1 extends Frame implements FocusListener, ActionListener {
	Label lbTitle = new Label("로그인 화면");
	Label lbId = new Label("아이디: ");
	Label lbPs = new Label("패스워드: ");

	TextField tfId = new TextField();
	TextField tfPs = new TextField();

	Button btnLogin = new Button("로그인");
	Button btnJoin = new Button("회원가입");

	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);

	LoginTest1() {
		super("로그인 화면");
		this.setSize(300, 400);
		this.start();
		this.init();
		this.setLocation(500, 200);
		this.setVisible(true);
	}

	public void init() {
		this.setLayout(null);
		this.add(lbTitle);
		lbTitle.setBounds(85, 40, 300, 30);
		lbTitle.setFont(font25);

		this.add(lbId);
		lbId.setBounds(20, 130, 100, 30);
		lbId.setFont(font15);

		this.add(tfId);
		tfId.setBounds(120, 135, 90, 25);
		tfId.setFont(font15);

		this.add(lbPs);
		lbPs.setBounds(20, 160, 90, 30);
		lbPs.setFont(font15);

		this.add(tfPs);
		tfPs.setBounds(120, 165, 120, 25);
		tfPs.setFont(font15);

		this.add(btnLogin);
		btnLogin.setBounds(115, 250, 70, 30);
		btnLogin.setFont(font15);

		this.add(btnJoin);
		btnJoin.setBounds(105, 300, 90, 30);
		btnJoin.setFont(font15);

	}

	public void start() {

		btnLogin.addActionListener(this);
		tfId.addFocusListener(this);
		tfPs.addFocusListener(this);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void focusGained(FocusEvent e) {
		if (e.getSource() == tfId) {
		} else if (e.getSource() == tfPs) {
			if (tfId.getText().equals("")) {
				tfId.requestFocus();
				System.out.println("Id input plz");
			}
			
			int check = tfId.getText().trim().length();
			if (check > 12) {
				tfId.requestFocus();
				tfId.setText("");
				System.out.println("Id length MAX 12");
			}

		}
	}

	@Override
	public void focusLost(FocusEvent e) {
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLogin) {
			if (tfId.getText().equals("")) {
				System.out.println("Id input plz");
				return;
			}
			if (tfPs.getText().equals("")) {
				System.out.println("Ps input plz");
				return;
			}
		}
	}
}