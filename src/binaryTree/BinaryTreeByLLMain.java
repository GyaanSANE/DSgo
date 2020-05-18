package binaryTree;

public class BinaryTreeByLLMain {

public static void main(String[] args) {
		
		
		//Create a blank Tree
		BinaryTreeByLL tree = new BinaryTreeByLL();
		
		
		//Insert 10 nodes in the tree
		System.out.println("Inserting 10 nodes to tree");
		for(int i=1;i<=10;i++) {
			tree.insert(i*10);
		}
		
		
		System.out.println("\nLevel-order of tree:");
		tree.levelOrder();
		System.out.println();
		
		
		System.out.println("\nPre-order of tree:");
		tree.preOrder(tree.root);//alternatively create another method that passes root to preOrder, if root is private
		System.out.println();	 //the new method could also check if tree is empty
		
		
		System.out.println("\nPost-order of tree:");
		tree.postOrder(tree.root);
		System.out.println();
		
		
		System.out.println("\nIn-order of tree:");
		tree.inOrder(tree.root);
		System.out.println();
		
		
		System.out.println("\nSearching node 50 in the tree...");
		tree.search(50);
		
		
		System.out.println("\nSearching node 500 in the tree...");
		tree.search(500);
		
		
		System.out.println("\nDeleting node having value-5 in the tree...");
		tree.deleteNode(5);
		
		
		System.out.println("\nDeleting node having value-50 in the tree...");
		tree.deleteNode(50);
		tree.levelOrder();
		
		System.out.println("\n\nDeleting node having value-10 in the tree...");
		tree.deleteNode(10);
		tree.levelOrder();
		
		System.out.println("\n\nDeleting node having value-80 in the tree...");
		tree.deleteNode(80);
		tree.levelOrder();
		
		
		System.out.println("Deleting the entire Tree");
		tree.deleteTree();
		tree.search(10);
		System.out.println("\nInserting 3 values.");
		tree.insert(10);
		tree.insert(20);
		tree.insert(30);
		
		tree.levelOrder();
		tree.deleteNode(10);
		tree.levelOrder();
		tree.deleteNode(30);
		tree.levelOrder();
		tree.deleteNode(20);
		tree.levelOrder();
		tree.deleteNode(10);
				
	}


	
}
