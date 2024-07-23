package SortingTasks;

public class QuickSort {
	static void swap(int[] arr, int i, int j) {
		int temp= arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
		static int partition(int[] arr, int low, int high) {
			int pivot = arr[high];
			
			int i = (low-1);
			for(int j=low; j<= high; j++) {
				if(arr[j] < pivot) {
					i++;
					swap(arr,i,j);
				}
			}
			swap(arr,i+1,high);
			return i+1;
		}
		
		static void quickSort(int[] arr, int low, int high) {
			if(low< high) {
				int pi = partition(arr,low,high);
				quickSort(arr, low, pi-1);
				quickSort(arr,pi+1,high);
			}
		}
		public static void printArr(int[] arr) {
			for(int i=0; i<arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
		}
		public static void main(String[] args) {
			//TODO Auto-generated method stub
			int arr[] = { 64, 34, 25, 12, 22, 11, 90};
			int N= arr.length;
			
			System.out.println("Array before sorting:");
	        printArr(arr);
	        
			quickSort(arr, 0, N-1);
			System.out.println(" \nArray after sorting: ");
			printArr(arr);
		}
		
	}
