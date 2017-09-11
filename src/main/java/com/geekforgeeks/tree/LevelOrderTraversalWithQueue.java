package com.geekforgeeks.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalWithQueue {

	Node root;

	public LevelOrderTraversalWithQueue() {
		root = null;
	}

	void printLevelOrder() {
		Queue<Node> queue = new LinkedList<Node>();
		if (root != null) {
			queue.add(root);
		}

		while (!queue.isEmpty()) {
			Node tempNode = queue.poll();
			System.out.print(tempNode.key + " ");
			if (tempNode.left != null) {
				queue.add(tempNode.left);
			}
			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}
		}

	}

	public static void main(String[] args) {
		LevelOrderTraversalWithQueue tree = new LevelOrderTraversalWithQueue();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		System.out
				.println("Printing level order traversal of tree using queue");
		tree.printLevelOrder();
	}

}
