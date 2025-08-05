package basics.Stack;
// array based stack implementation
/// Static Stack -> having a default size and implementation is via arrays so it may get full

public class CustomStack {
    private int[] data;
    private static final int  DEFAULT_SIZE = 10;
    private int index = -1;
    /// whenever this is invoked customStack reference/object moves in stack memory pointing to stack object in heap which would be holding array inside of it
    /// so you may say it is similar to int[] arr = new int[]size;
    /// so whenever this is invoked it will create a new array acc to size for stack implementation
    /// if created with a size,[0,0,0,....,0]-> default value 0 stored at every place
    public CustomStack(){
        this(DEFAULT_SIZE);//copy constructor if no size is passed create array of size 10
    }

    public CustomStack(int size){
        this.data = new int[size];
    }
    public boolean isEmpty(){
        return index<0;
    }
    public boolean isFull(){
        return index>=data.length-1;
    }
    public void push(int value){
        if(isFull()){
            return ;
        }
        index++;
        data[index] = value;
        System.out.println("Value pushed to stack: " + value);
    }
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        int value = data[index--];
        System.out.println("Value popped from stack: " + value);
        return value;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        System.out.println("Value peeked from stack: " + data[index]);
        return data[index];
    }
    public void display(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return;
        }
        for(int i=0;i<=index;i++){
            System.out.print(data[i]+" ");
        }
        System.out.println();
    }
    public int size(){
        System.out.print("Stack size is: ");
        return index++;
    }
}

