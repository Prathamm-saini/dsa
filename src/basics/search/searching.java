package basics.search;

public class searching {
    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3,3,5, 5, 6, 70};
        System.out.println(lowerBound(sortedArray, 7));
        System.out.println(upperBound(sortedArray, 7));
        System.out.println(searchInsertPosition(sortedArray, 4));
        System.out.println(lastOccurrence(sortedArray,3));
    }

    static boolean linearSearch(int[] array, int target) {
        for (int value : array) {
            if (value == target) {
                return true;
            }
        }
        return false;
    }

    static boolean binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == target) {
                return true;
            } else if (array[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
    static int lowerBound(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        int ans = array.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if(array[mid]>=target){
               ans = mid;
               high = mid - 1;
            }
            else if(array[mid]<target){
                low = mid + 1;
            }
        }
        return ans;
    }
    static int upperBound(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        int ans = array.length;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(array[mid]>target){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
    static int floor(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low+high)/2;
            if(array[mid]<=target){
                ans = array[mid];
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return ans;
    }
    static int ceil(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low+high)/2;
            if(array[mid]>=target){
                ans = array[mid];
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
    static int searchInsertPosition(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low+high)/2;
            if(array[mid] == target){
                return mid;
            }
            if(array[mid]>target){
                high = mid - 1;
            }
            else if(array[mid]<target){
                low = mid + 1;
            }
        }
        return low;
    }
    static int lastOccurrence(int[] array,int target){
        int low = 0;
        int high = array.length-1;
        int ans =-1;
        while(low<=high){
            int mid = low +(high-low)/2;
            if (array[mid] == target) {
                ans = mid;
                low =  mid+1;
            } else if (array[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}