
public class Problem_5 {
/*
 * 		Recursive stair case problem
 * 
 * 		give a stair of n levels, and m ways to climb the stairs. In how many ways can n-level stair be reached
 * 
 * 
 */
	
	public static void main (String[] args) {
		int n = 4;
		int[] m =  new int[] {1,2,3};
		solution(n,m);
		
	}
	
	public static void solution(int n, int[] m) {
		
		int[] table = new int[n+1];
		
		for (int i = 0; i <= n; i++) {
			table[i] = 0;
		}
		
		table[0] = 1;
		
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < m.length; j++) {
				if (i - m[j] >= 0) {
					table[i] += table[i - m[j]];
				}
			}
		}
		
		System.out.println(table[n]);
		
	}
}
