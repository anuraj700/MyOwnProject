package com.geekforgeeks.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalWithQueueLineByLine {

	Node root;

	public LevelOrderTraversalWithQueueLineByLine() {
		root = null;
	}

	void printLevelOrder() {
		Queue<Node> queue = new LinkedList<Node>();
		if (root != null) {
			queue.add(root);
		}

		while(true){
			
			int nodeCount = queue.size();
			if(nodeCount ==0){
				break;
			}
			while (nodeCount > 0) {
				Node tempNode = queue.poll();
				System.out.print(tempNode.key + " ");
				if (tempNode.left != null) {
					queue.add(tempNode.left);
				}
				if (tempNode.right != null) {
					queue.add(tempNode.right);
				}
				nodeCount --;
			}
			System.out.println();
		}
		

	}

	public static void main(String[] args) {
		LevelOrderTraversalWithQueueLineByLine tree = new LevelOrderTraversalWithQueueLineByLine();
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
