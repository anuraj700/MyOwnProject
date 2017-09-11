package com.geekforgeeks.tree;

import com.geekforgeeks.tree.SizeOfTree.Node;

public class PrintRootToLeaf {

	void printPathRecur(Node root, int pathlen, int[] paths) {

		if (root == null)
			return;
		paths[pathlen] = root.key;
		pathlen++;

		if (root.left == null && root.right == null) {
			for (int i = 0; i < pathlen; i++) {
				System.out.print(paths[i] + " ");
			}
			System.out.println();
		} else {
			printPathRecur(root.left, pathlen, paths);
			printPathRecur(root.right, pathlen, paths);

		}

	}

	public static void main(String[] args) {
		Node root = new Node(0);
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		int[] paths = new int[1000];
		PrintRootToLeaf obj = new PrintRootToLeaf();
		obj.printPathRecur(root, 0, paths);
	}

}
