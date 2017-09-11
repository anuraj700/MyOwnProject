package com.geekforgeeks.tree;

import java.util.ArrayList;
import java.util.List;

import com.geekforgeeks.tree.SizeOfTree.Node;

public class FindLCAInBinaryTree {

	private List<Integer> path1 = new ArrayList<Integer>();
	private List<Integer> path2 = new ArrayList<Integer>();

	int findLCA(int n1, int n2, Node root) {
		path1.clear();
		path2.clear();
		return findLCAInternal(n1, n2, root);

	}

	int findLCAInternal(int n1, int n2, Node root) {
		if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) {
			System.out.println((path1.size() > 0) ? "n1 is present"
					: "n1 is missing");
			System.out.println((path2.size() > 0) ? "n2 is present"
					: "n2 is missing");
			return -1;
		}
		int i = 0;
		for (i = 0; i < path1.size() && i < path2.size(); i++) {
			if (!path1.get(i).equals(path2.get(i)))
				break;
		}
		return path1.get(i - 1);
	}

	boolean findPath(Node root, int n, List<Integer> path) {
		if (root == null)
			return false;

		path.add(root.key);

		if (root.key == n)
			return true;

		if (root.left != null && findPath(root.left, n, path))
			return true;

		if (root.right != null && findPath(root.right, n, path))
			return true;

		path.remove(path.size() - 1);

		return false;

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
		FindLCAInBinaryTree tree = new FindLCAInBinaryTree();
		System.out.println("LCA(4, 5): " + tree.findLCA(4, 5, root));
		System.out.println("LCA(4, 6): " + tree.findLCA(4, 6, root));
		System.out.println("LCA(3, 4): " + tree.findLCA(3, 4, root));
		System.out.println("LCA(2, 4): " + tree.findLCA(2, 4, root));
		System.out.println("using one traversal");
		System.out.println("LCA(4, 5): " + tree.findLCA(root, 4, 5).key);
		System.out.println("LCA(4, 6): " + tree.findLCA(root, 4, 6).key);
		System.out.println("LCA(3, 4): " + tree.findLCA(root, 3, 4).key);
		System.out.println("LCA(2, 4): " + tree.findLCA(root, 2, 4).key);
	}

	/*
	 * Method 2 (Using Single Traversal) The method 1 finds LCA in O(n) time,
	 * but requires three tree traversals plus extra spaces for path arrays. If
	 * we assume that the keys n1 and n2 are present in Binary Tree, we can find
	 * LCA using single traversal of Binary Tree and without extra storage for
	 * path arrays. The idea is to traverse the tree starting from root. If any
	 * of the given keys (n1 and n2) matches with root, then root is LCA
	 * (assuming that both keys are present). If root doesn’t match with any of
	 * the keys, we recur for left and right subtree. The node which has one key
	 * present in its left subtree and the other key present in right subtree is
	 * the LCA. If both keys lie in left subtree, then left subtree has LCA
	 * also, otherwise LCA lies in right subtree.
	 */

	Node findLCA(Node root, int n1, int n2) {
		if (root == null)
			return null;

		if (root.key == n1 || root.key == n2)
			return root;

		Node leftLCA = findLCA(root.left, n1, n2);
		Node rightLCA = findLCA(root.right, n1, n2);

		if (leftLCA != null && rightLCA != null)
			return root;
		

		return leftLCA != null ? leftLCA : rightLCA;

	}
}
