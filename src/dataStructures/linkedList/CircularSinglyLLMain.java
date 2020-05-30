package dataStructures.linkedList;

public class CircularSinglyLLMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularSinglyLL list = new CircularSinglyLL();
		list.createCSLL(5);
		list.insertLL(10, 1);
		list.insertLL(20, 2);
		list.insertLL(30, 3);
		list.insertLL(40, 4);
		
		System.out.println("Linked List now: ");
		list.traverse();
	    
		list.insertLL(35, 4);
		list.traverse();
		
		list.insertLL(1, 0);
		list.traverse();
		
		list.insertLL(100, 10);
		list.traverse();
		
		
		list.printHeadUsingTail();
		
		System.out.println("Searching the node having value 40: ");
		list.search(40);
		
		System.out.println("\n\nSearching the node having value 200: ");
		list.search(200);
		
		
		System.out.println("\n\nDeleting the node having location = 2: ");
		System.out.println("Before deletion...");
		list.traverse();
		list.deleteNode(2);
		System.out.println("After deletion...");
		list.traverse();
		
		
		System.out.println("\n\nDeleting the node having location = 0: ");
		System.out.println("Before deletion...");
		list.traverse();
		list.deleteNode(0);
		System.out.println("After deletion...");
		list.traverse();
		
		
		System.out.println("\n\nDeleting the node having location = 15: ");
		System.out.println("Before deletion...");
		list.traverse();
		list.deleteNode(15);
		System.out.println("After deletion...");
		list.traverse();
		
		
		System.out.println("\n\nDeleting the node having location = 15: ");
		System.out.println("Before deletion...");
		list.traverse();
		list.deleteNode(15);
		System.out.println("After deletion...");
		list.traverse();
		
		
		list.deleteLL();
		list.traverse();
		
	}

}
