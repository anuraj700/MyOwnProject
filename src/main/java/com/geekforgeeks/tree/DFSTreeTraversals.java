package com.geekforgeeks.tree;

public class DFSTreeTraversals {

	Node root;

	DFSTreeTraversals() {
		root = null;
	}

	void printPostOrder(Node node) {

		if (node == null) {
			return;
		}
		printPostOrder(node.left);
		printPostOrder(node.right);
		System.out.print(node.key + " ");
	}

	void printPreOrder(Node node) {

		if (node == null) {
			return;
		}
		System.out.print(node.key + " ");

		printPreOrder(node.left);
		printPreOrder(node.right);
	}

	void printInOrder(Node node) {

		if (node == null) {
			return;
		}
		printInOrder(node.left);
		System.out.print(node.key + " ");
		printInOrder(node.right);
	}

	void printPostOrder() {
		printPostOrder(root);
	}

	void printInOrder() {
		printInOrder(root);
	}

	void printPreOrder() {
		printPreOrder(root);
	}

	public static void main(String[] args) {
		DFSTreeTraversals tree = new DFSTreeTraversals();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		System.out.println("Printing post order");
		tree.printPostOrder();
		System.out.println("\nPrinting pre order");
		tree.printPreOrder();
		System.out.println("\nPrinting in order");
		tree.printInOrder();

		Node root2 = new Node(1);
		root2.left = new Node(2);
		root2.right = new Node(3);
		root2.left.left = new Node(4);
		root2.left.right = new Node(5);
		System.out.println("\n\nPrinting post order");
		tree.printPostOrder(root2);
		System.out.println("\nPrinting pre order");
		tree.printPreOrder(root2);
		System.out.println("\nPrinting in order");
		tree.printInOrder(root2);

	}
}
