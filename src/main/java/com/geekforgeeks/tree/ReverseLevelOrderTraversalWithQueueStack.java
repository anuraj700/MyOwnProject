package com.geekforgeeks.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrderTraversalWithQueueStack {

	Node root;

	public ReverseLevelOrderTraversalWithQueueStack() {
		root = null;
	}

	void printLevelOrder() {
		Queue<Node> queue = new LinkedList<Node>();
		Stack<Node> st = new Stack<Node>();
		if (root != null) {
			queue.add(root);
		}

		while (!queue.isEmpty()) {
			Node tempNode = queue.poll();
			//System.out.print(tempNode.key + " ");
			st.push(tempNode);
			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}
			if (tempNode.left != null) {
				queue.add(tempNode.left);
			}
			
		}
		
		while(!st.isEmpty()){
			Node temp = st.pop();
			System.out.print(temp.key+ " ");
		}

	}

	public static void main(String[] args) {
		ReverseLevelOrderTraversalWithQueueStack tree = new ReverseLevelOrderTraversalWithQueueStack();
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
