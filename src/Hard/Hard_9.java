package Hard;
import java.util.*;
public class Hard_9 {
	/*
	 * 
	 * 		Implementation of unbounded knapsack and 0/1 knapsack
	 */
	
	public static void main(String[] args) {
//		int val[] = new int[]{60, 100, 120}; 
//	    int wt[] = new int[]{10, 20, 30}; 
//	    int  W = 50; 
//	    knapsack01(val, wt, W);
	    
	    int W = 100; 
	    int val[] = {10, 30, 20}; 
	    int wt[] = {5, 10, 15}; 
	    knapsackUnlimited(val, wt, W);
	}
	
	public static ArrayList<ArrayList<Integer>> knapsack01(int[] val, int wt[], int W) {
		
		int table[][] = new int[wt.length+1][W+1]; 
		
		for (int i = 0; i <= wt.length; i++) {
			for (int j = 0; j <= W; j++) {
				if (i==0 || j==0) {
					table[i][j] = 0;
				} else if (j - wt[i-1] >= 0) {
					table[i][j] = max(val[i-1]+table[i-1][j-wt[i-1]],table[i-1][j]);
				} else {
					table[i][j] = table[i-1][j];
				}
			}
		}
		
		// traceback
		int i = val.length;
		int j = W;
		
		ArrayList<Integer> itemIndex = new ArrayList<Integer>();
		
		while (i > 0 && j > 0) {
			
			if (table[i][j] == table[i-1][j]) {
				i = i - 1;
				
			} else {
				j = j - wt[i-1];
				itemIndex.add(i-1);
				i = i - 1;
				
			}
		}
		Collections.reverse(itemIndex);
		ArrayList<ArrayList<Integer>> finalResult = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> sum = new ArrayList<Integer>();
		sum.add(table[wt.length][W]);
		
		finalResult.add(sum);
		finalResult.add(itemIndex);
		return finalResult;
	}
	
	public static ArrayList<Integer[]> knapsackUnlimited(int[] val, int wt[], int W) {
		
		int table[] = new int[W+1]; 
		for (int i = 0; i <= W; i++) {
			table[i] = 0;
		}
		for (int i = 1; i <= W; i++) {
			for (int j = 0; j < wt.length; j++) {
				if (i-wt[j] >= 0) {
					table[i] = max(table[i],val[j]+table[i-wt[j]]);
				}
			}
		}
		System.out.println(table[W]);
		return null;
	}
	
	public static int max(int a, int b) {
		return a >= b ? a : b;
	}
}
