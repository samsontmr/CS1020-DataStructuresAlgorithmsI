import java.util.*;

public class PSI {
	static int[] sums;
	static int count;
	static int invCount;

	@SuppressWarnings("rawtypes") 
	public static int[] mergeSort(int[] list) {
	//If list is empty; no need to do anything
		if (list.length <= 1) {
			return list;
		}
	//Split the array in half in two parts
		int[] first = new int[list.length / 2];
		int[] second = new int[list.length - first.length];
		System.arraycopy(list, 0, first, 0, first.length);
		System.arraycopy(list, first.length, second, 0, second.length);
		
		//Sort each half recursively
		mergeSort(first);
		mergeSort(second);
		
		//Merge both halves together, overwriting to original array
		merge(first, second, list);
		return list;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" }) 
	private static void merge(int[] first, int[] second, int[] result) {
	//Index Position in first array - starting with first element
		int iFirst = 0;
	
	//Index Position in second array - starting with first element
		int iSecond = 0;
	//Index Position in merged array - starting with first position
		int iMerged = 0;
	
	//Compare elements at iFirst and iSecond, 
	//and move smaller element at iMerged
		while (iFirst < first.length && iSecond < second.length) {
			if (first[iFirst] < second[iSecond]) { 
				result[iMerged] = first[iFirst];
				iFirst++;
			} else {
				result[iMerged] = second[iSecond];
				invCount += first.length - iFirst;
				iSecond++;
			}
			iMerged++;
		}
	//copy remaining elements from both halves - each half will have already sorted elements
		System.arraycopy(first, iFirst, result, iMerged, first.length - iFirst);
		System.arraycopy(second, iSecond, result, iMerged, second.length - iSecond);
	}
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int numI = sc.nextInt();
		int[] input = new int[numI];
		sums = new int[numI];
		for (int i = 0; i < numI; i++) {
			input[i] = sc.nextInt();
		}
		sums[0] = input[0];
		for (int i = 1; i < sums.length; i++) {
			sums[i] = sums[i-1] + input[i];	
			if (sums[i] > 0) count++;
		}

		mergeSort(sums);
		count += numI*(numI-1)/2 - invCount;
		System.out.println(count);

	}
    
}
