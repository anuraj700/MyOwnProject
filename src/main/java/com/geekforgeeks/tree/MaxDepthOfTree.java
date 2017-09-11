package com.geekforgeeks.tree;

import com.geekforgeeks.tree.SizeOfTree.Node;

public class MaxDepthOfTree {

	public int height(Node root) {
		if (root == null)
			return 0;
		else {
			int lheight = height(root.left);
			int rheight = height(root.right);

			if (lheight > rheight)
				return lheight + 1;
			else
				return rheight + 1;
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
		MaxDepthOfTree tree = new MaxDepthOfTree();
		System.out.println("Size is :" + tree.height(root));
	}

}
