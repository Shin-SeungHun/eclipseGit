import java.util.Properties;
public class Round15_Ex15 {
	public static void main(String[] args) {
		Boolean bool = Boolean.FALSE;//boolean a = false;
		Boolean bool1 = Boolean.TRUE;//boolean b = true;
		
		Boolean bool2 = new Boolean(true);
		Boolean bool3 = new Boolean("false");
		
		boolean a = bool2.booleanValue();
		System.out.println("a = " + a);
		
		boolean b = bool2.equals(bool3);
		System.out.println("b = " + b);
		
		System.out.println("bool = " + bool);
		System.out.println("bool = " + bool.toString());
		
		Boolean e = Boolean.valueOf(b);
		Boolean f = Boolean.valueOf("true");
		
		System.out.println("e = " + e);//false
		System.out.println("f = " + f);//true
		
		boolean bbbb = false;
		
		Boolean bo = new Boolean(bbbb);
		int i = new Boolean(bbbb).hashCode();
		
		int j = Boolean.valueOf(bbbb).hashCode();
		
		Boolean bool4 = Boolean.TRUE;
		Boolean bool5 = Boolean.TRUE;
		System.out.println("bool hash = " + bool4.hashCode());
		System.out.println("bool1 hash = " + bool5.hashCode());
		System.out.println(bool4 == bool5);
		System.out.println(bool4.equals(bool5));
		
		Properties prop = System.getProperties();
		prop.put("class", "true");
		System.setProperties(prop);
		boolean bb = Boolean.getBoolean("class");
		System.out.println(bb);
	}
}
