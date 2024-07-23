package datastructureTasks;

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}
class Queue<T> {
    private Node<T> front; 
    private Node<T> rear;  

    public Queue() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty. Cannot dequeue.");
        }
        T data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty. Cannot peek.");
        }
        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }
    
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        Node<T> current = front;
        System.out.print("Elements in Queue: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        
        queue.display();
        
        System.out.println("Front of the queue: " + queue.peek()); 

        System.out.println("Dequeue: " + queue.dequeue()); 
        queue.display();
        System.out.println("Dequeue: " + queue.dequeue()); 

        System.out.println("Front of the queue after dequeue: " + queue.peek()); 

        System.out.println("Is the queue empty? " + queue.isEmpty());

        queue.dequeue();
    }

        
    }

