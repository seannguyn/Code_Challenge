package Hard;
import java.util.*;
public class Hard_3 {
/*
 * 		Find the largest range in an array. 
 * 		the return result should be, for example: [1,4]
 * 
 * 		a range is defined as contiguous sequence of number
 */
	
	public static void main(String[] args) {
		System.out.println("starting");
		
	}
	
	public int[] largestRange(int array[]) {
		
		HashMap<Integer, Boolean> hm = new HashMap<Integer,Boolean>(); 
		for (int i : array) {
			hm.put(i, false);
		}
		
		ArrayList<Integer> finalRange = new ArrayList<Integer>();
		
		for (int i : array) {
			if (hm.get(i) == true) continue;
			
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(i);
			
			for (int j = i; j > Integer.MIN_VALUE; j--) {
				if (hm.get(j) != null) {
					boolean visited = hm.get(j);
					if (visited == true) continue;
					temp.add(j);
					hm.put(j, true);
					
				}
				else {
					break;
				}
			}
			
			for (int j = i; j < Integer.MAX_VALUE; j++) {
				if (hm.get(j) != null) {
					boolean visited = hm.get(j);
					if (visited == true) continue;
					temp.add(j);
					hm.put(j, true);
					
				}
				else {
					break;
				}
			}
			
			Collections.sort(temp);
			
			if (temp.size() > finalRange.size()) finalRange = new ArrayList<Integer>(temp);
		}
		
		int[] finalResult = new int[2];
		finalResult[0] = finalRange.get(0);
		finalResult[1] = finalRange.get(finalRange.size()-1);
		
		return finalResult;
	}
		
}
