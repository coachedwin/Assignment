package com.nagarro.assignment2.main;

import java.util.Scanner;

import com.nagarro.assignment2.linkedlist.LinkedList;
import com.nagarro.assignment2.linkedlist.LinkedList.Node;

public class DataStructureImplementation {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char ch=(Character) null;
		System.out.println("Enter Which data structure you want to work on:");
		System.out.println("Press 1 for LinkedList \n Press 2 for Stack \n Press 3 for Queue\n Press 4 for PriorityQueue\n Press 5 for HashMap");
		int n=sc.nextInt();
		LinkedList ll = new LinkedList();
		switch(n){
			case 1:
				System.out.println("Which Operation you want to do");
				System.out.println("Press 1 for insert \n press 2 for insert at position \n "
						+ "press 3 for delete at position \n press 4 for count node \n press 5 for delete mid "
						+ "press 6 for sort list \n press 7 for reverse node \n press 8 for search \n press 9 for print");
				int inputChoice=sc.nextInt();	
				
				switch(inputChoice) {
				
				case 1:
					

					System.out.println("Enter the digit");
					int data=sc.nextInt();
					LinkedList.insert(ll,data);
					break;
				
			case 2:
				System.out.println("Enter the position");
				int pos=sc.nextInt();
				System.out.println("Enter the digit");
				 data=sc.nextInt();
				
				LinkedList.insertPos(null, pos,data);
				break;
			case 3:
				System.out.println("Enter the position");
				pos=sc.nextInt();
				LinkedList.deleteAtPosition(ll, pos);
				break;
				
			case 4:
				LinkedList.countOfNodes(null);
			case 5:
				LinkedList.deleteMid(null);
			case 6:
				LinkedList.sortList();
			case 7:
				LinkedList.reverse(ll.head);
			case 8:
				System.out.println("Enter element you want to search");
				data=sc.nextInt();
				LinkedList.search( ll.head, data);
			case 9:
				LinkedList.printList(ll);
				
				
				
		}
			case 2:
				System.out.println("Which Operation you want to do");
				
		}
		do {
			
		}while(ch=='Y'||ch=='y');

	}

}
