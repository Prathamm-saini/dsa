package basics.array.SlidingWindow;

public class MaximumPoints {
    public static void main(String[] args) {
        int[] arr = {6,2,3,4,7,2,1,7,1};
        // question -> for a window size k calculate maximum points where we can either pick from start or end
        // let k =4 , 6,2,3,4 is allowed from front(only front), 2,1,7,1 is allowed(only back) , 1,6,2,3 allowed (both front back)
        // and similarly all to and fro picks are allowed to calculate maximum sum
        System.out.println(maxPoints(arr,4));
    }
    static int maxPoints(int[] array, int k){
        int leftSum = 0;
        int rightSum = 0;
        int maxSum = 0;
        for (int i = 0; i <k; i++) {
            leftSum += array[i];
        }
        maxSum = leftSum;
        int rightIndex = array.length-1;
        for (int i = k-1; i >=0 ; i--) {
            leftSum -= array[i];
            rightSum += array[rightIndex];
            rightIndex = rightIndex-1;

            maxSum = Math.max(maxSum,rightSum+leftSum);
        }
        return maxSum;
    }
}
