package basics.LinkedList;

///  Limitation of Array and ArrayList
///  1.fix size of array
///  arr-> 1,45,2,5,2 (all stored in contagious memory allocation)
///  to solve this we can use ArrayList (doubles the capacity and restore all elements via loop if filled )
///  problem -> It's still limiting us and not optimized
///
/// solution -> Linked list (stores elements in non-contagious manner)
///  breaks the whole array boxes connected to each other and indexed into single box , all stored at contagious memory in the heap
///
///  stored in heap as sparse boxes in memory stored at non-contagious addresses    45      5
///                                                                      ex-> 1   2     2
/// note -> im referring  element in a box such that 1 in a box
///
///  Linked List ->1->2->45->2->5 each block such that 1 itself is in a node containing the pointer to the next
///   values stored inside a node
///
/// question? then how do they connect if they just sparse in the memory ?
///  using arrows/pointers telling for a particular element next one is at this location
///
/// this box is -> Node
/// every single element knows about the next element only
///
/// Head and Tail (Reference Variable)
/// head -> points to very first node
/// tail -> points to last mode
///
/// Node is of type node itself (box)          class Node{
/// what it contains?                               int value;
/// value                                           Node next; (next node type itself if Node only)
/// next (whom it's pointing to)
///                                             }
/// problem? no indexing
///
/// vauge questions
/// if you want to go to third? point temp to head which is pointing to first run a loop move next and reach the 3rd node
/// if you want to add a node point tail.next to new node and tail to last node done!!
/// what if no tail given? (in lc/cf)
///  run a loop find where node.next is null. if found that's the null
///
///
///
///
///
///

public class main {
    public static void main(String[] args) {
        System.out.println("Singly Linked List");
        LL ll = new LL();
        ll.insertAtHead(3);
        ll.insertAtHead(4);
        ll.insertAtHead(5);
        ll.display();

        ll.insertAtTail(2);
        ll.insertAtTail(1);
        ll.display();

        ll.insertAtAnyIndex(0,2);
        ll.display();

        ll.deleteAtHead();
        ll.display();

        ll.deleteAtTail();
        ll.display();

        ll.deleteAtIndex(2);
        ll.display();

        System.out.println(ll.search(0));
        System.out.println("Displaying in reverse fashion");
        ll.displayReverse();
        System.out.println();

        System.out.println("Doubly Linked List");
        DLL dll = new DLL();
        dll.insertAtHead(3);
        dll.insertAtHead(4);
        dll.display();

        dll.insertAtTail(2);
        dll.insertAtTail(1);
        dll.display();

        dll.insertAtIndex(2,0);
        dll.display();

        dll.deleteAtIndex(2);
        dll.display();

        dll.search(3);
        dll.displayReverseDLL(); // just displays, does not do any in place sorting
        dll.reverseDLL();
        dll.display(); // in place sorting

    }
}
