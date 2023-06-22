package ㄱ자바예제소스;

import java.util.*;
class A24{}
class B24{}
public class Round15_Ex24 {
	public static void main(String[] args) {
		Vector vc = new Vector();
		A24 ap = new A24();
		B24 bp = new B24();
		String cp = "TEST";
		vc.addElement(ap);//0
		vc.add(bp);//1
		vc.add(cp);//2
		for(int i = 0; i < vc.size(); i++){
			Object obj = vc.elementAt(i);
			System.out.println(i + " : " + obj);
		}
		Enumeration enu = vc.elements();
		while(enu.hasMoreElements()){
			System.out.println(enu.nextElement());
		}
	}
}
