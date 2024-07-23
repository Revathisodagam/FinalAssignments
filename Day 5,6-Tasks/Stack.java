package datastructureTasks;

import java.util.EmptyStackException;

public class Stack {
	  private int maxSize;        
	    private int[] stackArray;   
	    private int top;           

	    
	    public Stack(int size) {
	        maxSize = size;
	        stackArray = new int[maxSize];
	        top = -1;
	    }

	   
	    public void push(int element) {
	        if (isFull()) {
	            System.out.println("Stack is full. Cannot push element " + element);
	            return;
	        }
	        stackArray[++top] = element;
	    }
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stackArray[top--];
    }
    public int popAtPosition(int position) {
        if (position < 0 || position >= stackArray.length) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        return stackArray.length;
    }
    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException(); 
        }
        return stackArray[top];
    }
	private boolean isEmpty() {
		// TODO Auto-generated method stub
		 return(top == -1);
    }
	private boolean isFull() {
		return (top == maxSize -1);
	}
	  public int size() {
	        return top+1;
	    }
	  public void printStack() {
	        if (isEmpty()) {
	            System.out.println("Stack is empty");
	            return;
	        }
	        System.out.println("Elements in the stack:");
	        for (int i = top; i >= 0; i--) {
	            System.out.println(stackArray[i]);
	        }
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack stack = new Stack(10);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        
        
        stack.printStack();
        System.out.println("=========================");
        System.out.println("Size of stack: " + stack.size());
        
        System.out.println("=========================");
        System.out.println("Is stack empty? " + stack.isEmpty());
        
        System.out.println("=========================");
        System.out.println("Top element: " + stack.peek());
        
        System.out.println("=========================");
        System.out.println("Popped element: " + stack.pop());
        
        System.out.println("=========================");
        System.out.println("Top element after pop: " + stack.peek());
        
        System.out.println("=========================");
        System.out.println("Size of stack after operations: " + stack.size());
        
        System.out.println("Popped element: " + stack.pop());
        
        System.out.println("=========================");
        stack.printStack();
 
	}

}