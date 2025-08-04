package basics.LinkedList;
/// Circular Linked List
/// first node is connected to the last and vice versa
/// no prev pointer
/// circular ll -> singly ll + last connected to first

public class CLL {
    private Node head;
    private Node tail;
    private int size;

    public CLL(){
        head = null;
        tail = null;
        size = 0;
    }

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
        if(head == null){
            head = tail = newNode;
            tail.next = newNode;
            return;
        }
        newNode.next = head;
        tail.next = newNode;
        head = newNode;
        size++;
    }
    public void insertAtTail(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            tail.next = head;
            return;
        }else {
            newNode.next = head;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    // same as in singly linked list
    public void insertAtIndex(int data, int index){
        if(index < 0 || index >= size){
            System.out.println("Invalid index");
            return;
        }
        if(index == 0){
            insertAtHead(data);
            return;
        }
        if(index == size-1){
            insertAtTail(data);
            return;
        }
        Node current = head;
        for(int i = 1; i < index; i++){
            current = current.next;
        }
        Node newNode = new Node(data);
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }
    public void deleteAtHead(){
        if(head == null){
            return;
        }
        if(head.next == null){
            head = tail = null;
            return;
        }
        head = head.next;
        tail.next = head;
        size--;
    }
    public void deleteAtTail(){
        if(tail == null){
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
            return;
        }
        Node current = head;
        while(current.next != tail){
            current = current.next;
        }
        tail = current;
        tail.next = head;
        size--;
    }
    public void deleteAtIndex(int index){
        if(index < 0 || index >= size){
            System.out.println("Invalid index");
            return;
        }
        if(index == 0){
            deleteAtHead();
            return;
        }
        if(index == size-1){
            deleteAtTail();
            return;
        }
        Node current = head;
        for(int i = 1; i < index; i++){
            current = current.next;
        }
        current.next = current.next.next;
        size--;
    }
    public boolean search(int data){
        Node current = head;
        for (int i = 0; i <size; i++) {
            if(current.data == data){
                System.out.println(i);
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public void display(){
        Node current = head;
        while(current!=null){
            System.out.print(current.data +" ");
            current = current.next;
        }
        System.out.println();
    }

}
