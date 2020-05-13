package linkedList;

public class SinglyLLMain {
public static void main(String[] args) {
		
		SinglyLL list = new SinglyLL();
		list.createSLL(5);
		list.traverse();
		
		list.insertLL(10, 1);
		list.traverse();
		
		list.insertLL(20, 2);
		list.traverse();
		
		list.insertLL(30, 2);
		list.traverse();
		
		list.insertLL(40, 1);
		list.traverse();
	
		list.traverse();
		System.out.println();
			
		
		System.out.println("\nSearching the node having value 40...");
		list.search(40);

		System.out.println("\nSearching the node having value 500...");
		list.search(500);
		
		
		System.out.println("\n\nDeleting the node having location = 0: ");
		System.out.println("Before Deletion:");
		list.traverse();
		list.deleteNode(0);
		System.out.println("After Deletion:");
		list.traverse();
		System.out.println();
		
		System.out.println("\n\nDeleting the node having location = 2: ");
		System.out.println("Before Deletion:");
		list.traverse();
		list.deleteNode(2);
		System.out.println("After Deletion:");
		list.traverse();
		System.out.println();
		
	
		System.out.println("\n\nDeleting the node having location = 100: ");
		System.out.println("Before Deletion:");
		list.traverse();
		list.deleteNode(100);
		System.out.println("After Deletion:");
		list.traverse();
		System.out.println();
		
		
		list.deleteLL();
		list.traverse();
		
	
	}

}
