package basics.LinkedList;
/// You're not copying the entire node — you're copying the reference to the head node. So:
///
/// temp and head both point to the same node in memory.
///
/// Modifying temp.next is like modifying head.next if temp == head.
///
///  Analogy
/// Imagine your linked list is a chain of people holding hands. Each person (Node) knows who’s next (next). When you assign Node temp = head;, you're just pointing at the same person.
///
/// If temp lets go of the next person and grabs someone else, the actual structure of the chain changes — because temp is the person.

public class LL {

    // whenever you create a new LL (linked list) these will be initialized with size =0
    // head and tail are just reference variables pointing to the first and last node
    private Node head;
    private Node tail;
    private int size;

    public LL(){
        this.size = 0;
    }
    // box structure Node with fields data,pointer to next
    private class Node{
        private int data;
        private Node next;
        public Node(int data){
            this.data = data;
        }
        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }
    public void insertAtHead(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        if(tail == null){
            tail = newNode;
        }
        size++;
    }
    public void insertAtTail(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        tail.next = newNode;
        tail = newNode;
        size++;
    }
    public void display(){
        if(head == null){
            return;
        }
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public void displayReverse(){
        if(head == null){
            return;
        }
        int index = size-1;
        Node current = head;
        for(int i=index;i>=0;i--){
            System.out.print(current.data+" -> ");
            current = current.next;
        }
        System.out.println("null");

    }
    public void insertAtAnyIndex(int data,int index){
        if(index < 0 || index > size){
            System.out.println("Invalid position");
            return;
        }
        if(index == 0){
            insertAtHead(data);
            return;
        }
        if(index == size){
            insertAtTail(data);
            return;
        }
        Node temp = head;
        for (int i = 1; i <index; i++) {
            temp = temp.next;
        }
        Node newNode = new Node(data,temp.next); // marks next of current temp as its own temp
        temp.next = newNode;
        size++;
    }

    public void deleteAtHead(){
        if(head == null){
            tail = null;
            return;
        }
        if(head == tail){
            head = tail = null;
            return;
        }
        head = head.next;
        size--;
    }
    public void deleteAtTail(){
        if(tail == null ||  head == null){
            return;
        }
        if (head == tail) {
            // Only one node in the list
            head = null;
            tail = null;
            return;
        }
        Node temp = head;
        while(temp.next != tail){
            temp = temp.next;
        }
        tail = temp;
        temp.next = null;
        size--;
    }
    public void deleteAtIndex(int index){
        if(index < 0 || index > size){
            System.out.println("Invalid position");
            return;
        }
        else if(head == null || tail == null){
            return;
        }
        else if(index == 0){
            deleteAtHead();
            return;
        }
        else if(index == size){
            deleteAtTail();
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
        ///this temp is just object and references so making a change in them will cause the change in original(Basic OOP)
    }
    public boolean search(int data){
        Node temp = head;
        int index = 0;
        while(temp != null){
            if(temp.data == data){
                System.out.print(index +"  ");
                return true;
            }
            temp = temp.next;
            index++;
        }
        return false;
    }
    public int Size(){
        return size;
    }
}
