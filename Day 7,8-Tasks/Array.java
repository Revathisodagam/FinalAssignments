package datastructureTasks;

public class Array {
	private int[] array;
    private int size;
    private int capacity;
    
    public Array() {
        this.capacity = 10; 
        this.array = new int[capacity];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
        }
        return array[index];
    }

    public void set(int index, int element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
        }
        array[index] = element;
    }

    public void add(int element) {
        ensureCapacity(); 
        array[size] = element;
        size++;
    }

    public void insert(int index, int element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
        }
        ensureCapacity(); 
        
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }

        array[index] = element;
        size++;
    }

    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
        }

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    
    private void ensureCapacity() {
        if (size == capacity) {
            capacity *= 2; 
            array = Array.copyOf(array, capacity);
        }
    }

    private static int[] copyOf(int[] array2, int capacity2) {
		// TODO Auto-generated method stub
		return null;
	}

	public void print() {
        if (size == 0) {
            System.out.println("Dynamic Array is empty.");
            return;
        }
        System.out.print("Dynamic Array elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
	
     public static void main(String[] args) {
    	
         Array d = new Array();

         d.add(11);
         d.add(22);
         d.add(33);
         d.print(); 

         d.insert(1, 15);
         d.print(); 

         d.delete(2);
         d.print(); 

         d.set(0, 2);
         d.print(); 

         int element = d.get(2);
         System.out.println("Element at index 2: " + element); // Output: Element at index 2: 30
     }
 }
	
	
	
