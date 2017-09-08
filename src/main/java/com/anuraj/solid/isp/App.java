
package com.anuraj.solid.isp;

public class App {

	public static void main(String[] args) {

		Tree tree = new BinarySearchTree();
		tree.traverse();
		BinarySearchTree tree1 = new BinarySearchTree();
		tree1.findMax();
		tree1.traverse();
		IBalancedTree iTree = new BalancedTree();
		iTree.leftRotation();
		BalancedTree iTree1 = new BalancedTree();
		iTree1.leftRotation();
		iTree1.traverse();
		Tree iTree2 = new BalancedTree();
		iTree2.traverse();
	}
}
