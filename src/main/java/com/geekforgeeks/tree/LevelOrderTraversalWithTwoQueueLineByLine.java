package com.geekforgeeks.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalWithTwoQueueLineByLine {

	static class Node {
		int key;
		Node left, right;

		public Node(int item) {
			this.key = item;
			left = right = null;
		}
	}

	void printLevelOrder(Node root) {
		Queue<Node> queue1 = new LinkedList<Node>();
		Queue<Node> queue2 = new LinkedList<Node>();

		if (root == null) {
			return;
		}
		queue1.add(root);
		while (!queue1.isEmpty() || !queue2.isEmpty()) {

			while (!queue1.isEmpty()) {
				Node tempNode = queue1.poll();
				System.out.print(tempNode.key + " ");
				if (tempNode.left != null) {
					queue2.add(tempNode.left);
				}
				if (tempNode.right != null) {
					queue2.add(tempNode.right);
				}
			}
			System.out.println();
			while (!queue2.isEmpty()) {
				Node tempNode = queue2.poll();
				System.out.print(tempNode.key + " ");
				if (tempNode.left != null) {
					queue1.add(tempNode.left);
				}
				if (tempNode.right != null) {
					queue1.add(tempNode.right);
				}
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		LevelOrderTraversalWithTwoQueueLineByLine tree = new LevelOrderTraversalWithTwoQueueLineByLine();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		System.out
				.println("Printing level order traversal of tree using queue");
		tree.printLevelOrder(root);
	}

}
