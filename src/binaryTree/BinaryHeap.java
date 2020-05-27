package binaryTree;

public class BinaryHeap {
private int last; //last used index
private int[] arr;

	BinaryHeap(int size) {
		arr = new int[size+1];
		last = 0;
	}
 
	void insert(int val) {
		if (arr == null) {
			System.out.println("Heap doesn't exist.");
			return;
		}else if(isFull()) {
			System.out.println("Heap is full");
			return;
		}else {
			last++;
			arr[last] = val;
			heapifyBottomToTop(last);
		}		
	}

	private void heapifyBottomToTop(int index) {
		int parent = index/2;
		if(index<=1) {
			return;
		}
		if(arr[parent]>arr[index]) {
			int temp = arr[parent];
			arr[parent] = arr[index];
			arr[index] = temp;
		}
		heapifyBottomToTop(parent);
	}
	
	void extract() {
		if (arr == null) {
			System.out.println("Heap doesn't exist.");
			return;
		}else if(isEmpty()) {
			System.out.println("Heap is empty.");
			return;
		}else {
			int val = arr[1];
			System.out.println(val+" extracted.");
			arr[1] = arr[last];
			last--;
			heapifyTopToBottom(1);
		}
	}


	private void heapifyTopToBottom(int index) {
		int left = index*2;
		int right = index*2+1;
		int smallestChild = 0;
		
		if (left > last) {
			return;
		}else {
			smallestChild = left;
			if(right<=last) {
				if(arr[right]<arr[smallestChild]) {
					smallestChild = right;
				}
			}
			if(arr[smallestChild]<arr[index]) {
				int temp = arr[smallestChild];
				arr[smallestChild] = arr[index];
				arr[index] = temp;
			}
			
		}
		heapifyTopToBottom(smallestChild);
	}
	
	void peek() {
		if (arr == null) {
			System.out.println("Heap doesn't exist.");
			return;
		}else if(isEmpty()) {
			System.out.println("Heap is empty.");
			return;
		}else {
			System.out.println("Element at top is "+arr[1]);
		}
	}
	
	void levelOrder() {
		for(int i=1;i<=last;i++) {
			System.out.print(arr[i]+", ");
		}
		System.out.println("\n");
	}
	
	private boolean isEmpty() {
		return((last<1)? true:false);
	}
	
	private boolean isFull() {
		return((last>=arr.length -1)? true : false);
	}
	
	
}
