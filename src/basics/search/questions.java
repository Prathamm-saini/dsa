package basics.search;

import java.util.Arrays;

import static java.util.Arrays.binarySearch;

public class questions {
    public static void main(String[] args) {
        int[] array = {2, 3, 5, 9, 14, 16, 18};
        System.out.println(ceil(array, 15));

        char[] letters = {'c', 'd', 'e'};
        System.out.println(smallestChar(letters, 'a'));

        int[] firstAndLast = {2, 2, 4, 5, 7, 7, 7, 8};
        System.out.println(Arrays.toString(firstAndLastPosBrute(firstAndLast, 7)));
        System.out.println(Arrays.toString(firstAndLastPos(firstAndLast, 7)));

        int[] mountainArray = {1,2,3,4,5,3,1};
        System.out.println(peakIndex(mountainArray));

        System.out.println(searchInMountainArray(mountainArray, 2));
    }

    static int ceil(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (array[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (low < array.length) ? array[low] : -1;
    }

    static int floor(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (high >= 0) ? array[high] : -1;
    }

    static int smallestChar(char[] letters, int target) {
        // strictly greater than target
        int low = 0;
        int high = letters.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (letters[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (low < letters.length) ? letters[low] : letters[0];
    }

    // find first and last position of an element in sorted array
    static int[] firstAndLastPosBrute(int[] array, int element) {
        int first = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                first = i;
                break;
            }
        }
        int last = -1;
        for (int i = array.length - 1; i > first; i--) {
            if (array[i] == element) {
                last = i;
                break;
            }
        }
        return new int[]{first, last};
    }

    static int[] firstAndLastPos(int[] array, int element) {
        return new int[]{helperFunc(array, element, true), helperFunc(array, element, false)};
    }

    static int helperFunc(int[] array, int element, boolean first) {
        int low = 0;
        int high = array.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == element) {
                ans = mid;
                if (first) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (array[mid] > element) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    static int peakIndex(int[] array) {
        int low = 0;
        int high = array.length - 1;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(array[mid]>array[mid+1]){ // decreasing slope
                high = mid;
            }
            else{ // increasing slope for array[mid]<array[mid+1]
                low = mid + 1;
            }
        }
        return low;
    }
    static int searchInMountainArray(int[] array, int target) {
        int peakIndex = peakIndex(array);
        if(array[peakIndex] == target) return peakIndex;
        // search in ascending array before peak index
        int index = binarySearchCustom(array,target,0,peakIndex-1,true);
        if(index != -1) return index;
        //search in descending array after peak index
        return binarySearchCustom(array,target,peakIndex+1,array.length-1,false);

    }
    static int binarySearchCustom(int[] array,int target,int low,int high,boolean asc){
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(array[mid] == target){
                return mid;
            }
            if(asc){
                if(array[mid] > target){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            else{
                if(array[mid] > target){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}