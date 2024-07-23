package SearchTasks;

public class JumpSearch {

	static int jumpSearch(int[] arr, int x) {
		 int n = arr.length;
		 int step = (int) Math.floor(Math.sqrt(n));
		 int prev = 0;
		
		 System.out.println("Array length:" +n);
		 System.out.println("Step value is :" +step);
		 
		 for(int minStep = Math.min(step, n)-1;
				 arr[minStep] < x;
				 minStep = Math.min(step, n)-1) {
			 
			 prev = step;
			 System.out.println("Prev is:" +prev);
			 step += (int)Math.floor(Math.sqrt(Math.sqrt(n)));
			 System.out.println("Step is :" +step);
			 
		  if(prev >= n) 
			  return -1;
		 }
		 
		 while(arr[prev] < x) {
			 prev++;
			 System.out.println("Step value is :" +step);
			 if(prev == Math.min(step, n))
		 return -1;
		 }
		 
		 if(arr[prev] == x)
		    return prev;
		 
		 return -1;
		 }
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
	        int arr[]= {0,1,9,27,71,213,234,300};
	        int x= 71;
	        int result = jumpSearch(arr,x);
	        System.out.println("===============");
	        if (result != -1) {
	            System.out.println(x+ "\nElement found at index " + result);
	        } else {
	            System.out.println("Element not found");
	        }
		}

	}
	