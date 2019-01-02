package Hard;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Hard_9Test {

	@Test
	void TestCase1() {
		int val[] = new int[]{60, 100, 120}; 
	    int wt[] = new int[]{10, 20, 30}; 
	    int  W = 50; 
	    int[][] expected = {{220},{1,2}};
	    assertTrue(compare(Hard_9.knapsack01(val, wt, W),expected));
	}
	
	@Test
	void TestCase2() {
		int val[] = new int[]{1, 4, 5, 6}; 
	    int wt[] = new int[]{2, 3, 6, 7}; 
	    int  W = 10; 
	    int[][] expected = {{10},{1,3}};
	    assertTrue(compare(Hard_9.knapsack01(val, wt, W),expected));
	}
	
	@Test
	void TestCase3() {
		int val[] = new int[]{465, 400,255,350,650,1000,455,100,1200,320,750,50,550,100,600,240};
		
	    int wt[] = new int[]{100, 85, 55, 45, 130, 190, 100, 25, 190, 65, 100, 45, 65, 50, 70, 40};
	    int  W = 200; 
	    int[][] expected = {{1500},{3,12,14}};
	    assertTrue(compare(Hard_9.knapsack01(val, wt, W),expected));
	}
	
	
	public static boolean compare(ArrayList<ArrayList<Integer>> arr1, int[][] arr2) {
		
		if (arr1.get(0).get(0) != arr2[0][0]) {
			return false;
		}
		
		for (int i = 0; i < arr1.get(1).size(); i++) {
			if (arr1.get(1).get(i) != arr2[1][i]) {
				return false;
			}
		}
		
		return true;
	}

}
