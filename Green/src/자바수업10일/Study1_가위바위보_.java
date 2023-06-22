package 자바수업10일;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*가위바위보 게임
 * 내 선택 : 가위 바위 보
 * 게임시작 버튼
 * 컴퓨터: 대기중...
 * 멘트1:컴퓨터가 생각중
 * 멘트2:3
 * 멘트3:2
 * 멘트4:1
 * 컴퓨터 : 가위!
 * 1초에 한번씩 라벨에 멘트 변경후 컴퓨터 최종랜덤선택된 결과가 표시
 * 통계버튼: 다이얼로그로 퉁계출력
 * 통계
 * 총전적:0회, 승리:0회, 무승부:0회, 패배:0회
 * 
 * 결과는 다이얼로 창띄우기
 * 나의 승리 나의 패배 무승부!
 * */
public class Study1_가위바위보_ {

	public static void main(String[] args) {
		new Rck();

	}

}

class Rck extends Frame implements ActionListener, ItemListener {
	// 게임전적용변수
	int totCnt = 0, winCnt = 0, lossCnt = 0, drawCnt = 0; // 승리, 무승부, 패배, 총전적 변수
	String my = "가위";
	String com = "";
	Label lbTitle = new Label("가위바위보게임", Label.CENTER);
	Label lbChoice = new Label("내 선택");
	Label lbCom = new Label("컴퓨터:");
	Label lbCom1 = new Label("대기중...");
	Label lbResult = new Label("결과:");
	Label lbResult1 = new Label("나=  " + " vs 컴퓨터=");

	Button btnStart = new Button("게임시작");
	Button btnChart = new Button("통계버튼");

