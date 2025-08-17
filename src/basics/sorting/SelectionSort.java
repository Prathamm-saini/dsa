package basics.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {5,3,2,1,3};
        // ascending
        System.out.println(Arrays.toString(selectionSortAsc(array)));
        // descending
        System.out.println(Arrays.toString(selectionSortDesc(array)));
    }
    // pick every element as mini one by one check for the minimum element in array in comparison to it
    // get its index, change mini = new smaller element's index , swap for that ith pos with minimal element
    // Time complexity  -> o(n square) best average worst
    // not stable ,
    static int[] selectionSortAsc(int[] array){
        if(array.length <=1){
            return array;
        }
        for (int i = 0; i < array.length-1; i++) {
            int mini = i;
            for (int j = i+1; j < array.length; j++) {
                if(array[j]<array[mini]){
                    mini = j;
                }
            }
            int temp = array[mini];
            array[mini] = array[i];
            array[i] = temp;
        }
        return array;
    }
    static int[] selectionSortDesc(int[] array){
        if(array.length <=1){
            return array;
        }
        for (int i = 0; i < array.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }
            int temp = array[maxIndex];
            array[maxIndex] = array[i];
            array[i] = temp;
        }

        return array;
    }
}
