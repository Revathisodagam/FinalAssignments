package SearchTasks;

public class LinearSearch {

	public static int linearSearch(int[] arr, int target) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == target) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
   int numbers[] = {1,8,4,2,9,5,3,7,6};
   int target = 9;
   
   int result = linearSearch(numbers, target);
   if(result != -1) {
	   System.out.println("Element found at Index:" + result);
   } else {
	   System.out.println("Element not found");
      }
	}

}

