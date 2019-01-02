package Hard;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Hard_6Test {

	public static boolean compare(ArrayList<Character> output,char[] expected) {
		if (output.size() != expected.length) {
			return false;
		}
		for (int i = 0; i < output.size(); i++) {
			if (output.get(i)!=expected[i]) {
				return false;
			}
		}
		return true;
	}
	
	@Test
	void TestCase1() {
		char[] expected = {};
		assertTrue(compare(Hard_6.longestCommonSubsequence("", ""),expected));
	}
	
	@Test
	void TestCase2() {
		char[] expected = {};
		assertTrue(compare(Hard_6.longestCommonSubsequence("", "ABCDEFGH"),expected));
	}

	@Test
	void TestCase3() {
		char[] expected = {};
		assertTrue(compare(Hard_6.longestCommonSubsequence("ABCDEFGH", ""),expected));
	}
	
	@Test
	void TestCase4() {
		char[] expected = {'A','B','C','D','E','F','G','H'};
		assertTrue(compare(Hard_6.longestCommonSubsequence("ABCDEFGH", "ABCDEFGH"),expected));
	}
	
	@Test
	void TestCase5() {
		char[] expected = {'A','E'};
		assertTrue(compare(Hard_6.longestCommonSubsequence("ABCDEFGH", "APPLES"),expected));
	}
	
	@Test
	void TestCase6() {
		char[] expected = {'n','t'};
		assertTrue(compare(Hard_6.longestCommonSubsequence("clement", "antoine"),expected));
	}
	
	@Test
	void TestCase7() {
		char[] expected = {'X','Y','Z','W'};
		assertTrue(compare(Hard_6.longestCommonSubsequence("ZXVVYZW", "XKYKZPW"),expected));
	}

}
