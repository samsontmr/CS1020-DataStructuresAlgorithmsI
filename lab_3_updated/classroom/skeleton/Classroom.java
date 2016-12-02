
/**
 *	Name		: Samson Tan Min Rong
 *	Matric No.	: A0140060A
 */

import java.util.*;

public class Classroom {
	private static LinkedList<String> stlist = new LinkedList<String>();
	
	public static void enter(String st1, String st2, int k) {
		k += stlist.indexOf(st2);
		k %= stlist.size();
		k++;
		stlist.add(k, st1);
	}

	public static void leave(String st) {
		stlist.remove(st);	
	}

	public static void list() {
		for (int i = 0; i < stlist.size() - 1; i++) {
			System.out.print(stlist.get(i) + " ");
		}
		System.out.println(stlist.get(stlist.size()-1));
	}


	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		stlist.add("Sharon");
		while (num-- > 0) {
			String cmd = sc.next();
			if (cmd.equals("enter")) {
				enter(sc.next(), sc.next(), sc.nextInt());
			} else if (cmd.equals("leave")) {
				leave(sc.next());
			} else if (cmd.equals("list")) {
				list();
			}
		}
	}

}
