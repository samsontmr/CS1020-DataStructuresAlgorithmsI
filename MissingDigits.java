import java.util.*;

public class MissingDigits {
	public static boolean[] checkDigits(int[] intArr) {
		boolean[] checkDig;
		checkDig = new boolean[10];

		for (int digit: intArr) {
			checkDig[digit] = true;
		}
		return checkDig;
	}
	
	public static void printDigits(boolean[] boolArr) {
		for (int i = 0; i < 10; i++) {
			if (!boolArr[i]) {
				System.out.printf("%d ", i);
			}
		}
	}

	public static void main(String[] args) {
		int input, count;
		int[] digArr;
		boolean[] arr;

		System.out.print("Enter a number: ");
		Scanner sc = new Scanner(System.in);
		input = Integer.parseInt(sc.nextLine());
	
		System.out.printf("Missing digits in %d: ", input);
		digArr = new int[(int) Math.log10(input) + 1];
		count = 0;
		while (input > 0) {
			digArr[count] = input % 10;
			input /= 10;
			count++;
		}

		printDigits(checkDigits(digArr));
	}
}

