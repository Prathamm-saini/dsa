package basics.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {5,3,2,1,3};
        System.out.println(Arrays.toString(bubbleSortAsc(array)));
        System.out.println(Arrays.toString(bubbleSortDesc(array)));
    }
    // Time complexity is O(n square) worst and average case
    // best case complexity is O(n)
    static int[] bubbleSortAsc(int[] array){
        if(array.length <=1){
            return array;
        }
        boolean flag = false;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }
        return array;
    }
    static int[] bubbleSortDesc(int[] array){
        if(array.length <=1){
            return array;
        }
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j]<array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }
}
