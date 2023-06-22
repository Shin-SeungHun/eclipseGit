import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import java.util.*;

import ksh.util.mydb.*;

public class Round27_Ex13 extends JApplet implements ActionListener {
	private Container con;

	private CardLayout cl = new CardLayout();

	private JPanel first_pane = new JPanel(new BorderLayout(5, 5));

	private JPanel second_pane = new JPanel();

	private JLabel title_lb = new JLabel("JDBC 설정정보", JLabel.CENTER);

	private JLabel driver_lb = new JLabel("Driver = ", JLabel.RIGHT);

	private JLabel url_lb = new JLabel("URL = ", JLabel.RIGHT);

	private JLabel id_lb = new JLabel("ID = ", JLabel.RIGHT);

	private JLabel pass_lb = new JLabel("Password = ", JLabel.RIGHT);

	private JTextField driver_tf = new JTextField();

	private JTextField url_tf = new JTextField();

	private JTextField id_tf = new JTextField();

	private JTextField pass_tf = new JTextField();

	private JButton set_bt = new JButton("설정");

	private JLabel title1_lb = new JLabel("해당 데이터베이스 테이블들!", JLabel.CENTER);

	private Vector data_vc = new Vector();

	private Vector field_vc = new Vector();

	private JTable view_jt;

	private JScrollPane view_jsp;

	public void init() {
		con = this.getContentPane();
		con.setLayout(cl);
		first_pane.add("North", title_lb);
		JPanel jp = new JPanel(new BorderLayout(5, 5));
		JPanel jp1 = new JPanel(new GridLayout(4, 1, 5, 5));
		jp1.add(driver_lb);
		jp1.add(url_lb);
		jp1.add(id_lb);
		jp1.add(pass_lb);
		jp.add("West", jp1);
		JPanel jp2 = new JPanel(new GridLayout(4, 1, 5, 5));
		jp2.add(driver_tf);
		jp2.add(url_tf);
		jp2.add(id_tf);
		jp2.add(pass_tf);
		jp.add("Center", jp2);
		first_pane.add("Center", jp);
		JPanel jp3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jp3.add(set_bt);
		first_pane.add("South", jp3);
		con.add("intro", first_pane);

		field_vc.add("Number");
		field_vc.add("Table Name");
		view_jt = new JTable(data_vc, field_vc);
		view_jsp = new JScrollPane(view_jt);
		second_pane.setLayout(new BorderLayout());
		second_pane.add("North", title1_lb);
		second_pane.add("Center", view_jsp);
		con.add("database", second_pane);
	}

	public void start() {
		set_bt.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == set_bt) {
			String driver = driver_tf.getText().trim();
			String url = url_tf.getText().trim();
			String id = id_tf.getText().trim();
			String pass = pass_tf.getText().trim();
			// DBConn dc = DBConn.getInstance();
			/*
			 * try { Class.forName("org.gjt.mm.mysql.Driver");
			 * }catch(ClassNotFoundException ee) {} Connection conn = null; try {
			 * conn = DriverManager.getConnection(
			 * "jdbc:mysql://localhost:3306/java", "root", "12345678");
			 * }catch(SQLException ee) {} PreparedStatement pstmt = null; try {
			 * String query = "insert into dbset_history values (null, ?, ?, ?,
			 * ?)"; pstmt = conn.prepareStatement(query); pstmt.setString(1,
			 * driver); pstmt.setString(2, url); pstmt.setString(3, id);
			 * pstmt.setString(4, pass); pstmt.executeUpdate(); pstmt.close();
			 * conn.close(); }catch(SQLException ee) { System.err.println("error = " +
			 * ee.toString()); }
			 */
			try {
				Class.forName("org.gjt.mm.mysql.Driver");
			} catch (ClassNotFoundException ee) {
			}
			try {
				Connection conn = DriverManager.getConnection(url, id, pass);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("show tables");
				int i = 1;
				while (rs.next()) {
					Vector imsi = new Vector();
					imsi.add(String.valueOf(i++));
					imsi.add(rs.getString(1));
					data_vc.add(imsi);
				}
				rs.close();
				stmt.close();
				conn.close();
				view_jt.updateUI();
			} catch (SQLException ee) {
			}
			cl.show(con, "database");
		}
	}
}
