package com.geekforgeeks.tree;

public class LevelOrderTraversal {

	Node root;
	public LevelOrderTraversal(){
		root = null;
	}
	
	 int height(Node root){
		
		if (root==null)
			return 0;
		else{
			int lheight = height(root.left);
			int rheight = height(root.right);
			
			if(lheight > rheight)
				return lheight+1;
			else
				return rheight +1;
		}
	}
	
	 void printLevelOrder(){
		 int h = height(root);
		 for (int i=0;i<=h;i++ ){
			 printGivenLevel(root,i);
		 }
	 }
	 
	 void printGivenLevel(Node root, int h){
		 
		 if(root == null)
			 return;
		 if(h==1){
			 System.out.print(root.key+ " " );
		 } else if(h >1){
			 printGivenLevel(root.left, h-1);
			 printGivenLevel(root.right, h-1);
		 }
		 
		 
	 }
	 
	 public static void main(String[] args) {
		LevelOrderTraversal tree = new LevelOrderTraversal();
		tree.root=new Node(1);
		tree.root.left =new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right= new Node(5);
		System.out.println("Printing level order traversal of tree");
		tree.printLevelOrder();
	}
	
}
