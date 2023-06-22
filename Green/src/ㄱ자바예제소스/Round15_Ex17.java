import java.lang.reflect.Field;
public class Round15_Ex17 {
	public static void main(String[] args)
						 throws ClassNotFoundException{
		Class cls = Class.forName("java.lang.Boolean");
		System.out.println("cls = " + cls);
		Field[] fld = cls.getFields();
		for(int i = 0; i < fld.length; i++){
			System.out.println(i + " : " + fld[i].getName());
		}
		
	}
}
