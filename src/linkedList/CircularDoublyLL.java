package linkedList;

import node.DoubleNode;

public class CircularDoublyLL extends DoublyLL{

	//variables inherited, 
	
	//create
	@Override
	public void createDLL(int value) {
		//super.createDLL(value); //cant access node after this to link circlular
		
		DoubleNode node = new DoubleNode();
		node.setValue(value);
		node.setNext(node);
		node.setPrev(node);
		head = node;
		tail = node;
		size = 1;

	}
	
	//exists inherited
	
	//insert
	@Override
	public void insertDLL(int value, int loc) {
		DoubleNode node = new DoubleNode();
		node.setValue(value);
		if(!exists()) {
			System.out.println("LinkedList does not exist!");
			return;
		}else if(loc == 0) {
			node.setNext(head);
			head.setPrev(node);
			node.setPrev(tail);
			head = node;
			tail.setNext(head);
		}else if(loc >= size) {
			tail.setNext(node);
			node.setPrev(tail);
			node.setNext(head);
			tail = node;
			head.setPrev(tail);
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

	//delete node
	@Override
	public void deleteNode(int loc) {
		if(!exists()) {
			System.out.println("LinkedList does not exist!");
			return;
		}else if(loc == 0) {
			if(tail == head) {//only 1 node
				head.setNext(null);
				head.setPrev(null);
				head =tail = null;
			}else {
				tail.setNext(head.getNext());
				head = head.getNext();
				head.setPrev(tail);
			}
		}else if(loc >=size-1) {
			if(tail == head) {//only 1 node
				head.setNext(null);
				head.setPrev(null);
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
	@Override
	public void deleteLL() {
		DoubleNode temp=head;
		head.setPrev(null);
		tail.setNext(null);
		for(int i=0;i<size-1;i++) {
			temp = temp.getNext();
			temp.setPrev(null);
		}
		head = tail = null;
		setSize(0);
	}
	
//search, trav, revTrav inherited
	
	public void printTailUsingHead() {
		System.out.println(head.getPrev().getValue());
	}
	
	public void printHeadUsingTail() {
		System.out.println(tail.getNext().getValue());
	}
	
	
	
	
	
	
}
