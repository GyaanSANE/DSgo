package dataStructures.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

import dataStructures.node.BinaryNode;

public class AVLTree {
	Queue<BinaryNode> queue;
	BinaryNode root;
	
	public AVLTree() {
	root = null;
	queue = new LinkedList<BinaryNode>();
	}
	
	//insert
	public void insert(int val) {
		root = insert(root,val);
	}
	
	//helper
	private BinaryNode insert(BinaryNode currentNode, int val) {
		if (currentNode == null) {
			System.out.println(val+" inserted.");
			return createNode(val);
		}else if(val<=currentNode.getValue()){
			currentNode.setLeft(insert(currentNode.getLeft(), val));
		}else if (val>currentNode.getValue()) {
			currentNode.setRight(insert(currentNode.getRight(), val));
		}
		//avl part
		
		int balance = checkBalance(currentNode.getLeft(), currentNode.getRight());
		if(balance>1) {
			if(checkBalance(currentNode.getLeft().getLeft(), currentNode.getLeft().getRight())>0) {
				currentNode = rightRotate(currentNode); //LL 
			}else {
				currentNode.setLeft(leftRotate(currentNode.getLeft()));//LR
				currentNode= rightRotate(currentNode);
			}
		}else if(balance<-1) {
			if(checkBalance(currentNode.getRight().getLeft(), currentNode.getRight().getRight())<0) {
				currentNode = leftRotate(currentNode);//RR
			}else {
				currentNode.setRight(rightRotate(currentNode.getRight()));//RL
				currentNode = leftRotate(currentNode);
			}
		}
		if(currentNode.getLeft()!=null) {
			currentNode.getLeft().setHeight(calcHeight(currentNode.getLeft()));
		}
		if(currentNode.getRight()!=null) {
			currentNode.getRight().setHeight(calcHeight(currentNode.getRight()));
		}
		currentNode.setHeight(calcHeight(currentNode));
		return currentNode;
	}
	
	
	//delete
	public void delete(int val) {
		System.out.println("Deleting "+val+"...");
		delete(root,val);
	}
	//helper
	private BinaryNode delete(BinaryNode currentNode, int val) {
		if(currentNode == null) {
			return null;
		}else if(val < currentNode.getValue()) {
			currentNode.setLeft(delete(currentNode.getLeft(), val));
		}else if(val > currentNode.getValue()) {
			currentNode.setRight(delete(currentNode.getRight(), val));
		}else {//current node to be deleted
			if(currentNode.getLeft()!=null && currentNode.getRight()!=null) {//both child
				BinaryNode min = nextMin(currentNode.getRight());
				int temp = min.getValue();
				currentNode.setValue(temp);
				delete(currentNode.getRight(),temp);
			}else if (currentNode.getLeft()!=null) {
				currentNode = currentNode.getLeft();
			}else if (currentNode.getRight()!=null) {
				currentNode = currentNode.getRight();
			}else {
				currentNode = null;
			}
			return currentNode;
		}
		//avl part
		int balance = checkBalance(currentNode.getLeft(), currentNode.getRight());
		if(balance>1) {
			if(checkBalance(currentNode.getLeft().getLeft(), currentNode.getLeft().getRight())>0) {
				currentNode = rightRotate(currentNode); //LL 
			}else {
				currentNode.setLeft(leftRotate(currentNode.getLeft()));//LR
				currentNode= rightRotate(currentNode);
			}
		}else if(balance<-1) {
			if(checkBalance(currentNode.getRight().getLeft(), currentNode.getRight().getRight())<0) {
				currentNode = leftRotate(currentNode);//RR
			}else {
				currentNode.setRight(rightRotate(currentNode.getRight()));//RL
				currentNode = leftRotate(currentNode);
			}
		}
		if(currentNode.getLeft()!=null) {
			currentNode.getLeft().setHeight(calcHeight(currentNode.getLeft()));
		}
		if(currentNode.getRight()!=null) {
			currentNode.getRight().setHeight(calcHeight(currentNode.getRight()));
		}
		currentNode.setHeight(calcHeight(currentNode));
		return currentNode;
	}
	
	//calculate height
	private int calcHeight(BinaryNode currentNode) {
		if(currentNode == null) {
			return 0;
		}else {
			return 1+ Math.max(((currentNode.getLeft()!=null)? currentNode.getLeft().getHeight(): -1),
								((currentNode.getRight()!=null)? currentNode.getRight().getHeight():-1));
		}
	}
	//check Balance
	private int checkBalance(BinaryNode leftNode, BinaryNode rightNode) {
		if(leftNode==null && rightNode==null) {
			return 0;
		}else if(leftNode==null) {		
			return -1 * (rightNode.getHeight()+1);
		}else if(rightNode==null) {
			return leftNode.getHeight()+1;
		}else {
			return (leftNode.getHeight()-rightNode.getHeight());
		}	
	}
	
	//right rotate
	private BinaryNode rightRotate(BinaryNode currentNode) {
		BinaryNode newRoot = currentNode.getLeft();
		currentNode.setLeft(newRoot.getRight());
		newRoot.setRight(currentNode);
		currentNode.setHeight(calcHeight(currentNode));
		newRoot.setHeight(calcHeight(newRoot));
		return newRoot;
	}
	
	//left rotate
	private BinaryNode leftRotate(BinaryNode currentNode) {
		BinaryNode newRoot = currentNode.getRight();
		currentNode.setRight(newRoot.getLeft());
		newRoot.setLeft(currentNode);
		currentNode.setHeight(calcHeight(currentNode));
		newRoot.setHeight(calcHeight(newRoot));
		return newRoot;
	}
	
	//create node
	private BinaryNode createNode(int val) {
		BinaryNode node = new BinaryNode();
		node.setValue(val);
		node.setHeight(0);
		return node;
	}
	
	//next Min
	private BinaryNode nextMin(BinaryNode root) {
		if (root.getLeft()==null) {
				return root;
		}else {
				return nextMin(root.getLeft());
		}
	}
	
	
	//level
	public void levelOrder() {
		if (root!=null) {
			queue.add(root);
			while(!queue.isEmpty()) {
				BinaryNode temp = queue.remove();
				System.out.print(temp.getValue()+", ");
				if(temp.getLeft() != null) {
					queue.add(temp.getLeft());
				}
				if(temp.getRight()!=null) {
					queue.add(temp.getRight());
				}	
			}  System.out.println("\n");
		}else {
			System.out.println("Tree is Empty!");
		}
	}
	
	//graphical print
	void printTreeGraphically() {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		Queue<Integer> level = new LinkedList<Integer>();
		
		int CurrentLevel = 1;
		boolean previousLevelWasAllNull = false;
		queue.add(root);
		level.add(1);
		
		System.out.println("\nPrinting Level order traversal of Tree...");
		if(root == null) {
			System.out.println("Tree does not exists !");
			return;
		}	
		while (!queue.isEmpty()) {
			if(CurrentLevel == level.peek()) { //if we are in the same level
				if(queue.peek()==null) {
					queue.add(null);level.add(CurrentLevel+1);
				}else {
					queue.add(queue.peek().getLeft());level.add(CurrentLevel+1);
					queue.add(queue.peek().getRight());level.add(CurrentLevel+1);
					previousLevelWasAllNull = false;
				}
				BinaryNode temp = queue.remove();
				System.out.print( (temp==null)? "null  " :temp.getValue() + "  ");level.remove();
			}else { //level has changed
				System.out.println("\n");
				CurrentLevel++;
				if(previousLevelWasAllNull == true) {
					break;
				}
				previousLevelWasAllNull = true;
			}
		}//end of loop
	}
}
