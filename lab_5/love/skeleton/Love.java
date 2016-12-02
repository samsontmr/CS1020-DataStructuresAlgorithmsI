/**
 * Name			: Samson Tan
 * Matric No.	: A0140060A
 */
import java.util.*;

public class Love {
	
	public void run() {
		// treat this as your "main" method
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		List<String> list = new ArrayList<String>();
		while (num-- > 0) {
			String in = sc.next();
			list.add(in);
			if (map.containsKey(in)) {
				map.put(in, map.get(in)+1);
			} else {
				map.put(in,1);
			}
		}
		
		int min = Integer.MAX_VALUE;
		
		HashMap<String, Integer> check = new HashMap<String, Integer>();		
		Queue<String> queue = new LinkedList<String>();
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
				queue.offer(list.get(i));
				if (check.containsKey(list.get(i))) {
					check.put(list.get(i), check.get(list.get(i))+1);
				} else {
					check.put(list.get(i),1);
				}				
				sum += list.get(i).length();
			if (check.size() == map.size()) {
				while (check.get(queue.peek()) > 1) {
					check.put(queue.peek(), check.get(queue.peek())-1);
					sum -= queue.poll().length();
				}
				if (sum < min) min = sum;
			}
		}
		if (check.size() == map.size() && sum < min) min = sum;
		
		System.out.println(min);
	}

	public static void main(String[] args) {
		Love myLove = new Love();
		myLove.run();
	}

}
