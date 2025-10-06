package basics.Stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public ImplementStackUsingQueue() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    public void push(int x) {
        q2.offer(x);
        while(!q1.isEmpty()){
            q2.offer(q1.poll());
        }
        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;
    }
    public int pop(){
        if(q1.isEmpty()){
            return -1;
        }
        return q1.poll();
    }
    public int top(){
        if(q1.isEmpty()){
            return -1;
        }
        return q1.peek();
    }
    public boolean IsEmpty(){
        return q1.isEmpty();
    }
}

class MyStack {
    public static void main(String[] args) {
        ImplementStackUsingQueue stack = new ImplementStackUsingQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.top());
    }
}