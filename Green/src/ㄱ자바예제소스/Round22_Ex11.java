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
		Color cc = jcc.showDialog(this, "���� ������", Color.black);
		System.out.println("������ ���� = " + cc);
		jcc.setColor(cc); // �⺻ ���� ������ �α�
		System.out.println("�ٽ� ������ = " + jcc.getColor());
		jfc.setDialogTitle("ȣȣȣ"); // ���̾�α� ��ư ���� �ٲٱ�
		jfc.setMultiSelectionEnabled(true); // ���� ���� �����ϰ� �����
		jfc.setApproveButtonToolTipText("�����϶�� ���ڰ� �����ֳ׿�.."); // ��ư�� Tooltip
																// ǥ���ϱ�
		jfc.showDialog(this, "������");
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
