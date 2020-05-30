package dataStructures.linkedList;
import dataStructures.node.SingleNode;
public class SinglyLL {
	private SingleNode head;
	private SingleNode tail;
	private int size;
	
	public SingleNode getHead() {
		return head;
	}
	public void setHead(SingleNode head) {
		this.head = head;
	}
	public SingleNode getTail() {
		return tail;
	}
	public void setTail(SingleNode tail) {
		this.tail = tail;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	//create LL
	public SingleNode createSLL(int value) {
		//head = new SingleNode();
		//tail = new SingleNode();
		SingleNode node = new SingleNode();
		node.setValue(value);
		node.setNext(null);
		head=node;
		tail=node;
		size = 1;
		return head;
	}
	
	//exists
	public boolean exists() {
		return head != null;
	}
	//insert 
	public void insertLL(int value, int loc) {
		SingleNode node = new SingleNode();
		node.setValue(value);
		if(!exists()) {
			System.out.println("LL does not exist");
		}else if(loc==0) {
			node.setNext(head);
			head = node;
		}else if(loc>=size) {
			tail.setNext(node);
			node.setNext(null);
			tail=node;
		}else {
			SingleNode tempNode = head;
			int index = 0;
			while(index<loc-1) {
				tempNode = tempNode.getNext();
				index++;
			}
			node.setNext(tempNode.getNext());
			tempNode.setNext(node);
		}
		setSize(getSize()+1);
	}
	//delete 1
	public void deleteNode(int loc) {
		if(!exists()) {
			System.out.println("LL does not exist");
			return;
		}else if(loc==0) {
			head = head.getNext();
			setSize(getSize()-1);	
			if(getSize() == 0) { // if there are no more nodes in this list
				tail = null;
			}
		}else if(loc>=getSize()-1) {
			SingleNode temp=head;
			for(int i=0;i<size-1;i++ ) {
				temp = temp.getNext();
			}if (temp == head) { //if this is the only element in the list
				tail = head = null;
				setSize(getSize()-1);
				return;
			}temp.setNext(null);
			tail=temp;
			setSize(getSize()-1);
		}else {
			//int index =0;
			SingleNode temp=head;
			for (int i = 0; i < loc- 1; i++)  {
				temp = temp.getNext();
			}temp.setNext(temp.getNext().getNext());
			setSize(getSize()-1);
		}
	}
	//delete all
	public void deleteLL() {
		head=tail=null;
		System.out.println("Linked List deleted");
	}
	//traverse
	public void traverse() {
		if(exists()) {
			SingleNode temp = head;
			for (int i =0;i<getSize();i++) {
				System.out.print(temp.getValue());
				if (i != getSize() - 1) {
					System.out.print(" -> ");
				}
				temp=temp.getNext();
				}
			System.out.println();
		}else {
			System.out.println("Linked List does not exists !");
		}
	}
	//search
	public boolean search(int value) {
		if (exists()) {
			SingleNode temp= head;
			for (int i = 0; i < getSize(); i++) {
				if (temp.getValue() == value) {
					System.out.print("Found the node at location: "+i+"\n");
					return true;
				}
				temp = temp.getNext();
			}
		}
		System.out.print("Node not found!! \n");
		return false;
	}
	

}
