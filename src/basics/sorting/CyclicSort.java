package basics.sorting;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        // works when you have element from 1-N range
        // make a mapping of what correct index should have been
        // observation for element 4 correct index is element-1 = 3
        // similarly same for every element

        int[] array = {5,3,2,4,1};
        System.out.println(Arrays.toString(cyclicSort(array)));

    }
    static int i = 0;
    static int[] cyclicSort(int[] array){
        while (i < array.length-1){
            int correctIndex = array[i] -1;
            if(array[correctIndex] != array[i]){
                int temp = array[correctIndex];
                array[correctIndex] = array[i];
                array[i] = temp;
            }
            else{
                // move i only when element at an index is correct
                i++;
            }
        }
        return array;
    }
}
