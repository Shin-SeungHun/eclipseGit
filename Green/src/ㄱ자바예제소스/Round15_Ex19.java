public class Round15_Ex19 {
	public static void main(String[] args) throws Exception{
		String str = "Hello Java!!!";
		char ch = str.charAt(3);
		System.out.println("ch = " + ch);
		String str1 = "www.daum.net";
		if(str1.endsWith("um.net")){
			System.out.println(".net ����Ʈ �Դϴ�.");
		}
		
		String str2 = "AbcD";
		String str3 = "abcd";
		if(str2.equalsIgnoreCase(str3)){
			System.out.println("����.");
		}
		
		String str4 = "java2java5";
		byte[] by = str4.getBytes();
		for(int i = 0; i < by.length; i++){
			System.out.println(i + " : " + (char)by[i]);
		}
		
		String name = "�����";
		byte[] by1 = name.getBytes("KSC5601");
		//byte[] by1 = name.getBytes("ISO8859_1");
		System.out.println(new String(by1));
		
		String email = "aaa.aaa@com";
		boolean a = email.indexOf("@") == -1;
		boolean b = email.indexOf(".") == -1;
		boolean c = email.indexOf("@") > email.indexOf(".");
		if(a == false && b == false && c == false){
			System.out.println("�̸��� ��Ģ�� �ùٸ��ϴ�.");
		}
		else{
			System.out.println("�̸��� ��Ģ�� �ùٸ��� �ʽ��ϴ�.");
		}
		
		String aaa = "aaa@bbb.com";
		//String bbb = aaa.substring(4, 7);
		String bbb = aaa.substring(aaa.indexOf("@") + 1, 
										aaa.indexOf("."));
		String ccc = aaa.substring(aaa.indexOf("@") + 1);
		System.out.println(bbb);
		
		char[] ddd = aaa.toCharArray();
		
		String eee = "FdkEasdjlEKJLFDSljfdsl";
		String fff = eee.toLowerCase();
		String ggg = eee.toUpperCase();
		
		String hhh = "       fjkldsajfldsa      ";
		String iii = hhh.trim();
		
		int x = 10;
		int y = 20;
		System.out.println(String.valueOf(x) + y);
		
		/*String str = "abc";
		String str_str = "abc";
		String str1 = new String("abc");
		String str1_str1 = new String("abc");*/
		
		String pass = new String("1234");
		if(pass == "1234"){
			System.out.println("==�� ������ �� ����.");
		}
		if(pass.equals("1234")){
			System.out.println("equals�� �� ���� �� ����.");
		}
	}
}
