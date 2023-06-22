import java.sql.*;
import java.io.*;

public class Round27_Ex09 implements Serializable {
	private int number;

	private String name;

	private String id;

	private String pass;

	private String email;

	public Round27_Ex09() {
	}

	public Round27_Ex09(int number, String name, String id, String pass,
			String email) {
		this.number = number;
		this.name = name;
		this.id = id;
		this.pass = pass;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getNumber() {
		return number;
	}

	public String getPass() {
		return pass;
	}

	public void setEmail(String string) {
		email = string;
	}

	public void setId(String string) {
		id = string;
	}

	public void setName(String string) {
		name = string;
	}

	public void setNumber(int i) {
		number = i;
	}

	public void setPass(String string) {
		pass = string;
	}
}
