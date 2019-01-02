package Hard;

public class Hard_17 {
/*
 * 
 * 		find the kth smallest element
 */
	
	public static void main(String[] args) {
		
	}
	
	public static int quickselect(int[] array, int k) {
	    // Write your code here.
			int kth = findNthSmallest(array, 0, array.length-1, k);
			return kth; 
	  }
		public static int findNthSmallest(int[] array, int left, int right, int k) {
			
			if (k > 0 && k <= right - left +1) {
				int position = partition(array, left, right);
				if (position - left == k-1) {
					return array[position];
				}else if (position - left > k-1) {
					// recurse left
					return findNthSmallest(array, left, position-1, k);
				}
				// recurse right
				return findNthSmallest(array, position+1, right, k-position+left-1);
			}
			return Integer.MAX_VALUE;
		}
		
		public static int partition(int[] array, int left, int right) {
			int pivot = array[right];
			int i = left - 1;
			for (int j = left; j <= right-1; j++) {
				if (array[j] < pivot && i != j) {
					i++;
					// swap
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
			
			// swap pivot
			int temp = array[i+1];
			array[i+1] = array[right];
			array[right] = temp;
			
			return i+1;
			
		}
}
