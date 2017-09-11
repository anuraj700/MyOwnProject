package com.geekforgeeks.tree;

import com.geekforgeeks.tree.SizeOfTree.Node;

public class DeleteTree {
	
	public void deleteTree(Node node){
		if(node == null)
			return;
		deleteTree(node.left);
		deleteTree(node.right);
		System.out.println("Deleting : "+node.key);
		node = null;
	}

	void deleteTreeRef(Node nodeRef){
		deleteTree(nodeRef);
		nodeRef = null;
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
		DeleteTree tree = new DeleteTree();
		
		tree.deleteTreeRef(root);
        System.out.println("Tree deleted");
	}

}
