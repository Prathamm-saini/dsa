package  basics.Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/// Queue is Data Structure which follows LIFO/FIFO principle. Last IN Last Out
/// Abstract Data Structure
/// Insertion is happening at the back of Queue and Deletion happens at the beginning\
/// Assume it as a Linked List, whenever you want to delete move the head ahead and when want to insert
/// iterate reach behind the tail move tail to current node used for iterating and point the new tail's tail.next = null
///
/// two pointers/reference var -> Front(first) Rear(last)
/// Queue is an interface in java while stack is a class
///
/// It's simply like a Queue in real world scenario
/// analogy -> Restaurant Line people standing one behind another for their food
/// new people will come from end and the person removed will be the first one only who got their food
/// mostly used in situation when you want to store some results and process some operation and again use the stored value
///
/// DEQUE
/// Where you can insert and remove from both sides
/// insertion and deletion from both front and rear
///



public class Main {
    public static void main(String[] args) throws Exception {
//        // Queue in java
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(1);
//        queue.add(2);
//        queue.add(3);
//        queue.add(4);
//        System.out.println(queue.peek());
//        // In a queue (FIFO), elements are added at the tail and removed from the head.
//        // So, the 'peek()' method returns the element at the front of the queue (the one added first).
//        // This is different from a stack (LIFO), where new elements are added at the top (head)
//        // and removed from the top as well.
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        System.out.println(queue);
//
//        // Deque
//        Deque<Integer> deque = new LinkedList<>();
//        Deque<Integer> deque2 = new ArrayDeque<>(); // array type deque
//        deque.add(1);
//        deque.add(2);
//        deque.addLast(3);
//        deque.addFirst(4);
//        System.out.println(deque);
//        System.out.println(deque.peek());
//        System.out.println(deque.remove());
//        System.out.println(deque);
          CustomQueue customQueue = new CustomQueue();
          customQueue.insert(1);
          customQueue.insert(2);
          customQueue.insert(3);
          System.out.println(customQueue.front());
          System.out.println(customQueue.rear());

          customQueue.display();
          customQueue.remove();
          customQueue.display();

    }
}