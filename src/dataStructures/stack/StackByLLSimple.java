package dataStructures.stack;
import dataStructures.linkedList.SinglyLL;
public class StackByLLSimple {
private SinglyLL stack;



	public StackByLLSimple() {
	stack = new SinglyLL();
	}
	//isEmpty
	public boolean isEmpty() {
		if(stack.getHead()==null) {
			return true;
		} else {
			return false;
		}
		
	}
	//push
	public void push(int val) {
		if(isEmpty()) {
			stack.createSLL(val);
		}else {
			stack.insertLL(val, 0);
			}
	}
	
	//pop
	public int pop() {
		if(isEmpty()) {
			System.out.println("Stack is Empty!");
			return Integer.MIN_VALUE;
		}else {
			int val= stack.getHead().getValue();
			stack.deleteNode(0);
			return val;
		}
	}
	//peek
	public int peek() {
		if(isEmpty()) {
			System.out.println("Stack is Empty!");
			return 0;
		}else {
			return stack.getHead().getValue();
			
		}
	}
	//empty stack
	public void deleteStack() {
		stack.setHead(null);
	}
	
	
	
	
	
	
}
