package basics.Recursion;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] a = {8,3,4,12,5,6};
        InPlaceMergeSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
    private static int[] mergeSort(int[] array) {
        if(array.length == 1){
            return array;
        }
        int mid = array.length/2;

        int[] leftArray = mergeSort(Arrays.copyOfRange(array,0,mid));
        int[] rightArray = mergeSort(Arrays.copyOfRange(array,mid,array.length));

        return merge(leftArray,rightArray);
    }
    private static int[] merge(int[] leftArray, int[] rightArray) {
        int[] result = new int[leftArray.length+rightArray.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int index = 0;
        while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
            if (leftArray[leftIndex] <= rightArray[rightIndex]) {
                result[index++] = leftArray[leftIndex++];
            }
            else {
                result[index++] = rightArray[rightIndex++];
            }
        }
        while (leftIndex < leftArray.length) {
            result[index++] = leftArray[leftIndex++];
        }
        while (rightIndex < rightArray.length) {
            result[index++] = rightArray[rightIndex++];
        }
        return result;
    }
    private static void InPlaceMergeSort(int[] array,int start,int end) {
        if(start>=end){
            return ;
        }
        int mid = (start+end)/2;

        InPlaceMergeSort(array,start,mid);
        InPlaceMergeSort(array,mid+1,end);

        InPlaceMerge(array,start,mid,end);
    }
    private static void InPlaceMerge(int[] array,int start,int mid,int end){
        int[] newArray = new int[end-start+1];
        int leftIndex = start;
        int rightIndex = mid+1;
        int index = 0;
        while (leftIndex <= mid && rightIndex <= end){
            if(array[leftIndex]<= array[rightIndex]){
                newArray[index++] = array[leftIndex++];
            }
            else{
                newArray[index++] = array[rightIndex++];
            }
        }
        while (leftIndex <= mid){
            newArray[index++] = array[leftIndex++];
        }
        while (rightIndex <= end){
            newArray[index++] = array[rightIndex++];
        }
        for (int i = 0; i < newArray.length; i++) {
            array[start + i] = newArray[i];
        }
    }
}
