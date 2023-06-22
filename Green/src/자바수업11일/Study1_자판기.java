//package 자바수업11일;
//
//import java.awt.Button;
//import java.awt.Dialog;
//import java.awt.Font;
//import java.awt.Frame;
//import java.awt.Graphics;
//import java.awt.Image;
//import java.awt.Label;
//import java.awt.Toolkit;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//
//
//public class Study1_자판기 {
//	public static void main(String[] args) {
//		Japangi jj = new Japangi();
//
//	}
//}
//
//class Japangi extends Frame implements ActionListener{
//	int totPrice;
//	int jan;
//	
//
//	
//	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
//	Font font15 = new Font("SansSerif", Font.BOLD, 15);
//	Label lbTitle = new Label("자판기프로그램");
//	Label lbGoods1 = new Label("아메리카노", Label.CENTER);
//	Label lbGoods2 = new Label("라떼", Label.CENTER);
//	Label lbGoods3 = new Label("딸기요거트", Label.CENTER);
//	Label lbSelPrice1 = new Label("현재주문상품", Label.CENTER);
//	Label lbSelPrice2 = new Label("결제금액", Label.CENTER);
//	Label lbSelPrice3 = new Label("0원", Label.RIGHT);
//	Label lbCoin1 = new Label("투입금액");
//	Label lbCoin2 = new Label("현재잔액");
//	Label lbCoin3 = new Label("0원", Label.RIGHT);
//	Button btnGoods1 = new Button("4500원");
//	Button btnGoods2 = new Button("5000원");
//	Button btnGoods3 = new Button("6000원");
//	Button btnSel1 = new Button("상품1취소");
//	Button btnSel2 = new Button("상품2취소");
//	Button btnSel3 = new Button("상품3취소");
//	Button btn1000 = new Button("1000원");
//	Button btn5000 = new Button("5000원");
//	Button btn10000 = new Button("10000원");
//	Button btnCash = new Button("결제하기");
//	Button btnCancel = new Button("결제취소(반환)");
//	Image imgGoods1;
//	Image imgGoods2;
//	Image imgGoods3;
//	Image imgIng;
//
//	Japangi() {
//		super("자판기프로그램");
//		this.setSize(450, 550);
//		this.init();
//		this.start();
//		this.setLocation(500, 150);
//		this.setVisible(true);
//	}
//
//	void init() {
//		this.setLayout(null);
//
//		// 프레임에 추가..
//		this.add(lbTitle);
//		this.add(lbGoods1);
//		this.add(lbGoods2);
//		this.add(lbGoods3);
//		this.add(lbSelPrice1);
//		this.add(lbSelPrice2);
//		this.add(lbSelPrice3);
//		this.add(lbCoin1);
//		this.add(lbCoin2);
//		this.add(lbCoin3);
//
//		this.add(btnGoods1);
//		this.add(btnGoods2);
//		this.add(btnGoods3);
//		this.add(btnSel1);
//		this.add(btnSel2);
//		this.add(btnSel3);
//		this.add(btn1000);
//		this.add(btn5000);
//		this.add(btn10000);
//		this.add(btnCash);
//		this.add(btnCancel);
//
//		// 폰트셋팅
//		lbTitle.setFont(font25);
//		lbGoods1.setFont(font15);
//		lbGoods2.setFont(font15);
//		lbGoods3.setFont(font15);
//		lbSelPrice1.setFont(font15);
//		lbSelPrice2.setFont(font15);
//		lbSelPrice3.setFont(font15);
//		lbCoin1.setFont(font15);
//		lbCoin2.setFont(font15);
//		lbCoin3.setFont(font15);
//		btnGoods1.setFont(font15);
//		btnGoods2.setFont(font15);
//		btnGoods3.setFont(font15);
//		btnSel1.setFont(font15);
//		btnSel2.setFont(font15);
//		btnSel3.setFont(font15);
//		btn1000.setFont(font15);
//		btn5000.setFont(font15);
//		btn10000.setFont(font15);
//		btnCash.setFont(font15);
//		btnCancel.setFont(font15);
//
//		imgGoods1 = Toolkit.getDefaultToolkit().getImage("img/goods1.png");
//		imgGoods2 = Toolkit.getDefaultToolkit().getImage("img/goods2.png");
//		imgGoods3 = Toolkit.getDefaultToolkit().getImage("img/goods3.png");
//		imgIng = Toolkit.getDefaultToolkit().getImage("img/ing.gif");
//
//		// 배치
//		lbTitle.setBounds(120, 50, 250, 30);
//
//		lbGoods1.setBounds(50, 210, 110, 30);
//		lbGoods2.setBounds(160, 210, 110, 30);
//		lbGoods3.setBounds(270, 210, 110, 30);
//
//		btnGoods1.setBounds(50, 240, 110, 30);
//		btnGoods2.setBounds(160, 240, 110, 30);
//		btnGoods3.setBounds(270, 240, 110, 30);
//
//		lbSelPrice1.setBounds(30, 290, 110, 30);
//		lbSelPrice2.setBounds(30, 320, 110, 30);
//		lbSelPrice3.setBounds(30, 350, 110, 30);
//
//		btnSel1.setBounds(170, 350, 80, 30);
//		btnSel2.setBounds(260, 350, 80, 30);
//		btnSel3.setBounds(350, 350, 80, 30);
//
//		lbCoin1.setBounds(50, 390, 80, 30);
//		btn1000.setBounds(50, 420, 70, 30);
//		btn5000.setBounds(130, 420, 70, 30);
//		btn10000.setBounds(210, 420, 70, 30);
//
//		lbCoin2.setBounds(50, 460, 100, 30);
//		lbCoin3.setBounds(190, 460, 100, 30);
//
//		btnCash.setBounds(320, 420, 115, 30);
//		btnCancel.setBounds(320, 470, 115, 30);
//
//	}
//
//	public void paint(Graphics g) {
//		g.drawImage(imgGoods1, 50, 100, 100, 100, this);
//		g.drawImage(imgGoods2, 170, 100, 100, 100, this);
//		g.drawImage(imgGoods3, 290, 100, 100, 100, this);
//		g.drawImage(imgIng, 170, 290, 80, 60, this);
//		g.drawImage(imgIng, 260, 290, 80, 60, this);
//		g.drawImage(imgIng, 350, 290, 80, 60, this);
//		// g.drawImage(imgIng, 290, 100, 100, 100, this);
//		// g.drawImage(imgIng, 290, 100, 100, 100, this);
//	}
//
//	void start() {
//		this.addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent e) {
//				System.exit(0);
//			}
//		});
//	}
//
//	void dlgMsg(String msg) {
//		Dialog dlg = new Dialog(this, "승부결과", true);
//		Label lbContent = new Label(msg);
//		Button bt = new Button("확인");
//		dlg.setLayout(null);
//		dlg.add(lbContent);
//		lbContent.setFont(font15);
//		dlg.add(bt);
//		bt.setFont(font15);
//		lbContent.setBounds(50, 50, 200, 30);
//		bt.setBounds(80, 120, 120, 30);
//		bt.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				dlg.setVisible(false);
//			}
//		});
//		dlg.addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent e) {
//				dlg.setVisible(false);
//			}
//		});
//		dlg.setLocation(480, 250);
//		dlg.setSize(300, 200);
//		dlg.setVisible(true);
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		if(e.getSource()==btnGoods1) {
//			if(goods1Sel =false) {
//				
//			}
//		}
//		
//	}
//}
