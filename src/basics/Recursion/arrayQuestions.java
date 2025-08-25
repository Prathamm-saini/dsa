package basics.Recursion;

import java.util.ArrayList;

public class arrayQuestions {
    public static void main(String[] args) {
        int[] array = {1,2,34,5};
        int[] a = {1,2,3,4};
        System.out.println(checkSortedIterative(a));
        System.out.println(checkSortedRecursive(array,0));
        System.out.println(linearSearch(array,34));
        System.out.println(recursiveLinearSearch(array,4,0));

        int[] arr = {2,3,4,2,2,3,2,1,3};
        System.out.println(linearSearchMultipleOutputs(arr,2,0));
    }
    static boolean checkSortedIterative(int[] array){
        for (int i = 1; i <array.length; i++) {
            if (array[i - 1] > array[i]) {
                return false;
            }
        }
        return true;
    }
    static boolean checkSortedRecursive(int[] array,int counter){
        if(counter == array.length){
            return true;
        }
        if(array[counter]>array[counter+1]){
            return false;
        }
        return checkSortedRecursive(array,counter+1);
    }
    static int linearSearch(int[] array,int target){
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }
    static int recursiveLinearSearch(int[] array,int target,int counter){
        if(counter == array.length){
            return -1;
        }
        if(array[counter] == target){
            return counter;
        }
        return recursiveLinearSearch(array,target,counter+1);
    }
    static ArrayList<Integer> linearSearchMultipleOutputs(int[] array,int target,int counter){
        ArrayList<Integer> result = new ArrayList<>();
        if(counter == array.length){
            return new ArrayList<>();
        }
        if(array[counter] == target){
            result.add(counter);
        }
        linearSearchMultipleOutputs(array,target,counter+1);
        return result;
    }
}
