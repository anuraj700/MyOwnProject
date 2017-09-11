package com.geekforgeeks.tree;

public class FindLCAInBST {

	Node lca(Node root, int n1, int n2) {
		if (root == null)
			return null;
		if (root.key > n1 && root.key > n2)
			return lca(root.left, n1, n2);
		if (root.key < n1 && root.key < n2)
			return lca(root.right, n1, n2);

		return root;

	}

	// method without using recursion, iterative method to reduce space
	// complexity
	Node lca2(Node root, int n1, int n2) {
		if (root == null)
			return null;
		while (root != null) {
			if (root.key > n1 && root.key > n2)
				root = root.left;
			else if (root.key < n1 && root.key < n2)
				root = root.right;
			else
				break;
		}

		return root;
	}

	public static void main(String[] args) {
		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		FindLCAInBST tree = new FindLCAInBST();
		int n1 = 10, n2 = 14;
		Node t = tree.lca(root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.key);

		n1 = 14;
		n2 = 8;
		t = tree.lca2(root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.key);

		n1 = 10;
		n2 = 22;
		t = tree.lca(root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.key);
	}

}