	Choice chRck = new Choice();

	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);

	Rck() {
		super("가위바위보"); // 제목
		this.setSize(300, 400);
		this.setLocation(600, 200);
		this.init();
		this.start();
		this.setVisible(true); // 마지막에 화면 띄움

	}

	void start() {
		chRck.addItemListener(this);
		btnStart.addActionListener(this);
		btnChart.addActionListener(this);

		// 창닫기
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	void init() {
		// 레이아웃 디폴트
		this.setLayout(null);

		// 클래스에 추가
		this.add(lbTitle);
		this.add(lbChoice);
		this.add(chRck);
		this.add(btnStart);
		this.add(lbCom);
		this.add(lbCom1);
		this.add(btnChart);
		this.add(lbResult);
		this.add(lbResult1);

		chRck.add("가위");
		chRck.add("바위");
		chRck.add("보");

		// 배치
		lbTitle.setBounds(50, 50, 200, 30);
		lbChoice.setBounds(30, 100, 55, 30);
		chRck.setBounds(100, 100, 70, 30);
		lbCom.setBounds(30, 150, 55, 30);
		lbCom1.setBounds(90, 150, 200, 30);
		lbResult.setBounds(30, 200, 40, 30);
		lbResult1.setBounds(75, 200, 200, 30);
		btnStart.setBounds(190, 97, 80, 30);
		btnChart.setBounds(110, 270, 80, 50);

		// 폰트적용
		lbTitle.setFont(font25);
		lbChoice.setFont(font15);
		chRck.setFont(font15);
		lbCom.setFont(font15);
		lbCom1.setFont(font15);
		btnStart.setFont(font15);
		btnChart.setFont(font15);
		lbResult.setFont(font15);
		lbResult1.setFont(font15);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnStart) {
			try {
				lbCom1.setText("검퓨터가 생각중입니다.");
				Thread.sleep(1000);
				lbCom1.setText("3...");
				Thread.sleep(1000);
				lbCom1.setText("2..");
				Thread.sleep(1000);
				lbCom1.setText("1.");
				Thread.sleep(1000);

				int comRand = (int) (Math.random() * 3);
				if (comRand == 0) {
					com = "가위";
				} else if (comRand == 1) {
					com = "바위";
				} else if (comRand == 2) {
					com = "보";
				}
				
				lbResult1.setText("나=" + my + "vs컴퓨터=" + com);
				
				String msg = "오류발생 다시하세요";
				if (com.equals("가위")) {
					if (my.equals("가위")) {
						msg = "무승부입니다.";
						drawCnt++;

					} else if (my.equals("바위")) {
						msg = "승리했습니다";
						winCnt++;
					} else if (my.equals("보")) {
						msg = "패배했습니다";
						lossCnt++;
					}
				} else if (com.equals("바위")) {
					if (com.equals("바위")) {
						msg = "무승부입니다.";
						drawCnt++;
					} else if (my.equals("보")) {
						msg = "승리했습니다";
						winCnt++;
					} else if (my.equals("가위")) {
						msg = "패배했습니다";
						lossCnt++;
					}
				} else if (com.equals("보")) {
					if (my.equals("보")) {
						msg = "무승부입니다.";
						drawCnt++;
					} else if (my.equals("바위")) {
						msg = "승리했습니다";
						winCnt++;
					} else if (my.equals("가위")) {
						msg = "패배했습니다";
						lossCnt++;
					}
				}
				dlgMsg(msg); // 결과멘트 다이얼로그처리
				lbCom1.setText("게임 재대결 대기중");
				totCnt++;// 총전적은 항상
			} catch (InterruptedException e1) {
			}
//			lbCom1.setText();
//			gameStart();
//			dlgmsg("승리");
		} else if (e.getSource() == btnChart) {

		}

		if (e.getSource() == btnChart) {
			dialog();
		}

	}

	public void dlgMsg(String msg) {
		Dialog dlg = new Dialog(this, "승부결과", true);
		Label lbContent = new Label(msg);
		Button bt = new Button("확인");
		dlg.setLayout(null);
		dlg.add(lbContent);
		lbContent.setFont(font15);
		dlg.add(bt);
		bt.setFont(font15);
		lbContent.setBounds(50, 50, 200, 30);
		bt.setBounds(80, 120, 120, 30);
		bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dlg.setVisible(false);
			}
		});
		
		dlg.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dlg.setVisible(false);
			}
		});

		dlg.setLocation(480, 250);
		dlg.setSize(300, 200);
		dlg.setVisible(true);
	}

	public void dialog() {
		Dialog dlg = new Dialog(this, "통계", true);
		Label lbTitle = new Label("통계");
		Label lbRecord = new Label("총전적: ");
		Label lbRecord1 = new Label(totCnt + "회");
		Label lbWin = new Label("승리: ");
		Label lbWin1 = new Label(winCnt + "회");
		Label lbDraw = new Label("무승부: ");
		Label lbDraw1 = new Label(drawCnt + "회");
		Label lbLoss = new Label("패배: ");
		Label lbLoss1 = new Label(lossCnt + "회");

		dlg.setLayout(null);

		dlg.add(lbTitle);
		dlg.add(lbRecord);
		dlg.add(lbRecord1);
		dlg.add(lbWin);
		dlg.add(lbWin1);
		dlg.add(lbDraw);
		dlg.add(lbDraw1);
		dlg.add(lbLoss);
		dlg.add(lbLoss1);

		lbTitle.setBounds(110, 50, 200, 30);
		lbRecord.setBounds(70, 100, 70, 30);
		lbRecord1.setBounds(170, 100, 100, 30);
		lbWin.setBounds(70, 150, 70, 30);
		lbWin1.setBounds(170, 150, 100, 30);
		lbDraw.setBounds(70, 200, 70, 30);
		lbDraw1.setBounds(170, 200, 100, 30);
		lbLoss.setBounds(70, 250, 70, 30);
		lbLoss1.setBounds(170, 250, 100, 30);

		lbTitle.setFont(font15);
		lbRecord.setFont(font15);
		lbRecord1.setFont(font15);
		lbWin.setFont(font15);
		lbWin1.setFont(font15);
		lbDraw.setFont(font15);
		lbDraw1.setFont(font15);
		lbLoss.setFont(font15);
		lbLoss1.setFont(font15);

		dlg.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dlg.setVisible(false);
			}
		});

		dlg.setLocation(480, 250);
		dlg.setSize(350, 400);
		dlg.setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		System.out.println(e.getItem());
		my = e.getItem().toString();
		System.out.println(my);

	}

}
