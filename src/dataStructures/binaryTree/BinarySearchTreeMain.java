package dataStructures.binaryTree;

public class BinarySearchTreeMain {

public static void main(String[] args) {
	// implement graphical print
	
	//Constructor
		BinarySearchTree tree = new BinarySearchTree();
		
		//tree.printTreeGraphically();
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(25);
		tree.insert(50);
		tree.insert(45);
		tree.insert(70);
		tree.insert(35);
		tree.levelOrder();
		tree.printTreeGraphically();
		tree.inOrder();
		System.out.println();
		tree.delete(25);
		tree.printTreeGraphically();

		tree.delete(40);
		tree.printTreeGraphically();

		tree.delete(10);
		tree.printTreeGraphically();
		tree.delete(30);
		tree.printTreeGraphically();
		tree.levelOrder();
		tree.delete(30);
		tree.delete(35);
		tree.delete(45);
		tree.delete(20);
		tree.delete(15);
		tree.delete(5);
		tree.delete(50);
		//tree.printTreeGraphically();
		tree.delete(70);
		tree.delete(5);
		tree.levelOrder();
		//Deleting entire Tree
		//tree.deleteTree();


		
	}//end of method


}
