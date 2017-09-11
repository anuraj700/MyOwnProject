package com.geekforgeeks.tree;


public class InOrderTraversalWithoutStack {

	static class Node {
		int key;
		Node left, right;

		public Node(int item) {
			this.key = item;
			left = right = null;
		}
	}

	void printInOrder(Node root) {

		if (root == null)
			return;
		Node current = root;
		Node pre = null;
		
		while(current != null){
			
			if(current.left == null){
				System.out.print(current.key+" ");
				current = current.right;
			}else{
				
				pre   = current.left;
				while(pre.right != null && pre.right != current ){
					pre = pre.right;
				}
				if(pre.right == null){
					pre.right = current;
					current = current.left;
				}else{
					pre.right = null;
					System.out.print(current.key+" ");
					current= current.right;
				}
				
			}
			
			
		}

	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		InOrderTraversalWithoutStack tree = new InOrderTraversalWithoutStack();
		tree.printInOrder(root);

	}

}
