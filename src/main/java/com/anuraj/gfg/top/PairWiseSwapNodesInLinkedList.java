package com.anuraj.gfg.top;

public class PairWiseSwapNodesInLinkedList {
	
	static class Lnode{
		int data;
		Lnode next;
		public Lnode(int key){
			this.data=key;
			next=null;
		}
	}

	Lnode head;

	// at head
	void push(int data) {

		Lnode newNode = new Lnode(data);
		newNode.next = head;
		head = newNode;

	}

	void pairWiseSwapNodesIterative() {
		if (head == null)
			return;

		Lnode temp = head;
		
		while(temp !=null && temp.next !=null){
			int k = temp.data;
			temp.data = temp.next.data;
			temp.next.data=k;
			temp = temp.next.next;
		}
		
	}

	void pairWiseSwapNodesRecursive(Lnode head){
		
		if(head != null && head.next !=null){
			swapData(head, head.next);	
			pairWiseSwapNodesRecursive(head.next.next);
		}
		
	}
	
	void swapData(Lnode n1,Lnode n2){
		int temp = n1.data;
		n1.data =n2.data;
		n2.data = temp;
	}
	public static void main(String[] args) {
		PairWiseSwapNodesInLinkedList llist = new PairWiseSwapNodesInLinkedList();
		llist.push(11);
		llist.push(31);
		llist.push(21);
		llist.push(22);
		llist.push(10);

		System.out.println("\n current list is");
		llist.printList();
		llist.pairWiseSwapNodesIterative();
		System.out.println("\n after swapping pair wise iterative");
		llist.printList();

		llist.pairWiseSwapNodesRecursive(llist.head);
		System.out.println("\n after swapping pair wise recursive");
		llist.printList();
	}

	void printList() {

		Lnode last = head;
		while (last != null) {
			System.out.print(last.data + " ");
			last = last.next;
		}
	}

}
