package com.geekforgeeks.tree;

import java.util.Stack;

public class PostOrderTraversalWith2Stack {

	static class Node {
		int key;
		Node left, right;

		public Node(int item) {
			this.key = item;
			left = right = null;
		}
	}

	void printPreOrder(Node root) {

		if (root == null)
			return;
		Stack<Node> st = new Stack<Node>();
		Stack<Node> stfinal = new Stack <Node>();
		st.push(root);

		while (!st.isEmpty()) {
			Node item = st.pop();
			//System.out.print(item.key + " ");
			stfinal.push(item);
			if(item.left != null){
				st.push(item.left);
			}
			if (item.right != null) {
				st.push(item.right);
			}
			
		}
		while (!stfinal.isEmpty()){
			Node temp = stfinal.pop();
			System.out.print(temp.key+" " );
		}

	}

	public static void main(String[] args) {
		Node root = new Node(11);
		root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
		PostOrderTraversalWith2Stack tree = new PostOrderTraversalWith2Stack();
		tree.printPreOrder(root);

	}

}
