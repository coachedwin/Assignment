package com.nagarro.assignment2.priorityQueue;

public class PriorityQueue {
	public class Node{
		public Node head =null;
		public int data;
		public Node next;
		public int priority;
		public Node(int data,int priority) {
			
			this.data = data;
			this.priority = priority;
		}
		public Node getHead() {
			return head;
		}
		public void setHead(Node head) {
			this.head = head;
		}
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		public int getPriority() {
			return priority;
		}
		public void setPriority(int priority) {
			this.priority = priority;
		}
		
		
	}
	
	private Node front;
	private Node rear;
	private int size;
	
	public Node getRear() {
		return this.rear;
	}
	
	public PriorityQueue() {
		this.front = null;
		this.rear = null;
		this.size = 0;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public Node getFront() {
		return this.front;
	}
	
	public void getPeek() {
		System.out.println("The peek element of priority queue is"+this.front.getData());
	}
	
	public void enQueue(int data, int priority) {
		
		Node node = new Node(data, priority);
		
		// if queue is empty
		if(this.front == null) {
			this.front = node;
			this.rear = node;
		}
		else if(this.front.getPriority() < node.getPriority()) { 	// if only head node is present 
			node.setNext(this.front);
			this.front = node;
		}
		else {	// traverse the last node
			Node temp = this.front;
			while(temp.getNext()!=null && temp.getNext().getPriority() > node.getPriority()) {
				temp = temp.getNext();
			}
			
			node.setNext(temp.getNext());
			temp.setNext(node);
			
		}
		
		if(node.getNext() == null) {
			this.rear = node;
		}
		
		this.size++;
		
	}
	
	public void deQueue() {
		if(this.front == null) {
			System.out.println("!!! Priority queue is empty !!!");
			return;
		}
		
		Node temp = this.front;
		this.front = this.front.getNext();
		temp.setNext(null);
		this.size--;
	}
	
	public void displayPriorityQueue() {
		if(this.front==null) {
			System.out.println("!!! Priority queue is empty !!!");
			return;
		}
		Node temp = this.front;
		while(temp!=null) {
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
	}
	
	public void isContains(int key) {
		if(this.front==null) {
			System.out.println("!!! Priority queue is empty !!!");
			return;
		}
		Node temp = this.front;
		while(temp!=null) {
			if(temp.getData() == key) {
				System.out.println(key+" present in the priority queue");
				return;
			}
			temp = temp.getNext();
		}
		System.out.println(key+" not present in the priority queue");
	}
	
	public void reverseQueue() {
		
		if(this.front == null) {
			System.out.println("!!! Priority queue is empty !!!");
			return;
		}
		
		this.rear = this.front;
		Node curr = this.front;
		Node fast = null;
		Node prev = null;
		
		while(curr!=null) {
			fast = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = fast;
			
		}
		
		this.front = prev;
	}
	
	public void iterator(int index) {
		if(this.front==null) {
			System.out.println("!!! Priority queue is empty !!!");
			return;
		}
		if(index>this.size) {
			System.out.println("Index is out of bound");
			return;
		}

		Node temp = this.front;
		for(int i=0;i<index;i++) {
			temp = temp.getNext();
		}
		while(temp!=null) {
			System.out.println(temp.getData()+" ");
			temp = temp.getNext();
		}
		
	}
	
	

}
