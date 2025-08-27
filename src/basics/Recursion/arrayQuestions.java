package basics.Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class arrayQuestions {
    public static void main(String[] args) {
        int[] array = {10,2,40,12,0,5};
        int[] a = {1,2,3,4};
        System.out.println(checkSortedIterative(a));
        System.out.println(checkSortedRecursive(array,0));
        System.out.println(linearSearch(array,34));
        System.out.println(recursiveLinearSearch(array,4,0));
        int[] arr = {2,3,4,2,2,3,2,1,3};
        System.out.println(linearSearchMultipleOutputs(arr,2,0));
        pattern();
        recursivePattern(5,0);
        triangle();
        triangle(5,0);
        System.out.println();
        System.out.println(Arrays.toString(recursiveBubbleSort(array,array.length-1)));
        System.out.println(Arrays.toString(recursiveSelectionSort(array, 0, 0)));
        System.out.println(Arrays.toString(insertionSort(array)));
        System.out.println(Arrays.toString(recursiveInsertionSort(array, 0)));
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
    static void pattern(){
        for (int i = 0; i <5; i++) {
            for (int j = 0; j <5-i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static void recursivePattern(int row,int col){
        if(row == 0) return;
        if(col < row){
            System.out.print("* ");
            recursivePattern(row,col+1);
        }
        else{
            System.out.println();
            recursivePattern(row-1,0);
        }
    }
    static void triangle(){
        for (int i = 0; i <5; i++) {
            for (int j = 0; j < i +1; j++) {
                System.out.print("*  ");
            }
            System.out.println();
        }
    }
    static void triangle(int row,int col){
        if(row == 0) return;
        if(col < row){
            triangle(row,col+1);
            System.out.print("*");
        }
        else{
            triangle(row-1,0);
            System.out.println();
        }
    }
    static int[] bubbleSort(int[] array){
        boolean flag = false;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j+1]) {
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
    static int[] recursiveBubbleSort(int[] array,int length){
        if(length==1) return array;

        for (int i = 0; i <array.length-1; i++) {
            if(array[i]>array[i+1]){
                int temp = array[i];
                array[i] = array[i+1];
                array[i+1] = temp;
            }
        }
        return recursiveBubbleSort(array,length-1);
    }
    static int[] selectionSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            int mini = i;
            for (int j = i+1; j <array.length; j++) {
                if(array[j]<array[mini]){
                    mini = j;
                }
            }
            int temp = array[i];
            array[i] = array[mini];
            array[mini] = temp;
        }
        return array;
    }
    static int[] recursiveSelectionSort(int[] array,int j,int mini){
        if(j == array.length-1) return array;
        for (int i = j+1; i < array.length; i++) {
            if(array[i]<array[mini]){
                mini = i;
            }
        }
        int temp = array[j];
        array[j] = array[mini];
        array[mini] = temp;
        return recursiveSelectionSort(array,j+1,mini+1);
    }

    static int[] insertionSort(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i+1; j>0 ; j--) {
                if(array[j]<array[j-1]){
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
        return array;
    }
    static int[] recursiveInsertionSort(int[] array,int j){
        if(j == array.length-1) return array;
        for (int i = j+1; i>0; i--) {
            if(array[i]<array[i-1]){
                int temp = array[i];
                array[i] = array[i-1];
                array[i-1] = temp;
            }
        }
        return array;
    }

}
