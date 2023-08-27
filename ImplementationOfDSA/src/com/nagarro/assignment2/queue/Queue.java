package com.nagarro.assignment2.queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Queue {
	 static int front;
	static int rear;
	int size;
	    int capacity;
	    static int array[];
	  
	    public Queue(int capacity)
	    {
	        this.capacity = capacity;
	        front = this.size = 0;
	        rear = capacity - 1;
	        array = new int[this.capacity];
	    }
	  
	    // Queue is full when size becomes
	    // equal to the capacity
	    boolean isFull(Queue queue)
	    {
	        return (queue.size == queue.capacity);
	    }
	  
	    // Queue is empty when size is 0
	    boolean isEmpty(Queue queue)
	    {
	        return (queue.size == 0);
	    }
	  
	    // Method to add an item to the queue.
	    // It changes rear and size
	    void enqueue(int item)
	    {
	        if (isFull(this))
	            return;
	        Queue.rear = (Queue.rear + 1)
	                    % this.capacity;
	        Queue.array[Queue.rear] = item;
	        this.size = this.size + 1;
	        System.out.println(item
	                           + " enqueued to queue");
	    }
	  
	    // Method to remove an item from queue.
	    // It changes front and size
	    int dequeue()
	    {
	        if (isEmpty(this))
	            return Integer.MIN_VALUE;
	  
	        int item = this.array[this.front];
	        this.front = (this.front + 1)
	                     % this.capacity;
	        this.size = this.size - 1;
	        return item;
	    }
	  
	    // Method to get front of queue
	    int front()
	    {
	        if (isEmpty(this))
	            return Integer.MIN_VALUE;
	  
	        return Queue.array[Queue.front];
	    }
	  
	    // Method to get rear of queue
	    int rear()
	    {
	        if (isEmpty(this))
	            return Integer.MIN_VALUE;
	  
	        return Queue.array[Queue.rear];
	    }
	    
	    //element available or not
	    static boolean queueContains(int n) 
	    { 
	        int i; 
	        if (front == rear) { 
	            System.out.printf("Queue is Empty\n"); 
	            return false; 
	        } 
	   
	        // traverse front to rear and print elements 
	        for (i = front; i < rear; i++) { 
	            System.out.println(array[i]); 
	            if(array[i]==n) {
	            	return true;
	            }
	        } 
	       return false;
	    } 
	    
	    //sort the queue elements
	    Queue sortQueue(Queue q)
	    {
	        ArrayList<Integer> temp = new ArrayList<>();
	        while(q.isEmpty(q) == false)
	        {
	               temp.add(q.front());
	               q.rear();
	        }
	        Collections.sort(temp);
	        for(int i=0;i<temp.size();i++)
	        {
	            ((List<Integer>) q).add(temp.get(i));
	        }
	        return q;
	    }
	    
	 // Recurrsive function to reverse the queue
	    static Queue reverseQueue(Queue q)
	    {
	        // Base case
	        if (q.isEmpty(q))
	            return q;
	     
	        // Dequeue current item (from front) 
	        int data = q.front();
	        q.dequeue();
	     
	        // Reverse remaining queue 
	        q = reverseQueue(q);
	     
	        // Enqueue current item (to rear) 
	        ((List<Integer>) q).add(data);
	             
	        return q;
	    }
	    // print queue elements 
	    static void queueDisplay() 
	    { 
	        int i; 
	        if (front == rear) { 
	            System.out.printf("Queue is Empty\n"); 
	            return; 
	        } 
	   
	        // traverse front to rear and print elements 
	        for (i = front; i < rear; i++) { 
	            System.out.println(array[i]); 
	        } 
	        return; 
	    } 
}
