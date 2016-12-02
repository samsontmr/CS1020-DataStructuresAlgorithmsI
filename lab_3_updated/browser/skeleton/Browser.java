
/**
 *	Name		: Samson Tan Min Rong
 *	Matric No.	: A0140060A
 */

import java.util.*;
import java.util.LinkedList;

public class Browser {
	private LinkedList<String> tabs;
	int curTab;
	boolean debug = false;

	public Browser() {
		tabs = new LinkedList<String>();
		tabs.addFirst("http://www.comp.nus.edu.sg");
	}
	
	public void newTab(String name){
		tabs.add(curTab + 1, name);
		System.out.println(tabs.get(curTab));
	}

	public void openHere(String name) {
		tabs.set(curTab, name);
		System.out.println(name);
	}

	public void nextTab() {
		if (curTab + 1 < tabs.size()) {
			curTab++;
		}
		System.out.println(tabs.get(curTab));
	}

	public void prevTab() {
		if (curTab > 0) {
			curTab--;
		}
		System.out.println(tabs.get(curTab));
	}

	public void closeTab() {
		tabs.remove(curTab);
		if (curTab >= tabs.size()) curTab--;
		System.out.println(tabs.get(curTab));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		Browser brwsr = new Browser();
		while(num-- > 0) {
			String nxt = sc.next();
			if (nxt.equals("NEWTAB")) {
				brwsr.newTab("http://www.comp.nus.edu.sg");
			} else if (nxt.equals("CLOSETAB")) {
				brwsr.closeTab();
			} else if (nxt.equals("NEXTTAB")) {
				brwsr.nextTab();
			} else if (nxt.equals("PREVTAB")) {
				brwsr.prevTab();
			} else if (nxt.equals("OPENHERE")) {
				brwsr.openHere(sc.next());
			} else if (nxt.equals("OPENNEW")) {
				brwsr.newTab(sc.next());
			}
		}

	}
}
