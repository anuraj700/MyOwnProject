package com.geekforgeeks.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BFSTreeTraversals2 {

	Node root;

	public BFSTreeTraversals2() {
		root = null;
	}

	void printLevelOrder() {

		Queue<Node> q = new LinkedList<Node>();
		q.add(root);

		while (!q.isEmpty()) {
			Node temp = q.poll();
			System.out.print(temp.key + " ");

			if (temp.left != null) {
				q.add(temp.left);
			}

			if (temp.right != null) {
				q.add(temp.right);
			}
		}
	}

	void printLevelOrderLine() {

		Queue<Node> q = new LinkedList<Node>();
		q.add(root);

		while (!q.isEmpty()) {
			int nodeCount=q.size();
			if(nodeCount==0){
				break;
			}
			while(nodeCount>0){
				Node temp = q.poll();
				System.out.print(temp.key + " ");

				if (temp.left != null) {
					q.add(temp.left);
				}

				if (temp.right != null) {
					q.add(temp.right);
				}
				nodeCount--;
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		BFSTreeTraversals2 tree = new BFSTreeTraversals2();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.right = new Node(6);

		System.out.println("Level order traversal of binary tree is ");
		tree.printLevelOrder();
		
		System.out.println("\nLevel order traversal of binary tree line by line is ");
		tree.printLevelOrderLine();
	}

}
