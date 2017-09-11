package com.geekforgeeks.tree;

import java.util.Stack;

public class InOrderTraversalWithStack {

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
		Stack<Node> st = new Stack<Node>();

		while (current != null) {
			st.push(current);
			current = current.left;
		}

		while (!st.isEmpty()) {
			Node item = st.pop();
			System.out.print(item.key + " ");
			if (item.right != null) {
				current = item.right;
			}
			while (current != null) {
				st.push(current);
				current = current.left;
			}
		}

	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		InOrderTraversalWithStack tree = new InOrderTraversalWithStack();
		tree.printInOrder(root);

	}

}
