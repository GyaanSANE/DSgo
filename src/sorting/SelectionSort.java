package sorting;

public class SelectionSort {

	public static int[] selectionSort(int[] arr) {
		int n = arr.length;
		int min,temp = 0;
		
		for(int i=0;i<n-1;i++) {
			min = i;
			for(int j=i+1;j<n;j++) {	//need not check for j=i since min=i, so if will always be false
				if(arr[min]>arr[j]) {
					min =j;
				}
			}
			if(min!=i) {
				temp = arr[min];
				arr[min] = arr[i];
				arr[i] = temp;
			}
		}
		return arr;
	}
	
	
	public static void printArray(int[] arr) {
		for(int i:arr) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
}
