package basics.Stack;

/// Stack is a data structure which follows FIFO/FILO (first in first out)
/// Analogy(real life)
///  It's like stack of plates. people takes the first one out from the top and  when putting the item insert at first/top as well
///
/// example 2 -> functional calls in recursion triggered by main and other recursive calls of other functions stacked on top of it and one by one gets removed from the stack
///  follows First In Fist out / First In Last Out
/// push(element) -> to insert
/// pop() removes the last inserted element such that element which is at the top
///  it is a good practice to return the value which is popped in any data structure not even stack
/// peek()-> returns value of last inserted element
/// isEmpty() -> checks if stack is empty
/// isFull() -> checks if stack is full
///
/// Internally java.util.stack is implemented as array.
/// using array we can create other data structure such as stack,queues,graphs,heaps etc.
/// we can't say its array coz of its internal implementation, and we cannot use it via indexes stuff
/// complexity -> pop() -> o(1) push-> o(1) we ain't traversing so constant
///
/// use cases -> when you want to store answers for long and in many parts and want to use them later on for solving a big problem
public class Main {
    public static void main(String[] args) {
//         generics stack implementation
//        Stack<Integer> stack = new Stack<>();
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        System.out.println(stack);
//        stack.pop();
//        System.out.println(stack.pop());
//        System.out.println(stack);
//        System.out.println(stack.peek());
        ///  custom stack implementation

        CustomStack stack = new CustomStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.display();
        stack.pop();
        stack.pop();
        stack.display();

        int peek =stack.peek();
        System.out.println(peek);

        System.out.println(stack.size());

        System.out.println("Dynamic stack testing");
        DynamicStack stack2 = new DynamicStack();
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        stack2.push(4);
        stack2.push(5);
        stack2.display();

        stack2.pop();
        stack2.display();

        int peek2 = stack2.peek();
        System.out.println("Topmost element is "+peek2);
        System.out.println("Size of stack is "+stack2.size());

    }
}
