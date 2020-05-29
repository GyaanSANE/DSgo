package sorting;

public class BubbleSortMain {

	
	public static void main(String[] args) {

		int arr[] = { 10, 5, 30, 15, 50, 6 };
		//int arr[] = { 1,2,3,4 };
		System.out.println("Array to be sorted...");
		BubbleSort.printArray(arr);

		BubbleSort.bubbleSort(arr);

		System.out.println("Sorted Array...");
		BubbleSort.printArray(arr);

	}
}
