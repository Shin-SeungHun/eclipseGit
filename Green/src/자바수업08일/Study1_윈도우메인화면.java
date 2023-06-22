package 자바수업08일;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Study1_윈도우메인화면 {

	public static void main(String[] args) {
		Main main = new Main();

	}

}

class Main extends Frame {
	Label lbTitle = new Label("메인 화면");

	Button btnList = new Button("회원목록보기");
	Font font3 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font4 = new Font("SansSerif", Font.BOLD, 15);

	Button btnModify = new Button("회원정보수정");
	Font font5 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font6 = new Font("SansSerif", Font.BOLD, 15);

	Button btnDelete = new Button("회원삭제");
	Font font2 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font1 = new Font("SansSerif", Font.BOLD, 15);

	Button btnJoin = new Button("회원가입");
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);

	Button btnClose = new Button("닫기");
	Font font26 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font16 = new Font("SansSerif", Font.BOLD, 15);

	Main() {
		super("메인 화면");
		this.setSize(300, 400);
		this.init();
		this.start();
		this.setLocation(500, 200);
		this.setVisible(true);
	}

	public void init() {
		this.setLayout(null);
		this.add(lbTitle);
		lbTitle.setBounds(100, 40, 300, 30);
		lbTitle.setFont(font25);

		this.add(btnList);
		btnList.setBounds(95, 100, 110, 30);
		btnList.setFont(font15);

		this.add(btnModify);
		btnModify.setBounds(95, 160, 110, 30);
		btnModify.setFont(font15);

		this.add(btnDelete);
		btnDelete.setBounds(110, 220, 80, 30);
		btnDelete.setFont(font15);

		this.add(btnJoin);
		btnJoin.setBounds(110, 280, 80, 30);
		btnJoin.setFont(font15);

		this.add(btnClose);
		btnClose.setBounds(125, 340, 50, 30);
		btnClose.setFont(font15);

	}

	public void start() {

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}