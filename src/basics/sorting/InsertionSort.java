package basics.sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {5,8,2,4,1};
        System.out.println(Arrays.toString(insertionSort(array)));
    }
    static int[] insertionSort(int[] array){
        if(array.length <=1){
            return array;
        }
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i+1; j > 0; j--) {
                if(array[j]<array[j-1]){
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
                else{
                    break;
                }
            }
        }
        return array;
    }
}
