
package com.gfg.set402;

public class CheckBSTR1 {

	/*
	 A binary search tree (BST) is a node based binary tree data structure which has the following properties.
	 The left subtree of a node contains only nodes with keys less than the node’s key.
	 The right subtree of a node contains only nodes with keys greater than the node’s key.
	 Both the left and right subtrees must also be binary search trees.
	 */
	static class Node {

		int data;
		Node left, right;

		public Node(int item) {

			data = item;
			left = right = null;
		}
	}

	Node root;

	boolean isBST() {

		return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	boolean isBSTUtil(Node node, int min, int max) {

		if (node == null)
			return true;
		if (node.data < min || node.data > max)
			return false;
		return isBSTUtil(node.left, min, node.data - 1) && isBSTUtil(node.right, node.data + 1, max);
	}

	public static void main(String[] args) {

		CheckBSTR1 tree = new CheckBSTR1();
		tree.root = new Node(4);
		tree.root.left = new Node(2);
		tree.root.right = new Node(5);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(3);
		if (tree.isBST())
			System.out.println("IS BST");
		else
			System.out.println("Not a BST");
	}
}
