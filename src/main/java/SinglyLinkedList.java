public class SinglyLinkedList<T> {
    private int size;
    private Node<T> head;
    private Node<T> tail;

    // Inner Node class.
    public class Node<T> {
        // Properties of the Node class.
        // The two properties should be:
        // 1. data (the data stored in the node).
        // 2. next (a reference (also known as a pointer) to the next node.
        public T Data;
        public Node<T> Next;
        // Constructor of the Node class.
        // The constructor should set the data property of the Node to be the value passed as a parameter.
        // The constructor should set the next property of the Node to be null.
        public Node(T data) {
            Data = data;
            Next = null;
        }

    }

    // Properties of the Singly Linked List class.
    // The three properties should be:
    // 1. size (records the number of nodes in our Singly Linked List)
    // 2. head (a reference to the first (also known as the head) node in our Singly Linked List).
    // 3. tail (a reference to the last (also known as the tail) node in our Singly Linked List.


    // Constructor.
    // Creates a Singly Linked List with a head node.
    public SinglyLinkedList(T value) {
        head = new Node<>(value);
        tail = head;
        size = 1;
    }

    // Methods



    // size
    // returns the size of the Singly Linked List.
    public int size() {
 return size;

    }

    // isEmpty
    // returns whether the Singly Linked List is empty.
    public boolean isEmpty() {

        return size==0;

    }

    // peekFirst
    // returns the data stored in the head node.
    // throws a run time exception if the Singly Linked List is empty.
    public T peekFirst() {
        if (isEmpty()) {
            throw new RuntimeException("The Singly Linked List is empty.");
        }
        return head.Data;
    }

    // peekLast
    // returns the data stored in the tail node.
    // throws a run time exception if the Singly Linked List is empty.
    public T peekLast() {
        if (isEmpty()) {
            throw new RuntimeException("The Singly Linked List is empty.");
        }
    return tail.Data;
    }

    // addFirst
    // Adds a node to the front of the Singly Linked List.
    // If the Singly Linked List is empty,
    public void addFirst(T value) {
       Node<T> node = new Node<>(value);
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            node.Next = head;
            head = node;
        }
        size++;
    }

    // addLast
    // Adds a node to the back of the Singly Linked List.
    public void addLast(T value) {
        Node<T> node = new Node<>(value);
        if (isEmpty()) {
            head = node;
            tail = node;
    }
        else {
            tail.Next=node;
            tail=node;
        }
        size++;

    }

    // insertAt
    // Inserts a node at a specific index.
    // If the index is equal to 0, then we can invoke the addFirst method.
    // If the index is equal to size, then we can invoke the addLast method.
    // throws an illegal argument exception if the index is invalid.
    public void insert(T value, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Invalid index.");
        }

        if (index == 0) {
            addFirst(value);
            return;
        }

        if (index == size) {
            addLast(value);
            return;
        }

        Node<T> currentNode = head;
        for (int i = 1; i < index; i++) {
            currentNode = currentNode.Next;
        }

        Node<T> newNode = new Node<>(value);
        newNode.Next = currentNode.Next;
        currentNode.Next = newNode;
        size++;
    }

    // removeFirst
    // Removes the first (also known as the head node) from the Singly Linked List.
    // Throws a run time exception if the Singly Linked List is empty.
    // Returns the data stored in the head node.
    // If the size of the Singly Linked List becomes 0, need to set the tail to null.
    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Invalid index.");
        }

        T data = head.Data;
        head = head.Next;
        size--;

        if (size == 0) {
            tail = null;
        }

        return data;

    }

    // removeLast
    // Removes the last (also known as the tail node) from the Singly Linked List.
    // Throws a run time exception if the Singly Linked List is empty.
    // Returns the data stored in the tail node.
    // If the size of the Singly Linked List becomes 0, need to set the tail to null.
    public T removeLast() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Invalid index.");
        }
        T data = tail.Data;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            Node<T> currentNode = head;
            while (currentNode.Next != tail) {
                currentNode = currentNode.Next;
            }
            tail = currentNode;
            tail.Next = null;
        }
        size--;
        return data;

    }

    // removeAt
    // Removes a node at a specific index.
    // Returns the data stored in the removed node.
    // If the index is equal to 0, then we can invoke the removeFirst method.
    // If the index is equal to size-1, then we can invoke the removeLast method.
    // throws an illegal argument exception if the index is invalid.

    public T removeAt(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Invalid index.");
        }
        if(index==0){
            removeFirst();
        }
        if (index==(size=1)){
            removeLast();
        }

        Node<T> currentNode = head;
        for (int i = 1; i < index; i++) {
            currentNode = currentNode.Next;
        }

        T data = currentNode.Next.Data;
        currentNode.Next = currentNode.Next.Next;
        size--;

        if (size == 0) {
            tail = null;
        }

        return data;


    }

    // contains
    // Determines whether the Singly Linked List contains a node that holds data equivalent to the value passed.
    // Returns a boolean.
    public boolean contains(T value) {
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.Data.equals(value)) {
                return true;
            }
            currentNode = currentNode.Next;
        }
        return false;

    }

    // valueAt
    // Returns the data held in the node at a specified index.
    // Throws an illegal argument exception if the index is invalid.
    public T valueAt(int index) {

        Node<T> currentNode = head;
        for(int i=1; i<index;i++){
            currentNode = currentNode.Next;
        }

        return currentNode.Data;
    }

    // reverse
    // Reverses the Singly Linked List.
    public void reverse() {
        if (isEmpty() || size == 1) {
            return;
        }

        Node<T> currentNode = head;
        Node<T> previousNode = null;
        Node<T> nextNode = null;

        while (currentNode != null) {
            nextNode = currentNode.Next;
            currentNode.Next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }

        tail = head;
        head = previousNode;
    }

    // toString
    // Returns a String representation of the Singly Linked List.
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> currentNode = head;
        while (currentNode != null) {
            sb.append(currentNode.Data);
            if (currentNode.Next != null) {
                sb.append(", ");
            }
            currentNode = currentNode.Next;
        }
        sb.append("]");
        return sb.toString();

    }
}
