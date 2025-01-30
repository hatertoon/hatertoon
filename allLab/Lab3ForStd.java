package test;

import java.util.Scanner;

class StackA{
	public int maxSize = 5;
	public String[] stackArray;
	public int top;
	
	public StackA(int s) {
		maxSize = s;
		stackArray = new String[maxSize];
		top = -1;
	}
	
	public void push(String j) {
		if(!isFull()) {
			stackArray[++top] = j;
		}else {
			System.out.println("Stack is full. Cannot push " + j);
		}
	}
	public String pop() {
		if(!isEmpty()) {
			return stackArray[top--];
		}else {
			return "Stack is empty";
		}
	}
	public boolean isEmpty() {
        return (top == -1);
    }

    // Check if stack is full
    public boolean isFull() {
        return (top == maxSize - 1);
    }
}

public class Lab3ForStd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StackA stack = new StackA(5); // create stack with max size of 5

        // Accept 5 characters from user and push them onto the stack
        for (int i = 0; i < 5; i++) {
            System.out.print("Push Data " + (i + 1) + ": ");
            String input = sc.nextLine();
            stack.push(input);
        }

        System.out.println("--------------------------");

        // Pop and display the characters in reverse order
        if (!stack.isEmpty()) {
            for (int i = 0; i < 5; i++) {
                System.out.println("Pop Data " + (i + 1) + ": " + stack.pop());
            }
        }
        
        sc.close();
    }
}