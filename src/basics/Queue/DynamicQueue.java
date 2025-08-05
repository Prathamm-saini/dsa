package basics.Queue;

public class DynamicQueue {
    private Node front;
    private Node rear;
    private int size;

    private class Node{
        private int data;
        private Node next;

        public Node(int data){
            this.data = data;
        }
        public Node (int data, Node next){
            this.data = data;
            this.next = next;
        }
    }
    public DynamicQueue(){
        front = null;
        rear = null;
        size = 0;
    }
    public boolean isEmpty(){
        return front==null;
    }
    public void insert(int data){
        if(front == null){
            front = rear = new Node(data);
            size++;
            return;
        }
        Node newNode = new Node(data);
        rear.next = newNode;
        rear = newNode;
        size++;
    }
    public int remove() throws Exception{
        if(isEmpty()){
            throw new Exception("queue is empty");
        }
        int removed = front.data;
        front = front.next;
        size--;
        return removed;
    }
    public int peek() throws Exception{
        if(isEmpty()){
            throw new Exception("queue is empty");
        }
        return front.data;
    }
    public int size(){
        return size;
    }
    public void display(){
        if(isEmpty()){
            System.out.println("queue is empty");
            return;
        }
        Node current = front;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" <- ");
            }
            current = current.next;
        }
        System.out.println();
    }
}
