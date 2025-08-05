package basics.Stack;



public class DynamicStack{
    private int size;
    private Node top;
    class Node{
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

    public DynamicStack(){
        top = null;
        size = 0;
    }
    // push at head and grow the linked list
    public void push(int data){
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        size++;
    }
    public int pop(){
        if(isEmpty()){
            return -1;
        }
        int popped = top.data;
        top = top.next;
        size--;
        return popped;
    }
    public boolean isEmpty(){
        return top == null;
    }
    public int peek(){
        if(isEmpty()){
            return -1;
        }
        return top.data;
    }
    public int size(){
        return size;
    }
    public void display(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return;
        }
        Node current  = top;
        while(current != null){
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

}
