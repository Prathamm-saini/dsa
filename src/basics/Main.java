package basics;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");
        int[] array = {2, 4, 2, 1, 2};
        Scanner input = new Scanner(System.in);
        boolean continueFlag = true;

        while (continueFlag) {
            System.out.print("Please enter the target element: ");
            int target = input.nextInt();
            twoSum(array, target);

            System.out.print("Do you want to continue y/n - ");
            String in = input.next();
            if (!in.equalsIgnoreCase("y")) {
                continueFlag = false;
            }
        }
        input.close();
    }

    static void twoSum(int[] array, int target) {
        boolean found = false;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == target) {
                    System.out.println("Pair found: " + array[i] + " + " + array[j] + " = " + target);
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("No pairs found.");
        }
    }
}
