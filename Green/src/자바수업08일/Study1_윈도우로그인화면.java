package 자바수업08일;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Study1_윈도우로그인화면 {

	public static void main(String[] args) {
		LoginTest login = new LoginTest();

	}

}

class LoginTest extends Frame {
	Label lbTitle = new Label("로그인 화면");
	Label lbId = new Label("아이디: ");
	Label lbPs = new Label("패스워드: ");

	TextField tfId = new TextField();
	TextField tfPs = new TextField();

	Button btnLogin = new Button("로그인");
	Button btnJoin = new Button("회원가입");

	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);

	LoginTest() {
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

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}