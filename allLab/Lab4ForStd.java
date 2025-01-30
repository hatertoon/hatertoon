package test;
import java.util.Scanner;
import java.util.Scanner;

public class Lab4ForStd {
    public static int maxsize = 5;
    public static int[] number = new int[maxsize];
    public static int front = 0;
    public static int rear = -1;
    public static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < maxsize; i++) {
            System.out.print("Enqueue Data " + (i + 1) + ": ");
            int num = sc.nextInt();
            enqueue(num);  
        }
        enqueue(1000); 

        for (int i = 0; i < maxsize; i++) {
            dequeue();
        }
        dequeue(); // This will print "Queue is empty."
    }

    public static void enqueue(int num) {
        if (count < maxsize) {
            rear = (rear + 1) % maxsize;
            number[rear] = num;
            count++;
        } else {
            System.out.println("Queue is full.");
        }
    }

    // Dequeue operation
    public static void dequeue() {
        if (count > 0) {
            System.out.println("Dequeue Data " + count + ": " + number[front]);
            front = (front + 1) % maxsize;
            count--;
        } else {
            System.out.println("Queue is empty.");
        }
    }
}

