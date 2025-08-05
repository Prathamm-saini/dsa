package basics.LinkedList;
// simply the same thing (singly linked list) with a previous pointer
// Doubly linked list = singly linked list + prev pointer in every node
// for tail, next is null (similar in LL) , here prev of head is null too
public class DLL {

    private Node head;
    private Node tail;
    private int size;

    private class Node{
        private int data;
        private Node next;
        private Node prev;
        public Node(int data){
            this.data = data;
        }
        public Node(int data, Node next, Node prev){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
    public DLL(){
        head = null;
        tail = null;
        size = 0;
    }
    public void insertAtHead(int data){
        Node newNode = new Node(data);
        if(head == null || tail == null){
            head = tail = newNode;
        }
        else{
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }
    public void insertAtTail(int data){
        Node newNode = new Node(data);
        if(tail == null || head == null){
            head = tail = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }
    public void insertAtIndex(int index, int data){
        if (index < 0 || index > size) {
            System.out.println("Invalid index");
            return;
        }
        if (index == 0) {
            insertAtHead(data);
            return;
        }

        if (index == size) {
            insertAtTail(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        newNode.prev = temp;

        temp.next.prev = newNode;
        temp.next = newNode;
        size++;
    }
    public void deleteHead(){
        if(head == null ||  tail == null){
            return;
        }
        if(head == tail){
            head = tail = null;
            return;
        }
        head = head.next;
        head.prev = null;
        size--;
    }
    public void deleteTail(){
        if(tail == null ||  head == null){
            return;
        }
        if(tail == head){
            head = tail = null;
            return;
        }
        tail = tail.prev;
        tail.next = null;
        size--;
    }
    public void deleteAtIndex(int index){
        if (index < 0 || index >= size) {
            System.out.println("Invalid index");
            return;
        }
        if (index == 0) {
            deleteHead();
            return;
        }
        if (index == size-1) {
            deleteTail();
            return;
        }
        Node temp = head;
        for (int i = 1; i <index; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        temp.next.prev = temp;
        size--;
    }
    public void display(){
        Node current = head;
        System.out.print("null <- "+current.data + " -> ");
        current = current.next;
        while(current != null){
            System.out.print(current.data+" -> ");
            current = current.next;
        }
        System.out.print("null");
        System.out.println();
    }
    public boolean search(int data){
        int index = 0;
        Node current = head;
        while(current != null){
            if(current.data == data){
                System.out.println(index);
                return true;
            }
            current = current.next;
            index++;
        }
        return false;
    }
    public void displayReverseDLL(){
        if(head == null || tail == null){
            return;
        }
        Node current = tail;
        while(current !=null){
            System.out.print(current.data+" -> ");
            current = current.prev;
        }
        System.out.println("null");
    }
    public void reverseDLL(){
        if(head == null || tail == null){
            return;
        }
        if (head == tail) return;
        Node temp = null;
        Node current = head;
        while(current != null){
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;

            current = current.prev;
        }
        Node extra = head;
        head = tail;
        tail = extra;
    }
}
