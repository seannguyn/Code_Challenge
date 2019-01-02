package Hard;
import java.util.*;

public class Hard_6 {
/*
 * 
 * 		Find the longest common subsequence between two string 
 * 
 * 		
 */
	public static ArrayList<Character> longestCommonSubsequence(String a, String b) {
		
		char[] array_a = a.toCharArray();
		char[] array_b = b.toCharArray();
		
		int[][] table = new int[array_a.length+1][array_b.length+1];
		
		for (int i = 0; i <= array_a.length; i++) {
			for (int j = 0; j <= array_b.length; j++) {
				if (i == 0 || j == 0) {
					table[i][j] = 0;
				} 
				else if (array_a[i-1] == array_b[j-1]) {
					table[i][j] = table[i-1][j-1]+1;
				}
				else {
					table[i][j] = max(table[i-1][j],table[i][j-1]);
				}
			}
		}
		ArrayList<Character> sequence = sequenceTrace(table,array_a,array_b);
		
		return sequence;
	}
	
	public static ArrayList<Character> sequenceTrace(int[][] table,char[] a, char[] b) {
		ArrayList<Character> sequence = new ArrayList<Character>();
		Stack<Character> stack = new Stack<Character>();
		
		int i = table.length-1;
		int j = table[0].length-1;
		
		while (i > 0 && j > 0) {
			if(table[i][j] == table[i-1][j]) {
				i = i - 1;

			} 
			else if(table[i][j] == table[i][j-1]) {
				j = j - 1;

			} 
			else {
				i = i - 1;
				j = j - 1;
				stack.push(a[i]);
			}
		}
		
		while (!stack.isEmpty()) {
			sequence.add(stack.pop());
		}
		
		return sequence;
	}
	
	public static int max(int a, int b) {
		return a >= b ? a : b;
	}
	
	public static void main (String args[]) {
		longestCommonSubsequence("ABCDGH", "AEDFHR");
		longestCommonSubsequence("AGGTAB", "GXTXAYB");
	}
}
