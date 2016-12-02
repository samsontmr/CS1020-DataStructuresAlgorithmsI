/**
* Name: Samson Tan Min Rong
* Matric Number: A0140060A
*/

import java.util.*;

public class Swing {
	long count;
	Stack<Integer> temp = new Stack<Integer>();

	public void calc(int nextValue) {
		if (temp.empty()) {
			temp.push(nextValue);
		} else {
			if (nextValue > temp.peek()) {
				temp.pop();
				calc(nextValue);
			} else if (nextValue < temp.peek()) {
				temp.push(nextValue);
			}
			count++;
		}
	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		while (num-- > 0) {
			calc(sc.nextInt());
		}

		System.out.println(count);
	}

    public static void main(String[] args) {
        //implement your main method here
		Swing swing = new Swing();
		swing.run();
    }

}
