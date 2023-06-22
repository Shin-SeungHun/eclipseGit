package bookStoreManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UserMain extends Frame implements ActionListener {

	Label lbTitle = new Label("메인화면");
	Button btnList = new Button("회원목록");
	Button btnModify = new Button("회원정보수정");
	Button btnDelete = new Button("회원탈퇴");
	Button btnJoin = new Button("회원가입");
	Button btnClose = new Button("창닫기");

	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);

	public UserMain() {
		super("메인화면");
		this.setSize(300, 400);
		this.init();// 화면레이아웃구성메서드
		this.start();
		this.setLocation(500, 300);
		this.setVisible(true);
	}

	public void init() {
		this.setLayout(null);
		this.add(lbTitle);
		this.add(btnList);
		this.add(btnModify);
		this.add(btnDelete);
		this.add(btnJoin);
		this.add(btnClose);
		
		lbTitle.setFont(font25);
		btnList.setFont(font15);
		btnModify.setFont(font15);
		btnDelete.setFont(font15);
		btnJoin.setFont(font15);
		btnClose.setFont(font15);

		lbTitle.setBounds(100, 40, 220, 30);
		btnList.setBounds(80, 100, 140, 40);
		btnModify.setBounds(80, 150, 140, 40);
		btnDelete.setBounds(80, 200, 140, 40);
		btnJoin.setBounds(80, 250, 140, 40);
		btnClose.setBounds(80, 300, 140, 40);
	}

	public void start() {
		btnList.addActionListener(this);
		btnModify.addActionListener(this);
		btnDelete.addActionListener(this);
		btnJoin.addActionListener(this);
		btnClose.addActionListener(this);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				viewClose();
			}
		});
	}

	void viewClose() {
		this.setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnList) {
			User_list userList = new User_list();
		} else if (e.getSource() == btnModify) {
			User_modify userModify = new User_modify();
		} else if (e.getSource() == btnDelete) {
			User_delete userDelete = new User_delete();
		} else if (e.getSource() == btnJoin) {
			User_join userJoin = new User_join();
		} else if (e.getSource() == btnClose) {
			viewClose();
		}
	}

}
