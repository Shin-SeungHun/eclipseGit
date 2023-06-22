package ㄱ자바예제소스;

import java.util.*;
class A23{}
class B23{}
public class Round15_Ex23 {
	public static void main(String[] args) {
		HashSet hs = new HashSet();
		A23 ap = new A23();
		B23 bp = new B23();
		String cp = "ABC";
		hs.add(ap);
		hs.add(bp);
		hs.add(cp);
		Iterator it = hs.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
	}
}
