package 자바수업9일;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class Study4_윈도우_다이얼로그_회원가입 {
	public static void main(String[] args) {
		Join2 wt = new Join2();
	}
}
class Join2 extends Frame implements ItemListener, ActionListener{
	Label lbTitle = new Label("[[    회원 가입    ]]");
	Label lbId =    new Label("아 이 디:");
	Label lbPw =    new Label("패스워드:");
	Label lbName =  new Label("이   름:");
	Label lbHp =    new Label("연 락 처:");
	Label lbSex =    new Label("성   별:");
	TextField tfId = new TextField();
	TextField tfPw = new TextField();
	TextField tfName = new TextField();
	TextField tfHp = new TextField();
	Button btnIdCheck = new Button("중복확인");	
	Button btnJoin = new Button("가입하기");
	
	private Choice chSex = new Choice();
	
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);
	Join2()
	{
		super("회원가입");
		this.setSize(300,400);
		this.init();//화면레이아웃구성메서드
		start();
		this.setLocation(500, 200);
		this.setVisible(true);
		
	}	
	void start() {
		btnIdCheck.addActionListener(this);
		chSex.addItemListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	void init() //레이아웃 구성하기...
	{
		this.setLayout(null);//레이아웃을 직접좌표처리하는방식으로하기위해서...		
		this.add(lbTitle);
		lbTitle.setFont(font25);
		lbTitle.setBounds(50, 50, 200, 30);
		
		this.add(lbId);			lbId.setFont(font15);		lbId.setBounds(30, 100, 80, 30);		
		this.add(tfId);			tfId.setFont(font15);		tfId.setBounds(110, 100, 80, 30);
		this.add(btnIdCheck);	btnIdCheck.setFont(font15);	btnIdCheck.setBounds(200, 100, 80, 30);
		
		this.add(lbPw);			lbPw.setFont(font15);		lbPw.setBounds(30, 150, 80, 30);		
		this.add(tfPw);			tfPw.setFont(font15);		tfPw.setBounds(110, 150, 80, 30);
		
		this.add(lbName);		lbName.setFont(font15);		lbName.setBounds(30, 200, 80, 30);		
		this.add(tfName);		tfName.setFont(font15);		tfName.setBounds(110, 200, 120, 30);
		
		this.add(lbHp);			lbHp.setFont(font15);		lbHp.setBounds(30, 250, 80, 30);		
		this.add(tfHp);			tfHp.setFont(font15);		tfHp.setBounds(110, 250, 120, 30);
		
		
		this.add(lbSex); lbSex.setFont(font15);				lbSex.setBounds(30, 300, 80, 30);
		this.add(chSex); chSex.setFont(font15);				chSex.setBounds(110, 300, 120, 30);
		chSex.add("남자"); chSex.add("여자");
		
		
		this.add(btnJoin);		btnJoin.setFont(font15);	btnJoin.setBounds(110, 340, 80, 30);
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		System.out.println("select sex = "+ chSex.getSelectedIndex());
		System.out.println("select sex = "+ chSex.getSelectedItem());
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {		
		Dialog dlg = new Dialog(this, "중복체크", true);
		Label lbContent = new Label("아이디가 중복되었습니다.");
		Button bt = new Button("확인");		
		dlg.setLayout(null);		
		dlg.add(lbContent);	 lbContent.setFont(font15);
		dlg.add(bt);		 bt.setFont(font15);
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
		dlg.setLocation(480,250);
		dlg.setSize(300, 200);
		dlg.setVisible(true);
		
		
		
		


		
	}
}








