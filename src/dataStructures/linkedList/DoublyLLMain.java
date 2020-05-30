package dataStructures.linkedList;

public class DoublyLLMain {

	public static void main(String[] args) {
		DoublyLL list = new DoublyLL();
		list.createDLL(5);
		list.traverse();
		
		list.insertDLL(10, 1);
		list.traverse();
		
		list.insertDLL(20, 2);
		list.traverse();
		
		list.insertDLL(30, 3);
		list.traverse();
		
		list.insertDLL(40, 4);
		list.traverse();

				
		System.out.println("\nSearching the node having value 40: ");
		list.search(40);
		
		System.out.println("\n\nSearching the node having value 400: ");
		list.search(400);
		
		
		System.out.println("\n\nLinked List in order");
		list.traverse();
		System.out.println("Linked List in reverse order");
		list.reverseTraverse();
		
		
		System.out.println("\n\nDeleting the node having location = 2: ");
		System.out.println("List before deletion: ");
		list.traverse();
		list.deleteNode(2);
		System.out.println("List after deletion: ");
		list.traverse();
		System.out.println(list.getSize());	
		
		System.out.println("\n\nDeleting the node having location = 3: ");
		System.out.println("List before deletion: ");
		list.traverse();
		list.deleteNode(3);
		System.out.println("List after deletion: ");
		list.traverse();
		
		
		list.deleteLL();
		list.traverse();
		
				
	}

}
