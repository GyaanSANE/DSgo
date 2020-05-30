package dataStructures.binaryTree;

public class BinaryTreeByArray {
private int size;
private int end;
	int arr[];
	
public BinaryTreeByArray(int size) {
arr = new int[size+1];//since 0 will remain empty
this.size = size+1;
end =0;
}
	//insert
public void insert(int val) {
	if (end<size-1) {
		end++;
		arr[end]=val;
		System.out.println(val+" inserted. end = "+end);
	} else {
		System.out.println("Tree is full");
	}
}
//delete Node
public void delete(int val) {
	if (end ==0) {
		System.out.println("Tree is en=mpty");
		return;
	}
	for (int i=1;i<=end;i++) {
		if(arr[i]==val ) {
			arr[i]= arr[end];
			end--;
			System.out.println(val+"deleted. end is "+end);
			return;
		}
	}
	System.out.println("Value not found");
}

//search
public void search(int val) {
	for (int i=1;i<=end;i++) {
		if(arr[i]==val ) {
			System.out.println(val+"found.");
			return;
		}
	}System.out.println(val+"NOT found!");	
}
//level order
public void levelOrder() {
	for (int i=1;i<=end;i++) {
			System.out.print(arr[i]+" ");		
	}	
}
//calling method pre order
public void preOrder() {
	if (end ==0) {
		System.out.println("Empty Tree");
	}else {
		preOrder(1);
	}
}
//helper method
public void preOrder(int root) {
	System.out.print(arr[root]+" ");
	if(2*root<size) {
		if(arr[2*root]!=0) {
			preOrder(2*root);
		}
	}
	if(2*root+1<size) {
		if(arr[2*root+1]!=0) {
			preOrder(2*root+1);
		}
	}
}

//in order
public void inOrder() {
	if (end ==0) {
		System.out.println("Empty Tree");
	}else {
		inOrder(1);
	}
}
//helper method
public void inOrder(int root) {
	if(2*root<size) {
		if(arr[2*root]!=0) {
			inOrder(2*root);
		}
	}
	System.out.print(arr[root]+" ");
	if(2*root+1<size) {
		if(arr[2*root+1]!=0) {
			inOrder(2*root+1);
		}
	}
}
//post order
public void postOrder() {
	if (end ==0) {
		System.out.println("Empty Tree");
	}else {
		postOrder(1);
	}
}
//helper method
public void postOrder(int root) {
	if(2*root<size) {
		if(arr[2*root]!=0) {
			postOrder(2*root);
		}
	}
	if(2*root+1<size) {
		if(arr[2*root+1]!=0) {
			postOrder(2*root+1);
		}
	}
	System.out.print(arr[root]+" ");

}
//empty tree
public void deleteTree() {
	end =0;//arr = null to delete 
}

}
