package dataStructures.linkedList;
import dataStructures.node.DoubleNode;
public class DoublyLL {
 DoubleNode head; //removed private to ease inheritance
 DoubleNode tail;
 public DoubleNode getTail() {//get tail to access top of stack value
	return tail;
}

int size;

public void setSize(int size) {
	this.size = size;
}
public int getSize() {
	return size;
}

//create
public void createDLL(int value) {
	DoubleNode node = new DoubleNode();
	node.setValue(value);
	node.setNext(null);
	node.setPrev(null);
	head = node;
	tail = node;
	size = 1;
}

//exists
public boolean exists() {
	if(head == null) {
		return false;
	}
	else {
		return true;//return head != null
	}
}
//insert
public void insertDLL(int value, int loc) {
	DoubleNode node = new DoubleNode();
	node.setValue(value);
	if(!exists()) {
		System.out.println("LinkedList does not exist!");
		return;
	}else if(loc == 0) {
		node.setNext(head);
		head.setPrev(node);
		node.setPrev(null);
		head = node;		
	}else if(loc >= size) {
		tail.setNext(node);
		node.setPrev(tail);
		node.setNext(null);
		tail = node;
	}else {
		DoubleNode temp = head;
		//for(int i=0; i<loc;i++ ){
		//	temp = temp.getNext();
		//}
		int i =0;
		while( i< loc-1) {//p2
			temp= temp.getNext();
			i++;
		}node.setNext(temp.getNext());
		temp.getNext().setPrev(node);
		temp.setNext(node);
		node.setPrev(temp);
	}setSize(getSize()+1);
}

//deleteNode
public void deleteNode(int loc) {
	if(!exists()) {
		System.out.println("LinkedList does not exist!");
		return;
	}else if(loc == 0) {
		if(tail == head) {//only 1 node
			head =tail = null;
		}else {
			head = head.getNext();
			head.setPrev(null);
		}
	}else if(loc >=size-1) {
		if(tail == head) {//only 1 node
			head =tail = null;
		}else {
		tail = tail.getPrev();
		tail.setNext(null);}
	}else {
		int i=0;
		DoubleNode temp = head;
		while(i<loc) {
			temp = temp.getNext();
			i++;
		}temp.getPrev().setNext(temp.getNext());
		temp.getNext().setPrev(temp.getPrev());
	}
	setSize(getSize()-1);
}

//deleteLL
public void deleteLL() {
	DoubleNode temp=head;
	for(int i=0;i<size-1;i++) {
		temp = temp.getNext();
		temp.setPrev(null);
	}head = tail = null;
	setSize(0);
}

//search
public void search(int val) {
	if(exists()) {
	int i=0;
	DoubleNode temp=head;
	while(i<size) {
		if(temp.getValue()==val) {
			System.out.println("Value found at node "+i);
			return;
		}else {
			temp=temp.getNext();
			i++;
		}}
		System.out.println("Value not found!!");	}
	else {
		System.out.println("LinkedList does not exist!");
	}
}

//traverse
public void traverse() {
	if(!exists()) {
		System.out.println("LinkedList does not exist!");
		//return;
	}else {
	DoubleNode temp=head;
	for(int i=0;i<size;i++) {
		System.out.print(temp.getValue());
		temp=temp.getNext();
		if (i != getSize() - 1) {
		System.out.print(" -> ");}
	}System.out.println("\n");
	}
}

//reverse traverse
public void reverseTraverse() {
	if(!exists()) {
		System.out.print("LinkedList does not exist!");
		//return;
	}else {
		DoubleNode temp=tail;
		for(int i=0;i<size;i++) {
			System.out.print(temp.getValue());
			temp=temp.getPrev();
			if (i != getSize() - 1) {
			System.out.print(" <- ");}
		}System.out.println("\n");
	}
}

}
