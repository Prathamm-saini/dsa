package basics.BinaryTrees;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(input);
        tree.display();

    }
}
