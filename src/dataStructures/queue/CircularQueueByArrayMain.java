package dataStructures.queue;

public class CircularQueueByArrayMain {
	public static void main(String[] args) {

		System.out.println("Creating an empty queue...");
		CircularQueueByArray queue = new CircularQueueByArray(5);

		System.out.println("Enqueuing 6 values in the queue...");
		for (int i = 1; i <= 6; i++) {
			System.out.println("enqueing "+i*10);
			queue.enque(i * 10);
		}

		System.out.println("Peek value from queue...");
		System.out.println(queue.peek());

		System.out.println("Dequeue 4 values from queue...");
		for (int i = 0; i <= 3; i++) {
			int deq =queue.deque();
			System.out.println((deq==Integer.MIN_VALUE)?"":deq);
		}
		System.out.println("Enqueuing 6 values in the queue...");
		for (int i = 1; i <= 6; i++) {
			System.out.println("enqueing "+i*100);
			queue.enque(i * 100);
		}
		
		System.out.println("Dequeue 6 values from queue...");
		for (int i = 0; i <= 5; i++) {
			int deq =queue.deque();
			System.out.println((deq==Integer.MIN_VALUE)?"":deq);
		}
		System.out.println("Enqueuing 2 values in the queue...");
		for (int i = 1; i <= 2; i++) {
			System.out.println("enqueing "+i*500);
			queue.enque(i * 500);
		}
		System.out.println("Peek value from queue...");
		System.out.println(queue.peek());
		System.out.println("Deleting the entire Queue...");
		queue.emptyQueue();
		System.out.println("Peek value from queue...");
		System.out.println(queue.peek());
		//error handling for -2147483648 as in line 21
		
	}

}
