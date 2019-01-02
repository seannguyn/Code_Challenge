package Hard;

public class Hard_7 {

	/*
	 * 		Minimum jumps to get to the end of the array
	 * 
	 */
	
	public static void main(String[] args) {
		System.out.println("hello");
		int[] input = {3,4,2,1,2,3,7,1,1,1,3};
		minNumberOfJumps(input);
	}
	
	public static int minNumberOfJumps(int[] array) {
	    // Write your code here.
		int[] table = new int[array.length];
		
		for (int i = 0; i < table.length; i++) {
			table[i]= Integer.MAX_VALUE;
		}
		
		table[0] = 0;
		
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				if (i-array[j] <= j) {
					table[i] = min(table[i],table[j]+1);
				}
			}
		}
		
		return table[array.length-1];
	 }
	
	public static int min(int a, int b) {
		return a < b ? a : b;
	}
	
	// CHECKED, passed all tests
	
}
