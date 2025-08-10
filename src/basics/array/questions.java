package basics.array;

import java.util.Arrays;

public class questions {
    public static void main(String[] args) {
        int[] arr = {3,2,1,4,5};
        swap(arr,0,2); // solution of pass by value in java
        System.out.println(Arrays.toString(arr));
        System.out.println("Maximum is "+maximum(arr));
        int X = 1;
        int Y = 2;
        Swap(X,Y); // won't be swapped as in java its is only pass by value not by reference
        // so here copies of x and y will be swapped not the original x and y passed
        // solution to this is pass it via storing in an array
        System.out.println(X +" " + Y);


        System.out.println(Arrays.toString(reverseArray(arr)));

        intWrapper x = new intWrapper(X);
        intWrapper y = new intWrapper(Y);
        SwapWrapper(x,y);
        System.out.println(x.value +" " + y.value); // swapped
    }
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void Swap(int a, int b ){
        int temp = a;
        a = b;
        b = temp;
    }
    // 2nd way of solving the pass by value problem in java
    // remember using Integer wrapper class won't solve the problem
    // we have to create a custom class and reference the value with this. value
    // also Integer wrapper classes are immutable
    static void SwapWrapper(intWrapper a, intWrapper b){
        int temp = a.value;
        a.value = b.value;
        b.value = temp;
    }
    static int maximum(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int j : arr) {
            if (j > max) {
                max = j;
            }
        }
        return max;
    }
    static int[] reverseArray(int[] arr){
        int i = 0;
        int j = arr.length - 1;
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return arr;
    }
}

class intWrapper{
    int value;
    intWrapper(int value){
        this.value = value;
    }
}