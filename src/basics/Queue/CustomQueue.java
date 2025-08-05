package basics.Queue;

public class CustomQueue {
    private int[] data;
    // we can have 2 pointers front and rear , we will use only one pointer
    private int ptr = -1;
    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;

    CustomQueue(){
        this(DEFAULT_CAPACITY);
    }
    CustomQueue(int size){
        data = new int[size];
    }
    private boolean isFull(){
        return ptr == data.length - 1;
    }
    public void insert(int value){
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }
        ptr++;
        data[ptr] = value;
        size++;
    }
    public boolean isEmpty(){
        return ptr == -1;
    }
    public int remove() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty");
        }
        int removed = data[0];
        for(int i = 1; i < data.length; i++){
            data[i-1] = data[i];
        }
        ptr--;
        size--;
        return removed;
    }
    public int front() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty");
        }
        return data[0];
    }
    public int rear() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty");
        }
        return data[ptr];
    }
    public void display() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty");
        }
        for(int i = 0; i <=ptr; i++){
            System.out.print("<-"+data[i]);
        }
        System.out.println("<-end");
    }

}
