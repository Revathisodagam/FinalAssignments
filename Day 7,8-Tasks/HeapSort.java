package SortingTasks;

public class HeapSort {
   
	static void heapSort(int arr[]) {
		int N= arr.length;
		
		for(int i=N/2-1; i>+0; i--) {
			heapify(arr,N,i);
		}
		for(int i =N-1; i>=0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			heapify(arr,i,0);
		}
	}
	
	private static void heapify(int[] arr, int N, int i) {
		// TODO Auto-generated method stub
		int largest = i;
		int left=2*i+1;
		int right=2*i+2;
		
		if(left<N && arr[left]> arr[largest]) {
		largest = left;
		}
		if(right<N && arr[right]> arr[largest]) {
			largest = right;
		}
		if(largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;
			heapify(arr,N,largest);
		}
	}
	public static void printArr(int[] arr) {
		for(int i=0; i<arr.length; ++i) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int arr[] =  {100,25,16,49,81,9,36,64};
      HeepSort h= new HeepSort();
      
      System.out.println("Array before sorting");
      h.printArr(arr);
      
      heapSort(arr);
      System.out.println("\nArray after sorting:");
      h.printArr(arr);
	}
}
