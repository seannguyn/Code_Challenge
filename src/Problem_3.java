import java.util.*;
public class Problem_3 {
/*
 * 		Find the longest increasing subsequence
 */
	
	public static void main(String[] args) {
		int[] array_0 = new int[] {3, 10, 2, 1, 20};
		
		longestIncreasingSubsequence(array_0);
		System.out.println("================================");
		
		int[] array_1 = new int[] {50, 3, 10, 7, 40, 80};
		longestIncreasingSubsequence(array_1);
		
		System.out.println("================================");
		
		int[] array_2 = new int[] { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		longestIncreasingSubsequence(array_2);
	}
	
	public static void longestIncreasingSubsequence(int[] array) {
		
		TreeMap<Integer, LinkedList<Integer>> tm = new TreeMap<Integer, LinkedList<Integer>>();
		
		for (int i : array) {
			LinkedList<Integer> seq = new LinkedList<Integer>();
			seq.add(i);
			tm.put(i,seq);
		}
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				if (array[i] > array[j]) {
					LinkedList<Integer> oldList = tm.get(array[j]);
					LinkedList<Integer> newList = new LinkedList<Integer>(oldList);
					newList.add(array[i]);
					LinkedList<Integer> currentList = tm.get(array[i]);
					
					if (currentList.size() < newList.size()) {
						tm.put(array[i], newList);
					}
				}
			}
		}
		
		LinkedList<Integer> max = null;
		for (int i : tm.keySet()) {
			if (max == null) {
				max = tm.get(i);
			} else if (max.size() < tm.get(i).size()) {
				max = tm.get(i);
			}
		}
		
		System.out.println("Longest subsequence has length of: "+max.size());
		for (int i : max) {
			System.out.print(i+" ");
		}
		System.out.println();
		
	}
}
