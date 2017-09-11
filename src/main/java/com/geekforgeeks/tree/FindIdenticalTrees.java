package com.geekforgeeks.tree;


public class FindIdenticalTrees {
	static class Node {
		int key;
		Node left, right;

		public Node(int item) {
			this.key = item;
			left = right = null;
		}
	}
	
	public boolean identicalTrees(Node root1, Node root2){
		if(root1 == null && root2 == null)
			return true;
		if(root1 != null && root2 != null)
			return root1.key == root2.key && identicalTrees(root1.left, root2.left) && identicalTrees(root1.right, root2.right) ;
		return false;
		
	}
	
	static boolean checkDataEquality(Node root1, Node root2){
		if(root1.key==root2.key)
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
		Node root = new Node(11);
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		
		Node root2 = new Node(11);
		root2 = new Node(1);
		root2.left = new Node(2);
		root2.right = new Node(3);
		root2.left.left = new Node(4);
		root2.left.right = new Node(5);
		root2.right.left = new Node(6);
		root2.right.right = new Node(7);
		
		Node root3 = new Node(11);
		root3 = new Node(1);
		root3.left = new Node(2);
		root3.right = new Node(3);
		root3.left.left = new Node(4);
		
		FindIdenticalTrees obj = new FindIdenticalTrees();
		System.out.println("Root 1 and Root2 identification results "+obj.identicalTrees(root, root2) );
		System.out.println("Root 1 and Root3 identification results "+ obj.identicalTrees(root, root3));
		System.out.println("Root 1 and null identification results "+ obj.identicalTrees(root, null));
		System.out.println("null and null identification results "+ obj.identicalTrees(null, null));
	}

}
