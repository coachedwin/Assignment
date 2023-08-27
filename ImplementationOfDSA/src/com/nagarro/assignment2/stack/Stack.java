package com.nagarro.assignment2.stack;

public class Stack {
	static final int MAX = 1000;
    int top;
    int a[] = new int[MAX]; // Maximum size of Stack
  
    boolean isEmpty()
    {
        return (top < 0);
    }
    Stack()
    {
        top = -1;
    }
  
    boolean push(int x)
    {
        if (top >= (MAX - 1)) {
            System.out.println("Stack Overflow");
            return false;
        }
        else {
            a[++top] = x;
            System.out.println(x + " pushed into stack");
            return true;
        }
    }
  
    int pop()
    {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        }
        else {
            int x = a[top--];
            return x;
        }
    }
  
    int peek()
    {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        }
        else {
            int x = a[top];
            return x;
        }
    }
    int count() {
    	int count =0;
    	for(int i = top;i>-1;i--){
    		 if(a[i] != 0){count ++;
    			 
    		 }
    			
    		}
    	return count;    
    }
     
    // This function return the sorted stack
    public static Stack sortstack(Stack input)
    {
        Stack tmpStack = new Stack();
        while(!input.isEmpty())
        {
            // pop out the first element
            int tmp = input.pop();
          
            // while temporary stack is not empty and
            // top of stack is greater than temp
            while(!tmpStack.isEmpty() && tmpStack.peek() 
                                                 > tmp)
            {
                // pop from temporary stack and 
                // push it to the input stack
            input.push(tmpStack.pop());
            }
              
            // push temp in temporary of stack
            tmpStack.push(tmp);
        }
        return tmpStack;
    }
    
    public static String ReverseString(String str)
    {
        char[] reverseString = new char[str.length()];
        // Declare a stack of type Character
        Stack stack = new Stack();
  
        // Traverse the String and push the character one by
        // one into the Stack
        for (int i = 0; i < str.length(); i++) {
            // push the character into the Stack
            stack.push(str.charAt(i));
        }
  
        // Now Pop the Characters from the stack until it
        // becomes empty
  
        int i = 0;
        while (!stack.isEmpty()) { // popping element until
                                   // stack become empty
            // get the character from the top of the stack
            reverseString[i++] = (char) stack.pop();
        }
        // return string object
        return new String(reverseString);
    }
    void print(){
    for(int i = top;i>-1;i--){
      System.out.print(" "+ a[i]);
    }
  }
}

