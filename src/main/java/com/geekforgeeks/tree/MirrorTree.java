package com.geekforgeeks.tree;

import com.geekforgeeks.tree.SizeOfTree.Node;

public class MirrorTree {

	void mirror(Node root) {
		if(root==null)
			return;
		
		mirror(root.left);
		mirror(root.right);
		Node temp = root.left;
		root.left = root.right;
		root.right = temp;
	}

	void inOrder(Node node) {
		if (node == null)
			return;

		inOrder(node.left);
		System.out.print(node.key + " ");
		inOrder(node.right);
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
		MirrorTree tree = new MirrorTree();
        System.out.println("Inorder traversal of input tree is :");
        tree.inOrder(root);
		tree.mirror(root);
        System.out.println("\nInorder traversal of Mirror tree is :");
        tree.inOrder(root);

	}

}
