package basics.array;

import java.util.Arrays;
import java.util.Scanner;

/// 2D array (matrix) (array of arrays)
///   1 2 3
///   4 5 6
///   7 8 9
///
/// syntax-> int[][] arr = new int[3][]
/// mentioning no of rows is mandatory while declaring
/// 3-> rows next[] empty is for columns.
/// you do not need to specify columns
///
/// Internal Implementation of 2D arrays
/// similar to one d array only
/// with array as variable pointing to these values with brackets in heap
/// specifying no of rows is mandatory because you need to know how many arrays to input
/// rows -> no of arrays inside arrays
/// columns is not mandatory -? you can input the array with any number of elements
/// {
///  1 2 3
///  5 6
///  10
///       };
/// internally its like arrays at an index
///
///
public class multidimensional {
    public static void main(String[] args) {

        int[][] arr = new int[3][3];

        int[][] array ={
                {1,2}, // 0th index
                {3,4}, // 1st index
                {5,6}, // 2nd index
                {7,8}, // 3rd index
                {9,10} // 4th index
        };
        System.out.println(Arrays.deepToString(array));
        System.out.println(Arrays.toString(array[1])); // fetches the value at index 1 return [3,4]
        System.out.println(array[2][0]); // fetches the value at index 2 [which is array inside array [5,6]] and [0] means inside the array element at index 0

        // length of array -> returns no of rows
        System.out.println(array.length); // no of rows
        // 2d array input

        Scanner sc = new Scanner(System.in);
        // outer for loop iterates each row
        // for that particular row filling the elements at each column no is done by column
        // array[row].length -> size of a particular row
        for (int row = 0; row < arr.length; row++){
            for (int col = 0; col < arr[row].length; col++){
                System.out.print("Enter number " + (row ) + "x" + (col) + ":");
                arr[row][col] = sc.nextInt();
            }
        }
        // if you want to create a jagged 2d array such that for every row different number of columns
        // you have to take input for each row and feed it in arr[row].length for columns and take input

        // Output for 2d array
        for (int i = 0; i <arr.length; i++) {
            for (int j = 0; j <arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        // another way
        for (int row = 0; row <arr.length; row++) {
            System.out.println(Arrays.toString(arr[row])); // just access whole index
        }

        for (int[] inst : arr){ // for every array inside array print array
            System.out.println(Arrays.toString(inst));
        }
    }
}
