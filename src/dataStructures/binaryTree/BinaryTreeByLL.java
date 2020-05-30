package dataStructures.binaryTree;
import java.util.LinkedList;
import java.util.Queue;

import dataStructures.node.BinaryNode;

public class BinaryTreeByLL {
 BinaryNode root;
//private BinaryNode last;  //can add getParent to get left child and mark it a last in case of deletion swap. implement suitable handling
Queue<BinaryNode> queue;

public BinaryTreeByLL() {
	 queue = new LinkedList<BinaryNode>();
}

//insert
public void insert (int val) {
	BinaryNode node = new BinaryNode();
	node.setValue(val);
	if(root==null) {
		root = node;
		System.out.println("Inserted "+val);
	}else {
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryNode temp = queue.remove();
			if(temp.getLeft() != null) {
				queue.add(temp.getLeft());
				if(temp.getRight()!=null) {
					queue.add(temp.getRight());
				}else {
					temp.setRight(node);
					System.out.println("Inserted "+val );
					queue.clear();
					return;
				}
			}else {
				temp.setLeft(node);
				System.out.println("Inserted "+val );
				queue.clear();
				return;
			}
		}
	}
}

//delete node
public void deleteNode(int val) {
	BinaryNode toDelete=null;
	BinaryNode prevToLast=null;//set to root, 
	int val2=0;
	if (root!=null) {
		//in case root doesnt have any child
		if(root.getValue()==val && root.getLeft()==null && root.getRight()==null) {
			root=null;
			return;
		}
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryNode temp = queue.remove();
			if(temp.getValue()==val) {
				toDelete = temp;
			}
			if(temp.getLeft() != null) {
				prevToLast=temp;
				queue.add(temp.getLeft());
				if(temp.getRight()!=null) {
					queue.add(temp.getRight());
				}
			}	
		}		
		if(toDelete == null) {
			System.out.println("Value to be deleted not found");
			return;
		}
		if(prevToLast.getRight()==null) {
			val2 = prevToLast.getLeft().getValue();
			prevToLast.setLeft(null);
		}else {
			val2= prevToLast.getRight().getValue();
			prevToLast.setRight(null);
		}
		toDelete.setValue(val2);
		System.out.println(val+" Deleted. Last node was "+val2);//val2 check for curiosity
	} else {
		System.out.println("Tree is empty!");
	}
	
}
//search
public void search(int val) {
	if(root!= null) {
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryNode temp = queue.remove();
			if(temp.getValue()==val) {
				System.out.println("Element "+val+" found!");
				queue.clear();
				return;
			}
			if(temp.getLeft() != null) {
				queue.add(temp.getLeft());
				if(temp.getRight()!=null) {
					queue.add(temp.getRight());
				}
			}	
		}
		System.out.println("Element "+val+" NOT found!!!");
	}else {
		System.out.println("Tree is empty");
	}
}

//delete tree..empty tree
public void deleteTree() {
	root =null;
	System.out.println("Tree Deleted.");
}

//levelOrder
public void levelOrder() {
	if (root!=null) {
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryNode temp = queue.remove();
			System.out.println(temp.getValue()+", ");
			if(temp.getLeft() != null) {
				queue.add(temp.getLeft());
				if(temp.getRight()!=null) {
					queue.add(temp.getRight());
				}
			}	
		}
	}else {
		System.out.println("Tree is Empty!");
	}
}

//preorder
public void preOrder(BinaryNode root) {
	System.out.println(root.getValue()+", ");
	if(root.getLeft()!=null) {
		preOrder(root.getLeft());
	}
	if(root.getRight()!=null) {
		preOrder(root.getRight());
	}
}


//postorder
public void postOrder(BinaryNode root) {	
	if(root.getLeft()!=null) {
		postOrder(root.getLeft());
	}
	if(root.getRight()!=null) {
		postOrder(root.getRight());
	}
	System.out.println(root.getValue()+", ");
}

//inorder
public void inOrder(BinaryNode root) {	
	if(root.getLeft()!=null) {
		inOrder(root.getLeft());
	}
	System.out.println(root.getValue()+", ");
	if(root.getRight()!=null) {
		inOrder(root.getRight());
	}
}


} 
 