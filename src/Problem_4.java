import java.util.*;

public class Problem_4 {
/*
 * 		given an array and an integer K, find all the pairs of number that add up to that array
 * 
 * 
 * 		There are two ways of doing this problem
 * 		1. build a binary search tree from the array, search for x = K - y. This search will take n log n
 * 
 * 
 * 		2. use a hashmap, which map the value -> index.
 * 
 */
	
	public static void main(String[] args) {
		
		int[] array = {1,2,3,4,5,6,7,8,9,0};
		
		findPair(array, 9);
		
	}
	
	public static void findPair(int [] array, int k) {
		
		HashMap hm = new HashMap<Integer, Integer>();
		 
		for (int i = 0; i < array.length; i++) {
			
			int key = k - array[i];
			
			if (hm.get(key) != null) {
				int p1 = key;
				int p2 = array[i];
				System.out.println("("+p1+","+p2+")");
			}
			
			hm.put(array[i], i);
		}
		
	}
}
