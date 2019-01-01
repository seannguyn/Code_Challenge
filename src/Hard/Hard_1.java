package Hard;
import java.util.*;

public class Hard_1 {

	// find 4 number in an array that sums up to a particular value
	public static void main (String[] args) {
		System.out.println("starting");
		ArrayList<Integer[]> finalResult=findFourNumber(new int[] {1,2,3,4,5,6,7},10);
		
		for (Integer[] arr : finalResult) {
			System.out.println(arr[0]+" "+arr[1]+" "+arr[2]+" "+arr[3]);
		}
	}
	
	public static ArrayList<Integer[]> findFourNumber(int[] array, int sum) {
		
		HashMap<Integer,LinkedList<Integer[]>> miniSum = new HashMap<Integer,LinkedList<Integer[]>>();
		ArrayList<Integer[]> finalResult = new ArrayList<Integer[]>();
		
		for (int i = 0; i < array.length-1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				int temp = array[i] + array[j];
				int hashValue = sum - temp;
				if (miniSum.get(hashValue) != null) {
					
					
					LinkedList<Integer[]> foundAdday = miniSum.get(hashValue);
					
					for (Integer[] arr : foundAdday) {
						Integer[] resultArray = new Integer[4];
						resultArray[0] = arr[0];
						resultArray[1] = arr[1];
						resultArray[2] = array[i];
						resultArray[3] = array[j];
						finalResult.add(resultArray);
					}
					
				}
			}
			
			for (int k = 0; k < i; k++) {
				int tempHash = array[k] + array[i];
				if (miniSum.get(tempHash) == null) {
					LinkedList<Integer[]> newArray = new LinkedList<Integer[]>();
					Integer[] arr = new Integer[2];
					arr[0] = array[k];
					arr[1] = array[i];
					newArray.add(arr);
					miniSum.put(tempHash, newArray);
				} else {
					LinkedList<Integer[]> existingArray = miniSum.get(tempHash);
					Integer[] arr = new Integer[2];
					arr[0] = array[k];
					arr[1] = array[i];
					existingArray.add(arr);
				}
			}
		}
		
		return finalResult;
	}
	
	public int square(int x) {
		return x*x;
	}
	
	
}
