package linkedList;

public class CircularDoublyLLMain {
	public static void main(String[] args) {
		CircularDoublyLL list = new CircularDoublyLL();
		list.createDLL(5);
		list.traverse();

		list.insertDLL(10, 1);
		list.traverse();

		list.insertDLL(20, 2);		list.traverse();

		list.insertDLL(30, 2);		list.traverse();

		list.insertDLL(40, 1);		list.traverse();

		
		System.out.println("List Now: ");
		list.traverse();
		
		list.reverseTraverse();
		list.printHeadUsingTail();
		list.printTailUsingHead();
		
		
		System.out.println("\nSearching the node having value 40: ");
		list.search(40);
		
		System.out.println("\nSearching the node having value 200: ");
		list.search(200);
		
		
		System.out.println("\n\nDeleting the node having location = 0: ");
		System.out.println("Before Deletion...");
		list.traverse();
		list.deleteNode(0);
		System.out.println("After Deletion...");
		list.traverse();
		
		System.out.println("\n\nDeleting the node having location = 3: ");
		System.out.println("Before Deletion...");
		list.traverse();
		list.deleteNode(3);
		System.out.println("After Deletion...");
		list.traverse();

		System.out.println("\n\nDeleting the node having location = 20: ");
		System.out.println("Before Deletion...");
		list.traverse();
		list.deleteNode(20);
		System.out.println("After Deletion...");
		list.traverse();
		
				
		list.deleteLL();
		list.traverse();
		
	}

}
