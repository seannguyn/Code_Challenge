package Hard;

public class Hard_8 {
/*
 * 		trapping rain water
 * 		https://www.geeksforgeeks.org/trapping-rain-water/
 * 		
 */
	
	public static void main(String[] args) {
		System.out.println("hello");
		waterArea(new int[] {0,8,0,0,5,0,0,10,0,0,1,1,0,3});
	}
	
	public static int waterArea(int[] heights) {
	    // Write your code here.
		
		if(heights.length == 0) {
			return 0;
		}
		
		int[] leftMax = new int[heights.length];
		int[] rightMax = new int[heights.length];
		int[] trappedWater = new int[heights.length];
		
		// find leftMax
		int currentLeft = 0;
		leftMax[0] = heights[0];
		for (int i = 1; i < heights.length; i++) {
			leftMax[i] = currentLeft;
			if (currentLeft < heights[i]) currentLeft = heights[i];
		}
		
		// find rightMax
		int currentRight = heights[heights.length-1];
		rightMax[heights.length-1] = 0;
		for (int i = heights.length-2; i >= 0; i--) {
			rightMax[i] = currentRight;
			if (currentRight < heights[i]) currentRight = heights[i];
		}
		
		for (int i = 0; i < heights.length; i++) {
			int minHeight = min(leftMax[i],rightMax[i]);
			if (heights[i] < minHeight) {
				trappedWater[i] = minHeight - heights[i];
			} else {
				trappedWater[i] = 0;
			}
		}
		
		int sum = 0;
		for (int i : trappedWater) {
			sum += i;
		}
		System.out.println(sum);
		return sum;
	}
	
	public static int min(int a, int b) {
		return a < b ? a : b;
	}
}
