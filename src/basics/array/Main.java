package basics.array;

import java.util.Arrays;
import java.util.Scanner;

/// Question -> Store Roll numbers?
/// 1st solution just create variables and store the roll numbers
/// is it optimal if there are thousands of roll numbers? No
///
/// Solution -> Array Data Structure (can store these roll numbers in contagious order)
///  *arrays is used to store similar data types so we can't have strings with int or float or complex etc.
/// ** Internal Implementation of Arrays
///
///  syntax -> int[] arr = new int['arr.size']; or int[] roll = {1,2,3,4,5};
///  int[] arr = new int[5] -> arr is a reference variable pointing to an array object in heap
///    int[] arr; -> declaration of an array (happens at compile time ) , new int[5] (happens at run time)
///      actual memory creation happens with int[] arr = new int[5]; (new keyword creates an array object)
///        int[] -> data type , arr -> reference variable, new int[5]; -> creates an object in heap;
/// arr -> stack memory and from there it will point to array created i.e {1,2,3,4,5}; in heap (array object)
///
///       Assume array object stored in cells [ [1] [2] [3] [4] [5]  ]
///       in many programming languages these are cells are stored in contagious order in memory
///       In Java it all depends on JVM. it may be contagious or may not be contagious
///       heap objects are not contagious in java (array objects are in heap only)
///
/// ** Indexing of Arrays
///  1. 0 based indexing (generally used) 2. 1 based indexing (starts from 1)
///  Indexes ->             0,1,2,3,4
///  array object values -> 1,2,3,4,5
///
/// we can access values of array using these indexes such that arr[0] , arr[1] etc.
/// we can modify the values too using arr[4] = 100;
///
///
/// if you just declare an array and try to access values or print it  -> return the array with default values at every index
///
/// int[] arr;
/// aa = new int[5];
/// sout(arr); [0,0,0,0,0]
///
/// **Default values
/// 0 -> int , 0.0 for float , null for strings, unidentified character for char
///
/// ** What is null in java?
///  null -> special literal of null type
/// we can cast it to but can't assign it
///  we can assign it to Strings though (non-primitive)
/// primitives assigned to null is not allowed as they are stored in stack
///
/// what if you have array of objects ?
/// arr variable stored in stack pointing to uninitialized array objects in heap
/// each particular object is itself an object of type arr[0] reference var , arr[1] reference variable etc.
///
/// Storage of objects in heap
/// String_array will be in stack memory, and it will point to reference obj in heap with objects "aa","bb"... etc. objects aa bb etc.
///
///
/// Passing an array in functions
/// see changeFirstValue function
///
/// ** CONS
///  arrays are of fixed size
///
public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(args)); // empty array args
        int[] a = new int[5];
        int[] b = {1,2,3,4,5};

        // passing an array in functions
        changeFirstValue(b); // we can modify this int arrays because integers are mutable in java
        // while strings are immutable that's why we use
        System.out.println(Arrays.toString(b));
        a = b;
        System.out.println(Arrays.toString(a)); // now a will too to reference var of b in heap
        // such that pointing at same location in heap

        int[] c;
        c = new int[5];
        System.out.println(Arrays.toString(c)); // used .to string method coz otherwise objects directly returns hashcode if accessed

        char[] d;
        d = new char[5];
        System.out.println(Arrays.toString(d));

        String[] e;
        e = new String[5];
        System.out.println(Arrays.toString(e));

        double[] f;
        f = new double[5];
        System.out.println(Arrays.toString(f));

        // Array manual input
        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 5;
        System.out.println(Arrays.toString(arr));

        // using for loop
        int[] brr = new int[5];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i <brr.length; i++) {
            System.out.print("Enter a number at index "+i+" :");
            brr[i] = input.nextInt();
        }
        System.out.println(Arrays.toString(brr));

        String[] strArr = new String[5];
        for (int i = 0; i < strArr.length; i++) {
            System.out.print("Enter a string at index "+i+" :");
            strArr[i] = input.next();
        }
        System.out.println(Arrays.toString(strArr));


        // Traversal
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i]+ " ");
        }
    }
    private static void changeFirstValue(int[] b) {
        b[0] = 1000; // you can create a scanner object and take input too here for 1st value
    }
}
