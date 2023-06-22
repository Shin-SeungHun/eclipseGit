package 자바수업17일;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainProgram extends Frame implements ActionListener {

	Label lbTitle = new Label("도서대여프로그램");
	Button btnBook = new Button("도서관리");
	Button btnUser = new Button("회원관리");
	Button btnBookList = new Button("관리자 문의");
	Button btnBookDetail = new Button("관리자 화면");
	Button btnClose = new Button("닫기");
	
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);
	public static BoardList bl = null;

	MainProgram(String loginId) {
		super("메인화면");
		this.setSize(300, 400);
		this.init(loginId);// 화면레이아웃구성메서드
		this.start();
		this.setLocation(500, 300);
		this.setVisible(true);
	}

	void init(String loginId) // 레이아웃 구성하기...
	{
		this.setLayout(null);// 레이아웃을 직접좌표처리하는방식으로하기위해서...
		this.add(lbTitle);// 현재 클래스 내부에 생성해서 넣음...
		lbTitle.setBounds(40, 40, 220, 30);
		lbTitle.setFont(font25);

		this.add(btnBook);// 현재 클래스 내부에 생성해서 넣음...
		btnBook.setBounds(80, 100, 140, 40);
		btnBook.setFont(font15);

		this.add(btnUser);// 현재 클래스 내부에 생성해서 넣음...
		btnUser.setBounds(80, 150, 140, 40);
		btnUser.setFont(font15);

		this.add(btnBookList);// 현재 클래스 내부에 생성해서 넣음...
		btnBookList.setBounds(80, 200, 140, 40);
		btnBookList.setFont(font15);

		this.add(btnClose);// 현재 클래스 내부에 생성해서 넣음...
		btnClose.setBounds(80, 300, 140, 40);
		btnClose.setFont(font15);
		
		if (loginId.equals("admin")) {
			this.add(btnBookDetail);// 현재 클래스 내부에 생성해서 넣음...
			btnBookDetail.setBounds(80, 250, 140, 40);
			btnBookDetail.setFont(font15);
		}

	}

	void start() {
		btnBook.addActionListener(this);
		btnUser.addActionListener(this);
		btnBookList.addActionListener(this);
		btnBookDetail.addActionListener(this);
		btnClose.addActionListener(this);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBook) {
			BookManagerView bookManagerView = new BookManagerView();
		} else if (e.getSource() == btnUser) {
			MemberMainView memberMainView = new MemberMainView();
		} else if (e.getSource() == btnBookList) {
			Board board = new Board();
		} else if (e.getSource() == btnBookDetail) {
			if (bl == null) {
				BoardList.mList.removeAll();// 리시트항목 모두제거
				bl = new BoardList();
			} else {
				bl.setVisible(true);
			}
		}
	}
}
