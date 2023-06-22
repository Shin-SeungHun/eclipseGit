package 자바수업17일;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BookManager extends Frame implements ActionListener {
	Label lbTitle = new Label("책관리");

	Button btnAdd = new Button("책등록");
	Button btnList = new Button("책리스트");
	Button btnEdit = new Button("책정보수정");
	Button btnDel = new Button("책삭제");

	Button btnClose = new Button("닫기");

	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);

	BookManager() {
		super("책관리");
		this.setSize(300, 450);
		this.init();// 화면레이아웃구성메서드
		this.start();
		this.setLocation(300, 100);
		this.setVisible(true);
	}

	void init() // 레이아웃 구성하기...
	{
		this.setLayout(null);// 레이아웃을 직접좌표처리하는방식으로하기위해서...
		this.add(lbTitle);// 현재 클래스 내부에 생성해서 넣음...
		lbTitle.setBounds(110, 40, 220, 30);
		lbTitle.setFont(font25);

		this.add(btnAdd);// 현재 클래스 내부에 생성해서 넣음...
		btnAdd.setBounds(80, 100, 140, 40);
		btnAdd.setFont(font15);

		this.add(btnList);// 현재 클래스 내부에 생성해서 넣음...
		btnList.setBounds(80, 150, 140, 40);
		btnList.setFont(font15);

		this.add(btnEdit);// 현재 클래스 내부에 생성해서 넣음...
		btnEdit.setBounds(80, 200, 140, 40);
		btnEdit.setFont(font15);

		this.add(btnDel);// 현재 클래스 내부에 생성해서 넣음...
		btnDel.setBounds(80, 250, 140, 40);
		btnDel.setFont(font15);

		this.add(btnClose);// 현재 클래스 내부에 생성해서 넣음...
		btnClose.setBounds(80, 350, 140, 40);
		btnClose.setFont(font15);

	}

	void start() {
		btnAdd.addActionListener(this);
		btnList.addActionListener(this);
		btnEdit.addActionListener(this);
		btnDel.addActionListener(this);

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
		if (e.getSource() == btnAdd) {
			BookAdd bookAdd = new BookAdd();
		} else if (e.getSource() == btnList) {
			GetBookList.mList.removeAll();
			GetBookList getBookList = new GetBookList();
		} else if (e.getSource() == btnEdit) {
			BookEdit bookEdit = new BookEdit();
		} else if (e.getSource() == btnDel) {
			BookDel bookDel = new BookDel();
		} else if (e.getSource() == btnClose) {
			viewClose();
		}
	}

}
