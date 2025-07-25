package basics.intro;//package is just a folder

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*
make sure initial letter is capitalized and public
every file that ends with .java extension is a class itself

public means this file/class can be accessible from anywhere - access modifier
class -> blueprint / DS / virtual construct / named group of properties and function
main function is the entry point of the program
main must be public (entry point)

+ class is just a blueprint, you need objects to access its properties and functions
+ static keyword -> using this we can use the class and run this main function inside it without creating
objects. merely a convention
+ void is the return type of this function -> return means whenever this function stops executing it will return something
+ Strings[] args = args array of type string , you can give command line args
+ byte code goes into out folder
+ class files inside src folder
+ javac is a compiler -> it's a file stored at /usr/bin/javac
+ public should be only that class which has the same file name
+ package is a folder in which your java file will be placed
+ package is simply a folder,you can have your own rules and regulation / security needs whenever you want to run something separately
+ first.class file created after running javac first.java created -> bytecode in basics folder see it
+ System , out , 

*/
 public class First {
     // main function of java - initial point
    public static void main(String[] args) {
        System.out.println("Prat");
        int[] array = {1,2,3,4,5};
        int[] arr = {0,0,1,1,1,0,0,1,1,1,0,1,1};
        int[] duplicate = {1,2,2,3,4,4,5};
        int[] binary = {1,0,1,0,1,0,1,0};
        int[] missing = {1,2,3,4,6,7,8,9,10};
        int[] findSingle = {1,2,3,1,5,2,4,3,5};
        int[] sortArray012 = {2,1,0,1,0,1,2,2,1,0,0};
        System.out.println(Arrays.toString(sortArrayOf0_1_2Brute(sortArray012)));
    }
    static int Largest(int[] array){
        int largest = Integer.MIN_VALUE;
        for (int j : array) {
            if (j > largest) {
                largest = j;
            }
        }
        return largest;
    }
    static int secondLargest(int[] array){
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int i = 0; i <array.length; i++) {
            if(array[i]>largest ){
                secondLargest =  largest;
                largest = array[i];
            }else if(array[i]>secondLargest && array[i]<largest){
                secondLargest = array[i];
            }
        }
        return secondLargest;
    }
    static int secondLargestBrute(int[] array){
        int largest = Largest(array);
        int secondLargest = Integer.MIN_VALUE;
        for (int i = 0; i <array.length; i++) {
            if(array[i]>secondLargest && array[i]!=largest){
                secondLargest = array[i];
            }
        }
        return secondLargest;
    }
    static boolean checkSorted(int[] array){
        for (int i = 0; i <array.length; i++) {
            if(array[i]>array[i+1]){
                return false;
            }
        }
        return true;
    }
    static int removeDuplicates(int[] array){
        int i = 0;
        for (int j = 1; j <array.length; j++) {
            if(array[i]!=array[j]){
                i++;
                array[i] = array[j];
            }
        }
        return i+1;
    }
    static void removeDuplicatesBrute(int[] array){
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i <array.length; i++) {
            set.add(array[i]);
        }
        int[] newArray = new int[set.size()];
        int index = 0;
        for (int value:set) {
            newArray[index++] = value;
        }
        System.out.println(Arrays.toString(newArray));
    }
    static int[] leftRotate(int[] array){
        int temp = array[0];
        for (int i =0;i<array.length-1;i++) {
            array[i] = array[i+1];
        }
        array[array.length-1] = temp;
        return array;
    }
    static int[] rightRotate(int[] array){
        int temp = array[array.length-1];
        for (int i = array.length-1; i>0;i--) {
            array[i] = array[i-1];
        }
        array[0] = temp;
        return array;
    }
    static int[] leftRotateByKPlaces(int[] array,int k){
        k = k % array.length;
        int[] temp = new int[k];
        for (int i = 0; i <k; i++) {
            temp[i] = array[i];
        }
        for (int i =k; i <array.length; i++) {
            array[i-k] = array[i];
        }
        for (int i = 0; i < k; i++) {
            array[array.length - k + i] = temp[i];
        }

        return array;

    }
    static int[] rightRotateByKPlaces(int[] array,int k){
        k = k % array.length;
        int[] temp = new int[k];
        for (int i = 0; i <k; i++) {
            temp[i] = array[array.length+i-k];
        }
        for (int i = array.length- 1; i >= k; i--) {
            array[i] = array[i - k];
        }

        for (int i = 0; i < k; i++) {
            array[i] = temp[i];
        }
        return array;
    }
    // rotation by k places -> reversal algorithm
    // intuition is simply rotate the array from 0 to k-1 then rotate k - array.length, then rotate the whole array
    // somehow it does the inplace rotation in o(1) space -> space efficient algo
    static void reversalAlgorithmLeftRotate(int[] array, int k){
        k=k % array.length;
        helperFunc(array,0,k-1);
        helperFunc(array,k,array.length-1);
        helperFunc(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
    static void helperFunc(int[] array,int start,int end){
        while(start<end){
            int temp = array[start];
            array[start] = array[end];
            start++;
            array[end] = temp;
            end--;
        }
    }
    static int[] reversalAlgorithmRightRotate(int[] array, int k){
        k = k % array.length;
        helperFunc(array,0,array.length-1);
        helperFunc(array,0,k-1);
        helperFunc(array,k,array.length-1);
        return array;
    }
    static boolean linearSearch(int[] array,int target){
        for (int i = 0; i <array.length; i++) {
            if(array[i]==target){
                return true;
            }
        }
        return false;
    }
    static int[] moveZeroesToEndBinaryArray(int[] array){
        // time complexity - o(3n)
        int count = 0;
        for (int i = 0; i <array.length; i++) {
            if(array[i]==0){
                count++;
            }
        }
        for (int i = 0; i <array.length-count; i++) {
            array[i] = 1;
        }
        for (int i = array.length-count; i <array.length ; i++) {
            array[i] = 0;
        }
        return array;
    }

    static int[] merge(int[] a,int[] b){
        // it allows duplicates
        int i = 0;
        int j = 0;
        int[] merge = new int[a.length+b.length];
        int index = 0;
        while(i<a.length && j<b.length){
            if(a[i]<b[j]){
                merge[index++] = a[i++];
            }
            else if (a[i]==b[j]){
                merge[index++] = a[i++];
            }
            else if(a[i]>b[j]){
                merge[index++] = b[j++];
            }
        }
        while(i<a.length){
            merge[index++] = a[i++];
        }
        while(j<b.length){
            merge[index++] = b[j++];
        }
        return merge;
    }
    static int missingNumber(int[] array,int n){
        int originalSum = (n*(n+1))/2;
        int calculatedSum = 0;
        for (int i = 0; i <array.length; i++) {
            calculatedSum += array[i];
        }
        System.out.print("Missing Number is ");
        return originalSum - calculatedSum;
    }
    static int missingNumberByXor(int[] array,int n){
        int xorCalculated = 0;
        for (int i = 0; i <array.length; i++) {
            xorCalculated^=array[i];
        }
        int xorOriginal = 0;
        for (int i = 1; i <=n; i++) {
            xorOriginal^=i;
        }
        return xorOriginal^xorCalculated;
    }
    static int[] moveZeroesToEnd(int[] array){
        int j = -1;
        for (int i = 0; i <array.length; i++) {
            if(array[i]==0){
                j = i;
                break;
            }
        }
        for (int i =j+1; i <array.length; i++) {
            if(array[i]!=0){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                j++;
            }
        }
        return array;
    }
    static int[] moveZeroesToStart(int[] array){
        int j = -1;
        for (int i = array.length-1; i>=0 ; i--) {
            if(array[i]==0){
                j=i;
                break;
            }
        }
        for (int i = j-1; i >=0; i--) {
            if(array[i]!=0){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                j--;
            }
        }
        return array;
    }
    static int[] union(int[] a, int[] b) {
        int i = 0, j = 0, index = 0;
        HashSet<Integer> visited = new HashSet<>();
        int[] union = new int[a.length + b.length];

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                if (!visited.contains(a[i])) {
                    visited.add(a[i]);
                    union[index++] = a[i];
                }
                i++;
            } else if (a[i] > b[j]) {
                if (!visited.contains(b[j])) {
                    visited.add(b[j]);
                    union[index++] = b[j];
                }
                j++;
            } else { // a[i] == b[j]
                if (!visited.contains(a[i])) {
                    visited.add(a[i]);
                    union[index++] = a[i];
                }
                i++;
                j++;
            }
        }

        while (i < a.length) {
            if (!visited.contains(a[i])) {
                visited.add(a[i]);
                union[index++] = a[i];
            }
            i++;
        }

        while (j < b.length) {
            if (!visited.contains(b[j])) {
                visited.add(b[j]);
                union[index++] = b[j];
            }
            j++;
        }

        return Arrays.copyOf(union, index);
    }
    static int[] intersection(int[] a , int[] b ){
        int i = 0;
        int j = 0;
        int index = 0;
        int[] intersection = new int[a.length+b.length];
        HashSet<Integer> visited = new HashSet<>();
        while(i<a.length && j<b.length){
            if(a[i]==b[j]){
                if(!visited.contains(a[i])){
                    visited.add(a[i]);
                    intersection[index++] = a[i];
                }
                i++;
                j++;
            }
            else if(a[i]<b[j]){
                i++;
            }
            else if(a[i]>b[j]){
                j++;
            }
        }
        return Arrays.copyOf(intersection, index);
    }
    static int maximumConsecutiveOnes(int[] array){
        int max = 0;
        int count = 0;
        for (int i = 0; i <array.length ; i++) {
            if(array[i]==1){
                count++;
            }else{
                count = 0;
            }
            max = Math.max(count,max);
        }
        return max;
    }
    static int findElementAppearingOnce(int[] array){
        // note in this question all element appears twice
        int result = 0;
        for (int i = 0; i <array.length; i++) {
            result ^= array[i];
        }
        return result;
    }
    static ArrayList<Integer> twoSumBrute(int[] array,int sum){
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i <array.length; i++) {
            for (int j =i+1; j <array.length; j++) {
                if(array[i]+array[j] == sum){
                    result.add(i);
                    result.add(j);
                }
            }
            break;
        }
        return result;
    }
    static void twoSum(int[] array,int sum){
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i <array.length; i++) {
            int compliment = sum - array[i];
            if (set.contains(compliment)) {
                System.out.println("[ " + array[i] + " , " + compliment + " ]");
            }
            set.add(array[i]);
        }
    }
    static int[] sortArrayOf0_1_2Brute(int[] array){
        int count_0 = 0;
        int count_1 = 0;
        int count_2 = 0;
        for (int i = 0; i <array.length; i++) {
            if(array[i] == 0){
                count_0++;
            }
            else if(array[i] == 1){
                count_1++;
            }
            else if(array[i] == 2){
                count_2++;
            }
        }
        for (int i = 0; i <count_0; i++) {
            array[i] = 0;
        }
        for (int i =count_0; i <count_0+count_1; i++) {
            array[i] = 1;
        }
        for (int i = count_0+count_1; i <count_0+count_1+count_2; i++) {
            array[i] = 2;
        }
        return array;
    }
}






