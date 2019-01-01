package Hard;
import java.util.*;
public class Hard_5 {
	
	/*
	 * 		find the maximum increasing sum of sequence
	 * 
	 */
	
	public static void main (String args[]) {
		System.out.println("starting");
		maximumIncreasingSum(new int[] {10,15,4,5,11,14,31,25,31,23,25,31,50});
	}
	
	public static int[][] maximumIncreasingSum(int[] array) {
		
		HashMap<Integer,ArrayList<Integer>> seq = new HashMap<Integer,ArrayList<Integer>>();
		HashMap<Integer,Integer> sum = new HashMap<Integer,Integer>();
		int max = array[0];
		int key = array[0];
		
		for (int i : array) {
			ArrayList<Integer> numSeq = new ArrayList<Integer>();
			numSeq.add(i);
			seq.put(i, numSeq);
			sum.put(i, i);
		}
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				
				int temp1 = (int) sum.get(array[i]);
				int temp2 = (int) sum.get(array[j]) + array[i];
				
				if (array[i] > array[j] && (temp2 > temp1)) {
					
					sum.put(array[i], temp2);
					
					if (temp2 > max) {
						max = temp2;
						key = array[i];
					}
					
					ArrayList<Integer> newSeq = new ArrayList<Integer>(seq.get(array[j]));
					newSeq.add(array[i]);
					
					seq.put(array[i], newSeq);
				}
			}
		}
		
		for (int i : sum.keySet()) {
			int temp = sum.get(i);
			if (temp > max) {
				max = temp;
				key = i;
			};
		}
		
		
		int i = 0;
		int[] arraySeq = new int[seq.get(key).size()];
		for (int a : seq.get(key)) {
			arraySeq[i] = a;
			i++;
		}
		
		int[][] finalResult = {{max},arraySeq};
		
		return finalResult;
	}
	
}
