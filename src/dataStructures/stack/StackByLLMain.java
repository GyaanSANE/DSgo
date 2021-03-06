package dataStructures.stack;

public class StackByLLMain {
	public static void main(String[] args) {

		StackByLL stack = new StackByLL();

		System.out.println("Pushing 10 values into stack");
		for (int i = 1; i <= 10; i++) {
			stack.push(i * 10);
		}
		System.out.println();

		System.out.println("Peeking value");
		stack.peek();
		System.out.println();

		System.out.println("Poping 11 values from stack");
		for (int i = 1; i <= 11; i++) {
			stack.pop();
		}
		System.out.println();
		
		
		/////
		
		System.out.println("Pushing 10 values into stack");
		for (int i = 1; i <= 10; i++) {
			stack.push(i * 10);
		}
		System.out.println();

		System.out.println("Peeking value");
		stack.peek();
		System.out.println();

		System.out.println("Poping 11 values from stack");
		for (int i = 1; i <= 11; i++) {
			stack.pop();
		}
		System.out.println("Deleting Stack");
		stack.deleteStack();
		stack.peek();
	}

}
