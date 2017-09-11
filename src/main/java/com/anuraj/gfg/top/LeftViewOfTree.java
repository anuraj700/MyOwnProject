package com.anuraj.gfg.top;

public class LeftViewOfTree {

	static class Node {
		int key;
		Node left, right;

		public Node(int key) {
			this.key = key;
			left = right = null;
		}
	}

	static void printLeftViewLokesh(Node r) {
		if (r == null)
			return;

		if (r.left != null) {
			System.out.print(r.left.key + " ");
		}

		printLeftViewLokesh(r.left);
		printLeftViewLokesh(r.right);

	}
	static int maxLevel =0;
	
	static void printLeftViewGfg(Node root,int level){
		if(root == null)
			return;
		if(maxLevel<level){
			System.out.print(root.key+" ");
			maxLevel  =level;
		}
		printLeftViewGfg(root.left, level+1);
		printLeftViewGfg(root.right, level+1);
	}

	public static void main(String[] args) {
		Node r = new Node(1);
		r.left = new Node(2);
		r.right = new Node(3);
		r.left.left = new Node(4);
		r.left.right = new Node(5);
		r.right.right = new Node(6);
		System.out.print(r.key + " ");
		printLeftViewLokesh(r);

		System.out.println();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.right = new Node(4);
		root.left.right.right = new Node(5);
		root.left.right.right.right = new Node(6);
		System.out.print(root.key + " ");
		printLeftViewLokesh(root);
		System.out.println("\ncalling out gfg program");
		printLeftViewGfg(root,1);

	}

}
