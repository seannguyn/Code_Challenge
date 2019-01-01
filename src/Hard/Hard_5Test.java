package Hard;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Hard_5Test {

	public static boolean compare(int[][] arr1, int[][] arr2) {
		
		if (arr1[0][0] != arr2[0][0]) {
			return false;
		}
		
		if (arr1[1].length != arr2[1].length) {
			return false;
		}
		
		for (int i = 0; i < arr1[1].length; i++) {
			if(arr1[1][i] != arr2[1][i]) {
				return false;
			}
		}
		
		return true;
	}
	
	@Test
	void TestCase1() {
		int[] input = {1};
		int[][] expected = {{1},{1}};
		assertTrue(compare(Hard_5.maximumIncreasingSum(input), expected));
	}
	
	@Test
	void TestCase2() {
		int[] input = {-1};
		int[][] expected = {{-1},{-1}};
		assertTrue(compare(Hard_5.maximumIncreasingSum(input), expected));
	}
	
	@Test
	void TestCase3() {
		int[] input = {-1,1};
		int[][] expected = {{1},{1}};
		assertTrue(compare(Hard_5.maximumIncreasingSum(input), expected));
	}
	
	@Test
	void TestCase4() {
		int[] input = {5,4,3,2,1};
		int[][] expected = {{5},{5}};
		assertTrue(compare(Hard_5.maximumIncreasingSum(input), expected));
	}
	
	@Test
	void TestCase5() {
		int[] input = {1,2,3,4,5};
		int[][] expected = {{15},{1,2,3,4,5}};
		assertTrue(compare(Hard_5.maximumIncreasingSum(input), expected));
	}
	
	@Test
	void TestCase6() {
		int[] input = {-5,-4,-3,-2,-1};
		int[][] expected = {{-1},{-1}};
		assertTrue(compare(Hard_5.maximumIncreasingSum(input), expected));
	}
	
	@Test
	void TestCase7() {
		int[] input = {10,70,20,30,50,11,30};
		int[][] expected = {{110},{10,20,30,50}};
		assertTrue(compare(Hard_5.maximumIncreasingSum(input), expected));
	}
	
	@Test
	void TestCase8() {
		int[] input = {8,12,2,3,15,5,7};
		int[][] expected = {{35},{8,12,15}};
		assertTrue(compare(Hard_5.maximumIncreasingSum(input), expected));
	}
	
	@Test
	void TestCase9() {
		int[] input = {10,15,4,5,11,14,31,25,31,23,25,31,50};
		int[][] expected = {{164},{10,11,14,23,25,31,50}};
		assertTrue(compare(Hard_5.maximumIncreasingSum(input), expected));
	}

}
