import java.io.*;
public class Round15_Ex16 {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true){
		
		System.out.print("수 = ");
		long su = Long.parseLong(in.readLine());
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
		System.out.println(type + "에 담기 적당!!");
		
		}
	}
}
