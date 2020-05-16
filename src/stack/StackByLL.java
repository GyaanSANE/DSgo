package stack;

import linkedList.DoublyLL;
public class StackByLL {
private int top;
DoublyLL list;
	
	public StackByLL() {
		list = new DoublyLL();
		top = -1;
		
	}
	//push
	public void push(int val) {
		if(exists()) {
			if (top ==-1) {//first push
				list.createDLL(val);
			} else {
				list.insertDLL(val, top+1);
			}
			top++;
		}else {
			System.out.println("Stack does not exist. Create it first.");
		}	
	}
	//pop
	public void pop() {
		if(!exists()) {
			System.out.println("Stack does not exist.");
		}else if(isEmpty()) {
			System.out.println("Stack is empty.");
		}else {
			System.out.println(list.getTail().getValue());
			list.deleteNode(top);
			top--;
		}	
	}
	//peek
	public void peek() {
		if(!exists()) {
			System.out.println("Stack does not exist.");
		}else if(isEmpty()) {
			System.out.println("Stack is empty.");
		}else {
			System.out.println(list.getTail().getValue());
		}	
	}
	
	//exists
	public boolean exists() {
		if (list == null) {
			return false;
		} else {
			return true;
		}
	}
	//isEmpty
	public boolean isEmpty() {
		if(top == -1) {
			return true;
		} else {
			return false;
		}
	}
	//delete
	public void deleteStack() {
		list.deleteLL();
		list=null;
		top = -1;
	}
	
	
	
}
