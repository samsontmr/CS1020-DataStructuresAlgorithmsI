import java.util.*;

class Instruction {
	int target;
	String[] operators;
	int[] operands;

	private int findClosest(int num, int idx) {
		if (idx == operators.length) return num;
		int notChosen = findClosest(num+0,idx+1);
		int chosen = 0; 
		if (operators[idx].equals("+")) {
			chosen = findClosest(num+operands[idx],idx+1);
		} else if (operators[idx].equals("-")) {
			chosen = findClosest(num-operands[idx],idx+1);
		} else if (operators[idx].equals("*")) {
			chosen = findClosest(num*operands[idx],idx+1);
		} else if (operators[idx].equals("/")) {
			chosen = findClosest(num/operands[idx],idx+1);
		}

		if (Math.abs(notChosen-target) == Math.abs(chosen-target)) {
			if (notChosen < chosen) return notChosen;
			return chosen;
		}
		if (Math.abs(notChosen-target) < Math.abs(chosen-target)) {
			return notChosen;
		}
		return chosen;
	}


	public void run() {	
		Scanner sc = new Scanner(System.in);
		int numI = sc.nextInt();
		target = sc.nextInt();
		operators = new String[numI];
		operands = new int[numI];

		for (int i = 0; i < numI; i++) {
			operators[i] = sc.next();
			operands[i] = sc.nextInt();
		}

		int result = findClosest(0, 0);
		System.out.println(result);
	}





	public static void main(String[] args) {
		Instruction inst = new Instruction();
		inst.run();
	}
}
