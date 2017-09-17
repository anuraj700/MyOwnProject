package com.anuraj.gfg.linkedlist;

public class InsertInLinkedList {
	
	Lnode head;
	
	//at head
	void push(int data){
		
		Lnode newNode= new Lnode(data);
		newNode.next = head;
		head = newNode;
		
	}
	// after some node
	void insertAfter(Lnode preNode, int data){
		
		if(preNode== null){
			System.out.println("Previous node cant be null");
			return;
		}
		Lnode newNode= new Lnode(data);
		newNode.next = preNode.next;
		preNode.next = newNode;
		
	}
	// at last
	void append(int data){
		Lnode newNode= new Lnode(data);
		if(head==null){
			head = newNode;
			return;
		}
		newNode.next =null;
		Lnode last = head;
		while(last.next!= null){
			last = last.next;
		}
		
		last.next = newNode;
		return;
		
	}

	public static void main(String[] args) {
		InsertInLinkedList llist = new InsertInLinkedList();
 
        // Insert 6.  So linked list becomes 6->NUllist
        llist.append(6);
 
        // Insert 7 at the beginning. So linked list becomes
        // 7->6->NUllist
        llist.push(7);
 
        // Insert 1 at the beginning. So linked list becomes
        // 1->7->6->NUllist
        llist.push(1);
 
        // Insert 4 at the end. So linked list becomes
        // 1->7->6->4->NUllist
        llist.append(4);
 
        // Insert 8, after 7. So linked list becomes
        // 1->7->8->6->4->NUllist
        llist.insertAfter(llist.head.next, 8);
 
        System.out.println("\nCreated Linked list is: ");
        llist.printList();
	}
	
	void printList(){
		
		Lnode last =  head;
		while(last !=null){
			System.out.print(last.data + " ");
			last = last.next;
		}
	}

}
