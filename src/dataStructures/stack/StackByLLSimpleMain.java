package dataStructures.stack;

public class StackByLLSimpleMain {
	public static void main(String[] args) {

		StackByLLSimple stack = new StackByLLSimple();

		System.out.println("Pushing 10 values into stack");
		for (int i = 1; i <= 10; i++) {
			stack.push(i * 10);
		}
		System.out.println();

		System.out.println("Peeking value");
		System.out.println(stack.peek());
		System.out.println();

		System.out.println("Poping 11 values from stack");
		for (int i = 1; i <= 11; i++) {
			int pop = stack.pop();
			System.out.println(pop!=Integer.MIN_VALUE? pop:"");
		}
		System.out.println("Deleting Stack...");
		stack.deleteStack();
		stack.peek();
		System.out.println();
		System.out.println("Pushing 10 values into stack");
		for (int i = 1; i <= 10; i++) {
			stack.push(i * 10);
		}
		System.out.println();

		System.out.println("Peeking value");
		System.out.println(stack.peek());
		System.out.println();

		System.out.println("Poping 11 values from stack");
		for (int i = 1; i <= 11; i++) {
			int pop = stack.pop();
			System.out.println(pop!=Integer.MIN_VALUE? pop:"");
		}
	}
}
