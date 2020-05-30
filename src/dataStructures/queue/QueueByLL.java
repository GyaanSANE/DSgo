package dataStructures.queue;
import dataStructures.linkedList.SinglyLL;
public class QueueByLL {
private int end;
SinglyLL list;

	public QueueByLL() {
		list = new SinglyLL();
		end =-1;
	}

public boolean isEmpty() {
	if(end ==-1) {
		return true;
	} else {
		return false;
	}
}

public void enque(int value) {
	if(isEmpty()) {
		list.createSLL(value);
		end++;
	}else {
	end++;
	list.insertLL(value, end);
}}

public int deque() {
	if(isEmpty()) {
		System.out.println("queue is empty!");
		return Integer.MIN_VALUE;
	}else {
		int var = list.getHead().getValue();
		list.deleteNode(0);
		return var;
	}
}

public int peek() {
	if(isEmpty()) {
		System.out.println("queue is empty!");
		return Integer.MIN_VALUE;
	}else {
		return list.getHead().getValue();
	}
}


}