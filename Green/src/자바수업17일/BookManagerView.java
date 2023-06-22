package 자바수업17일;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BookManagerView extends Frame implements ActionListener {
	Label lbTitle = new Label("도서관리");
	Button btnRent = new Button("도서 대여");
	Button btnReturn = new Button("도서 반납");
	Button btnRentList = new Button("대여가능 책 목록");
	Button btnRentMember = new Button("대여자 목록");
	Button btnBookManager = new Button("책관리");
	Button btnClose = new Button("닫기");

	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);

	BookManagerView() {
		super("도서관리");
		this.setSize(300, 450);
		this.init();// 화면레이아웃구성메서드
		this.start();
		this.setLocation(250, 150);
		this.setVisible(true);
	}

	void init() // 레이아웃 구성하기...
	{
		this.setLayout(null);// 레이아웃을 직접좌표처리하는방식으로하기위해서...
		this.add(lbTitle);// 현재 클래스 내부에 생성해서 넣음...
		lbTitle.setBounds(90, 40, 220, 30);
		lbTitle.setFont(font25);
		this.add(btnRent);// 현재 클래스 내부에 생성해서 넣음...
		this.add(btnReturn);// 현재 클래스 내부에 생성해서 넣음...
		this.add(btnRentList);// 현재 클래스 내부에 생성해서 넣음...
		this.add(btnRentMember);// 현재 클래스 내부에 생성해서 넣음...
		this.add(btnBookManager);// 현재 클래스 내부에 생성해서 넣음...
		this.add(btnClose);// 현재 클래스 내부에 생성해서 넣음...

		btnRent.setFont(font15);
		btnReturn.setFont(font15);
		btnRentList.setFont(font15);
		btnRentMember.setFont(font15);
		btnBookManager.setFont(font15);
		btnClose.setFont(font15);

		btnRent.setBounds(80, 100, 140, 40);
		btnReturn.setBounds(80, 150, 140, 40);
		btnRentList.setBounds(80, 200, 140, 40);
		btnRentMember.setBounds(80, 250, 140, 40);
		btnBookManager.setBounds(80, 300, 140, 40);
		btnClose.setBounds(80, 350, 140, 40);

	}

	void start() {
		btnRent.addActionListener(this);
		btnReturn.addActionListener(this);
		btnRentList.addActionListener(this);
		btnRentMember.addActionListener(this);
		btnBookManager.addActionListener(this);
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
		if (e.getSource() == btnRent) {

			BookRental br = new BookRental();
		} else if (e.getSource() == btnReturn) {

			BookReturn br = new BookReturn();
		} else if (e.getSource() == btnRentList) {

			BookRentList brl = new BookRentList();
		} else if (e.getSource() == btnRentMember) {

			BookRentMemberList brml = new BookRentMemberList();
		} else if (e.getSource() == btnBookManager) {

			BookManager bm = new BookManager();
		} else if (e.getSource() == btnClose) {
			viewClose();
		}
	}
}
