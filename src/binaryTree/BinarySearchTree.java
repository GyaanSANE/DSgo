package binaryTree;
import java.util.LinkedList;
import java.util.Queue;

import node.BinaryNode;
public class BinarySearchTree {
Queue<BinaryNode> queue;
BinaryNode root;
static int valToBeDeleted;
	public BinarySearchTree() {
		queue = new LinkedList<BinaryNode>();
	}
	
	public void insert(int val) {
		if (root==null) {
			BinaryNode node = new BinaryNode();
			node.setValue(val);
			root = node;
			System.out.println(val+" inserted.");
		}else {
			insert(root,val);
		}
	}
	
	public void insert(BinaryNode root, int val) {
		BinaryNode node = new BinaryNode();
		node.setValue(val);
		if(val<root.getValue()) {
			if(root.getLeft()==null) {
				root.setLeft(node);
				System.out.println(val+" inserted.");
			}else {
				insert(root.getLeft(), val);
			}
		}else if (val>root.getValue()) {
			if(root.getRight()==null) {
				root.setRight(node);
				System.out.println(val+" inserted.");
			}else {
				insert(root.getRight(),val);
			}
		}
	}
	
	public void search(int val) {
		if (root!=null) {
			boolean found = search(root,val);
			if(found ==false) {
				System.out.println(val+ " Not found!");
			}
		}else {
			System.out.println("Tree doesnt exist.");
		}
	}
	
	public boolean search(BinaryNode root, int val) {
		if (root.getValue()==val) {
			System.out.println(val+" found");
			return true;
		}else {
			boolean fnd=false;
			if (val<root.getValue()) {
				if(root.getLeft()!=null) {
					fnd = search(root.getLeft(),val);
				}
			}else if(val>root.getValue()) {
				if(root.getRight()!=null) {
					fnd = search(root.getRight(),val);
				}
			}
			return fnd;
		}
	}
	
	
	public void delete(int val) {
		if(root!=null) {
			if(val == root.getValue() && root.getLeft()==null  && root.getRight()==null) {
				root= null;
				System.out.println(val+" deleted.");
			}else {
			valToBeDeleted = val;
			delete(root,val);}
		}else {
			System.out.println("Tree doesnt exist");
		}
	}
	
	public void delete(BinaryNode root,int val) {//might print multiple deleted statements
		
		if (val<root.getValue()) {
			if(root.getLeft()!=null) {
			//left child has value and no children
			if(root.getLeft().getValue()==val && root.getLeft().getLeft()==null && root.getLeft().getRight()==null) {
				root.setLeft(null);
				if(valToBeDeleted == val) {
				System.out.println(val+ " deleted");}
				return;
			}else {
				delete(root.getLeft(),val);
			}}
			else {
				System.out.println(val+" not found. Cant delete");//else val not found
			}
		} else if(val>root.getValue()) {
			 if(root.getRight()!=null) {
			//right child has value and no children
			if(root.getRight().getValue()==val && root.getRight().getRight()==null && root.getRight().getLeft()==null) {
				root.setRight(null);
				if(valToBeDeleted == val) {
				System.out.println(val+" deleted");}
				return;
			}else{
				delete(root.getRight(), val);
			}} else {
				System.out.println(val+" not found. Cant delete");
			}
		}//value = root value
		else if(val == root.getValue()) {
			//if root has both children
			if(root.getLeft()!=null && root.getRight()!=null) {
				BinaryNode min = nextMin(root.getRight());
				int temp = min.getValue();
				delete(root,temp);
				root.setValue(temp);
				if(valToBeDeleted == val) {
				System.out.println(val+" deleted.");}
				return;
			}//root has only left child
			else if(root.getRight()==null && root.getLeft()!=null) {
				root.setRight(root.getLeft().getRight());
				root.setValue(root.getLeft().getValue());
				root.setLeft(root.getLeft().getLeft());
				if(valToBeDeleted == val) {
				System.out.println(val+" deleted");}
				return;
			}//root has only right child
			else if(root.getRight()!=null && root.getLeft()==null) {
				root.setLeft(root.getRight().getLeft());
				root.setValue(root.getRight().getValue());
				root.setRight(root.getRight().getRight());
				if(valToBeDeleted == val) {
				System.out.println(val+" deleted");}
				return;
			}
				
		}	else {
			System.out.println(val+" not found. Cant delete");
			return;
		}
	}
	
	
	
	
	
	public BinaryNode nextMin(BinaryNode root) {
		if (root.getLeft()==null) {
			return root;
		}else {
			return nextMin(root.getLeft());
		}
	}
	
	
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
	
	
	
	public void inOrder() {
		if(root!=null) {
			inOrder(root);
			System.out.println();
		}else {
			System.out.println("Tree Empty.");
		}
	}
	
	public void inOrder(BinaryNode root) {	
		if(root.getLeft()!=null) {
			inOrder(root.getLeft());
		}
		System.out.print(root.getValue()+", ");
		if(root.getRight()!=null) {
			inOrder(root.getRight());
		}
	}
	
	//pre, post order traversal
	
////need to implement 		

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
