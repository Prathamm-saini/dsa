package basics.BinaryTrees.BST;
// BST are ordered Binary Trees called Binary Search Tree.
// order Left side node < current node < Right side node

public class BinarySearchTree {
    BinarySearchTree() {}

    class Node {
        int data;
        Node left;
        Node right;
        int height;

        Node(int data) {
            this.data = data;
        }
        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
        public int getData() {
            return data;
        }
    }
    private Node root;

    // Insertion / Populating the BST in order
    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }
    public boolean isEmpty() {
        return root == null;
    }

}
