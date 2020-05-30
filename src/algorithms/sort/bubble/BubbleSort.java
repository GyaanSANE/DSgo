package algorithms.sort.bubble;

public class BubbleSort {

	public static int[] bubbleSort(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			int flag =0;
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					flag =1;
				}
			}
			if(flag ==0) {	//in case there were no swaps, array is already sorted
				break;
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
