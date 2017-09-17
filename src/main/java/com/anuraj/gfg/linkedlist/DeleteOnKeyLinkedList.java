package com.anuraj.gfg.linkedlist;

public class DeleteOnKeyLinkedList {
	
	Lnode head;
	
	//at head
	void push(int data){
		
		Lnode newNode= new Lnode(data);
		newNode.next = head;
		head = newNode;
		
	}
	void deleteNode(int key){
		
		Lnode temp = head; 
		Lnode prev = null;
		
		if(temp != null && temp.data == key){
			head=temp.next;
			System.out.println("\nkey is at head");
			return;
		}
		
		while(temp!=null && temp.data != key){
			prev=temp;
			temp= temp.next;
		}
		
		if(temp==null){
			System.out.println("\nkey is not present");
			return;
		}
		
		prev.next = temp.next;
	}

	public static void main(String[] args) {
		DeleteOnKeyLinkedList llist = new DeleteOnKeyLinkedList();
 
		llist.push(7);
        llist.push(1);
        llist.push(3);
        llist.push(2);
 
        System.out.println("\nCreated Linked list is: ");
        llist.printList();
        
        llist.deleteNode(1); // Delete node at position 4
        
        System.out.println("\nLinked List after Deletion at position 4:");
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
