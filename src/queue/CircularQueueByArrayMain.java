package queue;

public class CircularQueueByArrayMain {
	public static void main(String[] args) {

		System.out.println("Creating an empty queue...");
		CircularQueueByArray queue = new CircularQueueByArray(5);

		System.out.println("Enqueuing 6 values in the queue...");
		for (int i = 1; i <= 6; i++) {
			queue.enque(i * 10);
		}

		System.out.println("Peek value from queue...");
		System.out.println(queue.peek());

		System.out.println("Dequeue 6 values from queue...");
		for (int i = 0; i <= 5; i++) {
			int deq =queue.deque();
			System.out.println((deq==Integer.MIN_VALUE)?"":deq);
		}

		System.out.println("Deleting the entire Queue...");
		queue.deleteQueue();

		
		
	}// end of method

}
