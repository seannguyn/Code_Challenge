package Hard;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Hard_1Test {

	private boolean compare(ArrayList<Integer[]> quads1, ArrayList<Integer[]> quads2) {
		
		    for (Integer[] quad : quads2) {
		      Arrays.sort(quad);
		    }
		
		    for (Integer[] quad : quads1) {
		
		      Arrays.sort(quad);
		
		    }
		
		    for (Integer[] quad2 : quads2) {
		
		      boolean found = false;
		
		      for (Integer[] quad1 : quads1) {
		
		        if (Arrays.equals(quad2, quad1)) {
		
		          found = true;
		
		          break;
		
		        }
		
		      }
		
		      if (found == false) {
		
		        return false;
		
		      }
		
		    }
		
		    return true;
	}
	
	@Test
	void testCase1() {
		Hard_1 h1 = new Hard_1();
		ArrayList<Integer[]> output = h1.findFourNumber(new int[] {1,2,3,4,5,6,7},10);
		ArrayList<Integer[]> Quad = new ArrayList<Integer[]>();
		Quad.add(new Integer[] {1,2,3,4});
		assertEquals(output.size(),Quad.size());
		assertTrue(this.compare(output, Quad));
	}
	
	@Test
	void testCase2() {
		Hard_1 h1 = new Hard_1();
		ArrayList<Integer[]> output = h1.findFourNumber(new int[] {7,6,4,-1,1,2},16);
		ArrayList<Integer[]> Quad = new ArrayList<Integer[]>();
		Quad.add(new Integer[] {7,6,-1,4});
		Quad.add(new Integer[] {7,6,2,1});
		assertEquals(output.size(),Quad.size());
		assertTrue(this.compare(output, Quad));
	}
	

}
