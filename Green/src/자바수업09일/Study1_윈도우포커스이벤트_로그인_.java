package 자바수업09일;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Study1_윈도우포커스이벤트_로그인_ {
	public static void main(String[] args) {	
		Login log = new Login();
	}
}
class Login extends Frame implements FocusListener, ActionListener{
	Label lbTitle = new Label("로그인화면");
	Label lbId = new Label("아이디:");
	Label lbPw = new Label("패스워드:");
	TextField tfId = new TextField();
	TextField tfPw = new TextField();
	Button btnLogin = new Button("로그인");	
	Button btnJoin = new Button("회원가입");
	
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);
	Login()
	{
		super("로그인화면");
		this.setSize(300,400);
		this.init();//화면레이아웃구성메서드
		this.start();//이벤트메서드처리
		this.setLocation(500, 300);
		this.setVisible(true);
		
	}	
	void start()
	{
		btnLogin.addActionListener(this);
		tfId.addFocusListener(this);
		tfPw.addFocusListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	void init() //레이아웃 구성하기...
	{
		this.setLayout(null);//레이아웃을 직접좌표처리하는방식으로하기위해서...
		this.add(lbTitle);//현재 클래스 내부에 생성해서 넣음...
		lbTitle.setBounds(60, 40, 220, 30);
		lbTitle.setFont(font25);
		
		this.add(lbId);//현재 클래스 내부에 생성해서 넣음...
		lbId.setBounds(40, 120, 70, 30);
		lbId.setFont(font15);

		this.add(tfId);//현재 클래스 내부에 생성해서 넣음...
		tfId.setBounds(150, 120, 100, 30);
		tfId.setFont(font15);

		
		this.add(lbPw);//현재 클래스 내부에 생성해서 넣음...
		lbPw.setBounds(40, 170, 100, 30);
		lbPw.setFont(font15);

		this.add(tfPw);//현재 클래스 내부에 생성해서 넣음...
		tfPw.setBounds(150, 170, 100, 30);
		tfPw.setFont(font15);
		
		this.add(btnLogin);//현재 클래스 내부에 생성해서 넣음...
		btnLogin.setBounds(100, 250, 100, 30);
		btnLogin.setFont(font15);
		
		this.add(btnJoin);//현재 클래스 내부에 생성해서 넣음...
		btnJoin.setBounds(100, 300, 100, 30);
		btnJoin.setFont(font15);
		
		
	}
	@Override
	public void focusGained(FocusEvent e) {
		if(e.getSource() == tfId) {}
		else if(e.getSource() == tfPw) {
			if(tfId.getText().equals(""))
			{
				tfId.requestFocus();
				System.out.println("Id input plz...");
			}
			int check = tfId.getText().trim().length();
			if(check>12)
			{
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
		if(e.getSource() == btnLogin)
		{
			if(tfId.getText().equals(""))
			{
				System.out.println("Id input...plz...");
				return;
			}
			if(tfPw.getText().equals(""))
			{
				System.out.println("Pw input...plz...");
				return;
			}
		}
		
	}
}

