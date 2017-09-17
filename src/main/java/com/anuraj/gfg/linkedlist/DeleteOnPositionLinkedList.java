package com.anuraj.gfg.linkedlist;

public class DeleteOnPositionLinkedList {
	
	Lnode head;
	
	//at head
	void push(int data){
		
		Lnode newNode= new Lnode(data);
		newNode.next = head;
		head = newNode;
		
	}
	void deleteNodeMy(int key){
		
		Lnode temp = head; 
		Lnode prev = null;
		int currentPos =0;
		if(temp != null && currentPos == key){
			head=temp.next;
			System.out.println("\nkey is at head");
			return;
		}
		
		while(temp!=null && currentPos != key){
			prev=temp;
			temp= temp.next;
			currentPos++;
		}
		
		if(temp==null){
			System.out.println("\nkey is not present");
			return;
		}
		
		prev.next = temp.next;
	}
	
	  void deleteNode(int position)
	    {
	        if (head == null)
	            return;
	 
	        Lnode temp = head;
	 
	        if (position == 0)
	        {
	            head = temp.next;   
	            return;
	        }
	 
	        // Find previous node of the node to be deleted
	        for (int i=0; temp!=null && i<position-1; i++)
	            temp = temp.next;
	 
	        // If position is more than number of ndoes
	        if (temp == null || temp.next == null)
	            return;
	 
	        // Node temp->next is the node to be deleted
	        // Store pointer to the next of node to be deleted
	        Lnode next = temp.next.next;
	 
	        temp.next = next;  // Unlink the deleted node from list
	    }

	public static void main(String[] args) {
		DeleteOnPositionLinkedList llist = new DeleteOnPositionLinkedList();
 
		llist.push(7);
        llist.push(1);
        llist.push(3);
        llist.push(2);
 
        System.out.println("\nCreated Linked list is: ");
        llist.printList();
        
        llist.deleteNode(1); 
        
        System.out.println("\nLinked List after Deletion :");
        llist.printList();
        
        llist.deleteNodeMy(1); 
        
        System.out.println("\nLinked List after Deletion :");
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
