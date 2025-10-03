package basics.Queue;



public class CircularQueue {
    private Node front;
    private Node rear;
    private int size;

    private class Node {
        private int data;
        private Node next;
        public Node(int data) {
            this.data = data;
        }
        public Node(){};
    }
    public CircularQueue() {}
    public boolean isEmpty() {
        return front == null;
    }
    public int size() {
        return size;
    }
    public void enQueue(int data) {
        if(front == null){
            front = rear = new Node(data);
            rear.next = front;
            size++;
            return;
        }
        Node newNode = new Node(data);
        rear.next = newNode;
        rear = newNode;
        rear.next = front;
        size++;
    }
    public int deQueue() throws Exception {
        if(isEmpty()){
            throw new Exception("queue is empty");
        }
        int data = front.data;
        front = front.next;
        rear.next = front;
        size--;
        return data;
    }

}
