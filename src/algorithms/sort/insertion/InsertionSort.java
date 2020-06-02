package algorithms.sort.insertion;

public class InsertionSort {

	
	public static int[] insertionSort(int[] arr) {
		
		for(int i=1;i<arr.length;i++) {
			int val = arr[i];
			int hole = i;
			while(hole >0 && arr[hole-1]>val) {
				arr[hole] = arr[hole-1];
				hole--;
			}
			if(hole!=i) {
			arr[hole]=val;
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
