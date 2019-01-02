
public class Problem_6 {
/*
 * 
 * 		Unlimited knapsack
 * 
 * 		Given a knapsack with a limited weight capacity and an array of items. choose the items that has the maximum value, 
 * 
 * 		but is still within the weight limit
 * 
 */
	 
		public static void main(String[] args) {
			int W = 100; 
	        int val[] = {10, 30, 20}; 
	        int wt[] = {5, 10, 15}; 
	        unboundedKnapsack(W, val, wt);
		}
		
		public static void unboundedKnapsack(int W, int[] val, int[] wt) {
			int table[] = new int[W+1];
			
			for (int i = 0; i <= W; i++) {
				table[i] = 0;
			}
			
			for (int i = 0; i <= W; i++) {
				for (int j = 0; j < wt.length; j++) {
					if (i - wt[j] >= 0) {
						table[i] = max(table[i],val[j] + table[i - wt[j]]);
					}
				}
			}
			
			System.out.println(table[W]+"   is the correct answer");
		}
		
		public static int max(int a, int b) {
			return a > b ? a : b;
		}
}
