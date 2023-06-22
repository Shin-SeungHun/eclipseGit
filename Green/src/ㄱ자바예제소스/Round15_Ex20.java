import java.io.*;
public class Round15_Ex20 {
	public static String getType(long su){
		String type = "";
		if(su >= Byte.MIN_VALUE && su <= Byte.MAX_VALUE){
			type = "byte";
		}
		else if(su >= Short.MIN_VALUE && su <= Short.MAX_VALUE){
			type = "short";
		}
		else if(su >= Integer.MIN_VALUE && su <= Integer.MAX_VALUE){
			type = "int";
		}
		else{
			type = "long";
		}
		return type;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("su1 = ");
		long su1 = Long.parseLong(in.readLine());
		System.out.print("yon = ");
		char yon = (char)System.in.read();
		System.in.read();
		System.in.read();
		System.out.print("su2 = ");
		long su2 = Long.parseLong(in.readLine());
		
		System.out.println(getType(su1)+" a = "+su1+";");
		System.out.println("char b = '" + yon + "'");
		System.out.println(getType(su2)+" c = "+su2+";");
		String type = "";
		switch(yon){
			case '+': type = getType(su1 + su2); break;
			case '-': type = getType(su1 - su2); break;
			case '*': type = getType(su1 * su2); break;
			case '/': type = getType(su1 / su2); break;
		}
		System.out.println(type + " d = a " + yon + " b;");
	}	
}
