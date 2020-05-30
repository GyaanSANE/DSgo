package dataStructures.stack;

public class StackByArray {
private int top;
private int size;
public int getSize() {
	return size;
}

public void setSize(int size) {
	this.size = size;
}
 int[] stack;

public StackByArray(int size) {
	this.stack = new int[size];
	setSize(size);
	this.top =-1;
}


//create
/*public void createStack(int size) {
	stack = new int[size];
	setSize(size);
	top =-1;
	bottom = -1;
}*/

//exists
public boolean exists() {
	if(stack == null) {
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
//isFull
public boolean isFull() {
	if (top == size-1) {
		return true;
	} else {
		return false;
	}
} 

//push
public void push(int val) {
	if(!exists()) {
		System.out.println("Stack doesnot exist");
		return;
	} else if(isFull()) {
		System.out.println("Stack is full!");
		return;
	}else {
		stack[top+1]= val;
		top++;
	}
}
//pop
public void pop() {
	if(!exists()) {
		System.out.println("Stack doesnot exist");
		return;
	}else if(isEmpty()) {
		System.out.println("Stack is empty!");
	}else {
		System.out.println(stack[top]);
		top--;
	}
}
//peek
public void peek() {
	if(!exists()) {
		System.out.println("Stack doesnot exist");
		return;
	}else if(isEmpty()) {
		System.out.println("Stack is empty!");
	}else {
		System.out.println(stack[top]);
	}
}

//delete
public void deleteStack() {
	stack = null;
	top = -1;
	size = 0;
}










	
}
