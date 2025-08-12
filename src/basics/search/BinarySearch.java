package basics.search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] asc = {2,4,6,8,11,12,14,20,36,40};
        int[] desc ={10,9,8,7,6,5,4,3,2,1};
        System.out.println(binarySearchAsc(asc,0,asc.length-1,36));
        System.out.println(binarySearchDesc(desc,0,desc.length-1,10));
    }
    static int binarySearchAsc(int[] asc,int low,int high,int target){
        while(low<=high){
            int mid = low +(high-low)/2;
            if(asc[mid]==target){
                return mid;
            }
            else if(asc[mid]>target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1; // not found
    }
    static int binarySearchDesc(int[] desc,int low,int high,int target){
        while(low<=high){
            int mid = low +(high-low)/2;
            if(desc[mid]==target){
                return mid;
            }
            else if(desc[mid]>target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }
    static int orderAgnosticBinarySearch(int[] array,int target){
        int low = 0;
        int high = array.length-1;

        if(array[low]>array[high]){
            return binarySearchDesc(array,low,high,target);
        }
        return binarySearchAsc(array,low,high,target);
    }
}
