package com.nagarro.assignment2.linkedlist;

public class LinkedList {
	 public static Node head; // head of list 
	    
	    // Linked list Node. 
	    // This inner class is made static 
	    // so that main() can access it 
	    public static class Node { 
	    
	        int data; 
	        Node next; 
	    
	        // Constructor 
	        Node(int d) 
	        { 
	            data = d; 
	            next = null; 
	        } 
	    } 
	    
	    // Method to insert a new node 
	    public static LinkedList insert(LinkedList list, int data) 
	    { 
	        // Create a new node with given data 
	        Node new_node = new Node(data); 
	        new_node.next = null; 
	    
	        // If the Linked List is empty, 
	        // then make the new node as head 
	        if (list.head == null) { 
	            list.head = new_node; 
	        } 
	        else { 
	            // Else traverse till the last node 
	            // and insert the new_node there 
	            Node last = list.head; 
	            while (last.next != null) { 
	                last = last.next; 
	            } 
	    
	            // Insert the new_node at last node 
	            last.next = new_node; 
	        } 
	    
	        // Return the list by head 
	        return list; 
	    } 
	    
	  
	    
	 // function to create and return a Node
	    static Node GetNode(int data) {
	        return new Node(data);
	    }
	  
	    // function to insert a Node at required position
	    public static Node insertPos(Node headNode, int position, int data) {
	        Node head = headNode;
	        if (position < 1)
	            System.out.print("Invalid position");
	  
	        // if position is 1 then new node is
	        // set infornt of head node
	        // head node is changing.
	        if (position == 1) {
	            Node newNode = new Node(data);
	            newNode.next = headNode;
	            head = newNode;
	        } else {
	            while (position-- != 0) {
	                if (position == 1) {
	                    // adding Node at required position
	                    Node newNode = GetNode(data);
	  
	                    // Making the new Node to point to
	                    // the old Node at the same position
	                    newNode.next = headNode.next;
	  
	                    // Replacing current with new Node
	                    // to the old Node to point to the new Node
	                    headNode.next = newNode;
	                    break;
	                }
	                headNode = headNode.next;
	            }
	            if (position != 1)
	                System.out.print("Position out of range");
	        }
	        return head;
	    }
	    
	    // Method to delete a node in the LinkedList by POSITION
	    public static LinkedList
	    deleteAtPosition(LinkedList list, int index)
	    {
	        // Store head node
	        Node currNode = list.head, prev = null;
	  
	        //
	        // CASE 1:
	        // If index is 0, then head node itself is to be
	        // deleted
	  
	        if (index == 0 && currNode != null) {
	            list.head = currNode.next; // Changed head
	  
	            // Display the message
	            System.out.println(
	                index + " position element deleted");
	  
	            // Return the updated List
	            return list;
	        }
	  
	        //
	        // CASE 2:
	        // If the index is greater than 0 but less than the
	        // size of LinkedList
	        //
	        // The counter
	        int counter = 0;
	  
	        // Count for the index to be deleted,
	        // keep track of the previous node
	        // as it is needed to change currNode.next
	        while (currNode != null) {
	  
	            if (counter == index) {
	                // Since the currNode is the required
	                // position Unlink currNode from linked list
	                prev.next = currNode.next;
	  
	                // Display the message
	                System.out.println(
	                    index + " position element deleted");
	                break;
	            }
	            else {
	                // If current position is not the index
	                // continue to next node
	                prev = currNode;
	                currNode = currNode.next;
	                counter++;
	            }
	        }
	  
	        // If the position element was found, it should be
	        // at currNode Therefore the currNode shall not be
	        // null
	        //
	        // CASE 3: The index is greater than the size of the
	        // LinkedList
	        //
	        // In this case, the currNode should be null
	        if (currNode == null) {
	            // Display the message
	            System.out.println(
	                index + " position element not found");
	        }
	  
	        // return the List
	        return list;
	    }
	    
	    public static int countOfNodes(Node head)
	    {
	        int count = 0;
	        while (head != null) {
	            head = head.next;
	            count++;
	        }
	        return count;
	    }
	  
	    // Deletes middle node and returns
	    // head of the modified list
	   public static Node deleteMid(Node head)
	    {
	        // Base cases
	        if (head == null)
	            return null;
	        if (head.next == null) {
	            return null;
	        }
	        Node copyHead = head;
	  
	        // Find the count of nodes
	        int count = countOfNodes(head);
	  
	        // Find the middle node
	        int mid = count / 2;
	  
	        // Delete the middle node
	        while (mid-- > 1) {
	            head = head.next;
	        }
	  
	        // Delete the middle node
	        head.next = head.next.next;
	  
	        return copyHead;
	    }
	  // list to sort the element in ascending order
	    public static void sortList()
	    {
	 
	        // Node current will point to head
	        Node current = head, index = null;
	 
	        int temp;
	 
	        if (head == null) {
	            return;
	        }
	        else {
	            while (current != null) {
	                // Node index will point to node next to
	                // current
	                index = current.next;
	 
	                while (index != null) {
	                    // If current node's data is greater
	                    // than index's node data, swap the data
	                    // between them
	                    if (current.data > index.data) {
	                        temp = current.data;
	                        current.data = index.data;
	                        index.data = temp;
	                    }
	 
	                    index = index.next;
	                }
	                current = current.next;
	            }
	        }
	    }
	    
	    /* Function to reverse the linked list */
	    public static Node reverse(Node ll)
	    {
	        Node prev = null;
	        Node current = ll;
	        Node next = null;
	        while (current != null) {
	            next = current.next;
	            current.next = prev;
	            prev = current;
	            current = next;
	        }
	        ll = prev;
	        return ll;
	    }
	    public static boolean search(Node head, int x)
	    {
	        // Base case
	        if (head == null)
	            return false;
	 
	        // If key is present in current node,
	        // return true
	        if (head.data == x)
	            return true;
	 
	        // Recur for remaining list
	        return search(head.next, x);
	    }
	    // Method to print the LinkedList. 
	    public static void printList(LinkedList list) 
	    { 
	        Node currNode = list.head; 
	     
	        System.out.print("LinkedList: "); 
	     
	        // Traverse through the LinkedList 
	        while (currNode != null) { 
	            // Print the data at current node 
	            System.out.print(currNode.data + " "); 
	     
	            // Go to next node 
	            currNode = currNode.next; 
	        } 
	    }
		


		
}
