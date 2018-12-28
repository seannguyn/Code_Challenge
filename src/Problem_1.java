import java.util.*;

public class Problem_1 {

	/*
	 * 
	 * 
	 * 		Given an array of String, count the occurrence of each word, print the word in alphabetical order
	 * 
	 */
	
	public static void main(String[] args) {
		System.out.println("Problem 1");
		
		System.out.println();
		String[] array_1 = new String[] {"whale","dolphin","whale","dog","dog","cat"};
		findOccurrence(array_1);
		
	}
	
	public static void findOccurrence(String[] array) {
		TreeMap tm = new TreeMap<String, Integer>();
		for (String s : array) {
			
			if (tm.get(s) == null) {
				tm.put(s, 1);
			} else {
				int count = (int) tm.get(s);
				count += 1;
				tm.put(s, count);
			}
		}
		
		Iterator it = tm.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			System.out.println(pair.getKey() + " = " + pair.getValue());
			it.remove();
		}
		
	}
	
}
