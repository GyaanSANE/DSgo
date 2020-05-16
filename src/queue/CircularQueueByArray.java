package queue;

public class CircularQueueByArray {
private int size;
private int start;
private int end;
	int[] q;
	
public CircularQueueByArray(int size) {
		q = new int[size+1];
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
		q[end] = val;
		end=0;
	}else {
		q[end] = val;
		end++;
	}
}

public int deque() {
	int ret;
	if(isEmpty()) {
		System.out.println("Queue is empty!");
		return Integer.MIN_VALUE;
	}else if(start == size-1) {
		ret = q[start];
		start = 0;
		return ret;
	}else {
		ret = q[start];
		start++;
		return ret;
	}
}

public int peek() {
	if(isEmpty()) {
		System.out.println("Queue is empty!");

		return Integer.MIN_VALUE;
	}else {
		return  q[start];
	}	
}

public void deleteQueue() {
	start = end =0;
}









	
}
