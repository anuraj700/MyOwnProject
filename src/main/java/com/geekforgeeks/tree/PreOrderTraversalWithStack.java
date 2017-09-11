package com.geekforgeeks.tree;

import java.util.Stack;

public class PreOrderTraversalWithStack {

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
		st.push(root);

		while (!st.isEmpty()) {
			Node item = st.pop();
			System.out.print(item.key + " ");
			if (item.right != null) {
				st.push(item.right);
			}
			if(item.left != null){
				st.push(item.left);
			}
		}

	}

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(5);
		root.right.left = new Node(2);
		PreOrderTraversalWithStack tree = new PreOrderTraversalWithStack();
		tree.printPreOrder(root);

	}

}
