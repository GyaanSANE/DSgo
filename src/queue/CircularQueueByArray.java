package queue;

public class CircularQueueByArray {
private int size;
private int start;
private int end;
	int[] arr;
	
public CircularQueueByArray(int size) {
		arr = new int[size+1];
		this.size = size+1;
		start = end = 0;	
	}

public boolean isFull() {
	if((start==0 && end ==size-1) || (end == start-1)) {
		return true;
	} else {
		return false;
	}
}
	
public boolean isEmpty() {
	if(start == end) {
		return true;
	} else {
		return false;
	}
}

public void enque(int val) {
	if(isFull()) {
		System.out.println("Queue is Full!!");
		return;
	}else if(end == size-1 && start>0) {
		arr[end] = val;
		end=0;
	}else {
		arr[end] = val;
		end++;
	}
}

public int deque() {
	int ret;
	if(isEmpty()) {
		System.out.println("Queue is empty!");
		return Integer.MIN_VALUE;
	}else if(start == size-1) {
		ret = arr[start];
		start = 0;
		return ret;
	}else {
		ret = arr[start];
		start++;
		return ret;
	}
}

public int peek() {
	if(isEmpty()) {
		System.out.println("Queue is empty!");

		return Integer.MIN_VALUE;
	}else {
		return  arr[start];
	}	
}

public void emptyQueue() {
	start = end =0;
}

public void deleteQueue() {
	arr = null;
	start = end = 0;
}
//can add suitable handling for exists() in case arr==null
	
}
