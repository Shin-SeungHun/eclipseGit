import java.awt.*;
import javax.swing.*;

class Round22_Ex11_Sub extends JFrame {
	private JColorChooser jcc = new JColorChooser();

	private JFileChooser jfc = new JFileChooser("C://");

	public Round22_Ex11_Sub() {
		super("Test");
		this.init();
		this.start();
		this.setSize(300, 200);
		this.setVisible(true);
		Color cc = jcc.showDialog(this, "나의 색상선택", Color.black);
		System.out.println("선택한 색상 = " + cc);
		jcc.setColor(cc); // 기본 색상 지정해 두기
		System.out.println("다시 얻어오기 = " + jcc.getColor());
		jfc.setDialogTitle("호호호"); // 다이얼로그 버튼 글자 바꾸기
		jfc.setMultiSelectionEnabled(true); // 다중 선택 가능하게 만들기
		jfc.setApproveButtonToolTipText("하하하라는 글자가 찍혀있네요.."); // 버튼에 Tooltip
																// 표시하기
		jfc.showDialog(this, "하하하");
		// jfc.showOpenDialog(this);
		// jfc.showSaveDialog(this);
	}

	public void init() {

	}

	public void start() {

	}
}

public class Round22_Ex11 {
	public static void main(String[] ar) {
		Round22_Ex11_Sub es = new Round22_Ex11_Sub();
	}
}
