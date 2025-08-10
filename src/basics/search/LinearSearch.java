package basics.search;
// Linear Search / Blind Search
// move to every index from initial to array.length-1 , if element exists return true or the index
// all depends on implementation
// Time complexity O(n) (how time grows as input grows)

import java.util.Arrays;

// Binary Search (searching in sorted array)
// Its like you want to search in  a dictionary which is in sorted order only
public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(linearSearch(arr,5));
        String[] str = new String[]{"Prat","Sai","Kye","Tyson"};
        System.out.println(linearSearchStrings(str,"Sai"));

        String s = "Prat";
        System.out.println(linearSearchInsideString(s,'P'));

        System.out.println(searchInRange(arr,3,1,3));

        int[][] search = {{1,2},{3,4},{5,6},{7,8}};
        System.out.println(search2D(search,5));
        System.out.println(Arrays.toString(search2D_2(search, 8)));
        System.out.println(maximum(search));
    }
    public static int linearSearch(int[] arr, int target) {
        if(arr.length==0) return -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
    // Linear Search in Strings
    public static boolean linearSearchStrings(String[] str, String target) {
        for(String s : str){
            if(s.equals(target)){
                return true;
            }
        }
        return false;
    }
    public static int linearSearchInsideString(String s, char target) {
        if(s.length()==0) return -1;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==target){
                return i;
            }
        }
        return -1;
        // another way is simply convert the string into a char array and then simple linear search
        //char[] arr = s.toCharArray();
    }
    static int searchInRange(int[] arr, int target,int low,int high) {
        if(low>high) return -1;
        for(int j=low;j<=high;j++){
            if(arr[j]==target){
                return j;
            }
        }
        return -1;
    }
    public static int minimum(int[] arr) {
        if(arr.length==0) return -1;
        int mini =Integer.MAX_VALUE;
        for(int j=0;j<arr.length;j++){
            if(arr[j]<mini){
                mini=arr[j];
            }
        }
        return mini;
    }
    public static boolean search2D(int[][] arr,int target){
        if(arr.length==0) return false;
        for(int i =0;i<arr.length;i++){
            for(int j =0;j<arr[0].length;j++){
                if(arr[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }
    public static int[] search2D_2(int[][] arr, int target){
        if(arr.length==0) return new int[]{-1,-1};
        // you can have jagged array take input of row and traverse depends on you
        for(int j=0;j<arr.length;j++){
            for(int k = 0; k< 2; k++){
                if(arr[j][k] == target){
                    return new int[]{j,k};
                    // initialize outside array brackets with new int[][] {array inside array with this}
                }
            }
        }
        return new int[]{-1,-1};
    }
    public static int maximum(int[][] arr) {
        if(arr.length==0) return -1;
        int max =Integer.MIN_VALUE;
        for(int j=0;j<arr.length;j++){
            for(int k = 0; k< 2; k++){
                if(arr[j][k] > max){
                    max = arr[j][k];
                }
            }
        }
        return max;
    }
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for(int i= 0;i<accounts.length;i++){
            int sum = 0;
            for(int j =0;j<accounts[i].length;j++){
                sum += accounts[i][j];
            }
            max = Math.max(max,sum);
        }
        return max;
    }
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int i =0;i<nums.length;i++){
            int digits = 0;
            while(nums[i]>0){
                digits++;
                nums[i] /= 10;
            }
            if(digits % 2 == 0){
                count++;
            }
        }
        return count;
    }
}
