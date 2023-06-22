import java.util.*;
class AAA{}
class BBB{}
public class Round15_Ex25 {
	public static void main(String[] args) {
		Hashtable ht = new Hashtable();
		AAA ap = new AAA();
		BBB bp = new BBB();
		String cp = "JAVA";
		ht.put("kim", ap);
		ht.put("lee", bp);
		ht.put("park", cp);
		//Object obj = ht.get("kim");
		Enumeration keys = ht.keys();
		System.out.println("Keys!!!");
		while(keys.hasMoreElements()){
			System.out.println(keys.nextElement());
		}
		System.out.println("Keys End!!");
		System.out.println("Values!!!");
		Enumeration elements = ht.elements();
		while(elements.hasMoreElements()){
			System.out.println(elements.nextElement());
		}
		System.out.println("Values End!!!");			
	}
}
