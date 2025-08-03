package basics.LinkedList;


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
            return;
        }
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
    }

}
