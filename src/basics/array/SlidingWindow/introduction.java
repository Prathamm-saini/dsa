package basics.array.SlidingWindow;

public class introduction {
    public static void main(String[] args) {
        int[] arr ={-1,1,2,2,3,3,5,5,10};
        System.out.println(constantWindowMaxSum(arr,3));
        System.out.println(longestSubArraySumK(arr,10));
        System.out.println(maxLengthSubArrayWindow(arr,10));
    }
    // questions is  -> maximum sum you can get in an array taking a constant window size
    public static int constantWindowMaxSum(int[] array,int window_size){
        int left = 0;
        int right = window_size-1; // index
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = left; i <=right; i++) {
            sum += array[i];
        }
        max = sum;
        while(right<array.length-1){
            sum -= array[left];
            left++;
            right++;
            sum += array[right];

            max = Math.max(sum,max);
        }
        return max;
    }
    // question -2 ,longest subarray where sum <= k
    // Brute Force approach (Pattern 2)
    public static int longestSubArraySumK(int[] arr,int k){
        int maxLength = 0;
        for (int i = 0; i <arr.length; i++) {
            int sum = 0;
            for (int j = i; j <arr.length; j++) {
                sum += arr[j];
                if(sum<=k){
                    maxLength = Math.max(maxLength,j-i+1);
                }
                if(sum>k){
                    break;
                }
            }
        }
        return maxLength;
    }
    // Sliding window (Pattern 2)
    // left pointer -> shrink // right pointer -> expand
    // This is a Standard Sliding Window with time complexity 0(n+n) not n square as
    // loop depends on right which only moves until 0 to array.length-1
    public static int maxLengthSubArrayWindow(int[] array,int k){
        int mySum = 0;
        int maxLength = 0;
        int left = 0;
        for (int right = 0; right <array.length; right++) {
            mySum += array[right];

            while (mySum>k){
                mySum -= array[left];
                left++;
            }
            maxLength = Math.max(maxLength,right-left+1);
        }
        return maxLength;
    }
    /// Pattern 3
    // find no of subarrays where condition matches (lets for sum ==k)
    // difficult pattern and most difficulty will come when to know to shrink or expand

    ///  one way to solve this -> figure out no of subarrays with sum <= k and no of subarrays with sum<= k-1
    ///  answer will be subtraction of them

    /// Pattern 4
    /// shortest/minimum window
    ///  here just point l and r at array 0 , find the valid window , shrink it and figure out the shortest window


}

