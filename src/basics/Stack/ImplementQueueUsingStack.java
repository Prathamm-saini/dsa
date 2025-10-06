package basics.Stack;


import java.util.Stack;

class ImplementQueueUsingStack {
    Stack<Integer> input;
    Stack<Integer> output;
    public ImplementQueueUsingStack() {
        input = new Stack<>();
        output = new Stack<>();
    }
    public void offer(int x) {
        input.push(x);
    }
    public int poll() {
        shiftStacks();
        return output.pop();
    }
    public int top() {
        shiftStacks();
        return output.peek();
    }
    private void shiftStacks() {
        if(output.isEmpty()){
            while(!input.isEmpty()){
                output.push(input.pop());
            }
        }
    }

}

class MyQueue {
    public static void main(String[] args) {
        ImplementQueueUsingStack queue = new ImplementQueueUsingStack();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.poll());
    }
}