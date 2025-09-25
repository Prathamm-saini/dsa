package basics.BinaryTrees;

import java.util.Scanner;

public class BinaryTree {
    BinaryTree(){}

    private static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
        public Node(int data,Node left,Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    private Node root;
    // Insert
    public void populate(Scanner scanner){
        if(root == null){
            System.out.println("Enter the value of the root node");
            int value = scanner.nextInt();
            root  = new Node(value);
        }
        populate(scanner,root);
    }
    public void populate(Scanner scanner,Node node){
        System.out.println("Do you want to insert at left of "+ node.data+" ");
        boolean left = scanner .nextBoolean();
        if(left){
            System.out.println("Enter the value of the left child of "+ node.data+" ");
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner,node.left);
        }
        System.out.println("Do you want to insert at right of "+ node.data+" ");
        boolean right = scanner .nextBoolean();
        if(right){
            System.out.println("Enter the value of the right child of "+ node.data+" ");
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner,node.right);
        }
    }
    public void display() {
        display(root, 0);
    }

    private void display(Node node, int level) {
        if (node == null) {
            return;
        }
        // Print with indentation based on level
        System.out.println("    ".repeat(level) + node.data);

        // Recursive calls
        display(node.left, level + 1);
        display(node.right, level + 1);
    }
}
