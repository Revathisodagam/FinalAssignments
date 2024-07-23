package datastructureTasks;

 class LinkedList {
    private Node head;
    
    class Node {
        int data;
        Node next;
     Node(int d) {
            this.data = d;
            this.next = null;
        }
    }
    public LinkedList() {
        this.head = null;
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    public void remove(int data) {
        if (head == null) {
            return;
        }
        if (head.data == data) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public boolean contains(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     LinkedList list= new LinkedList();
     
     list.add(1);
     list.add(3);
     list.add(5);
     list.add(7);
     list.add(11);
     
     System.out.print("Linked List: ");
     list.display();
     
     list.remove(5);
   
     list.display();
     
     int searchElement = 11;
     System.out.println("Does the list contain " + searchElement + "? " + list.contains(searchElement));
	}


	}

