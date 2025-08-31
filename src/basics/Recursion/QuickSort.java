package basics.Recursion;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 2, 1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }
    private static void quickSort(int[] arr,int low,int high){
        if(low>=high){
            return;
        }
        int start = low;
        int end = high;
        /// Better way is to use a random pivot, we can use rand.nextInt() here
        int pivot = arr[(start + end) / 2];

        while(start<=end){
            while(arr[start]<pivot){
                start++;
            }
            while(arr[end]>pivot){
                end--;
            }
            if(start<=end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        quickSort(arr,low,end);
        quickSort(arr,start,high);
    }
}
