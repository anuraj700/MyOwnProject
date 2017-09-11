package com.geekforgeeks.tree;


public class SizeOfTree {

	static class Node {
		int key;
		Node left, right;

		public Node(int item) {
			this.key = item;
			left = right = null;
		}
	}

	public int size(Node root) {
		if (root == null)
			return 0;
		else
			return 1 + size(root.left) + size(root.right);

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
		SizeOfTree tree = new SizeOfTree();
		System.out.println("Size is :" + tree.size(root));
	}

}
