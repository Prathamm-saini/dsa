package basics.search;

import java.util.Arrays;

public class BinarySearch2D {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(matrix.length); // no of rows
        System.out.println(matrix[0].length); // no columns

        System.out.println(Arrays.toString(linearSearch(matrix, 8)));
        System.out.println(Arrays.toString(rowColumnMatrix(matrix, 9)));

    }
    static int[] linearSearch(int[][] matrix,int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
    // row wise sorted matric and column wise sorted matrix
    static int[] rowColumnMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix.length - 1;

        while(row < matrix.length && col >= 0){
            if (matrix[row][col] == target) {
                return new int[]{row, col};
            }
            else if(matrix[row][col] > target){
                col --;
            }
            else {
                row ++;
            }
        }
        return new int[]{-1, -1};
    }
    // search in row provided between the columns
    static int[] binarySearch(int[][] matrix, int target,int row,int colStart,int colEnd) {
        while(colStart <= colEnd){
            int mid = colStart + (colEnd - colStart)/2;
            if(matrix[row][mid] == target){
                return new int[]{row,mid};
            }
            else if (matrix[row][mid] < target){
                colStart = mid + 1;
            }
            else {
                colEnd = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }
    // 4 quadrant BS approach for 2d array with time complexity o( log(n) +log(m) )
    static int[] searchSortedMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // If only one row, just do binary search in that row
        if (rows == 1) {
            return binarySearch(matrix, target, 0, 0, cols - 1);
        }

        int rowStart = 0;
        int rowEnd = rows - 1;
        int cMid = cols / 2;

        // Run the loop until 2 rows are remaining
        while (rowStart < rowEnd - 1) { // while more than 2 rows
            int mid = rowStart + (rowEnd - rowStart) / 2;
            if (matrix[mid][cMid] == target) {
                return new int[]{mid, cMid};
            } else if (matrix[mid][cMid] < target) {
                rowStart = mid;
            } else {
                rowEnd = mid;
            }
        }

        // Now we have only 2 rows: rowStart and rowStart + 1 (or rowEnd)
        // Check 4 halves
        if (matrix[rowStart][cMid] == target) return new int[]{rowStart, cMid};
        if (matrix[rowStart + 1][cMid] == target) return new int[]{rowStart + 1, cMid};

        // Search in 1st half
        if (target <= matrix[rowStart][cMid - 1]) {
            return binarySearch(matrix, target, rowStart, 0, cMid - 1);
        }
        // Search in 2nd half
        if (target >= matrix[rowStart][cMid + 1] && target <= matrix[rowStart][cols - 1]) {
            return binarySearch(matrix, target, rowStart, cMid + 1, cols - 1);
        }
        // Search in 3rd half
        if (target <= matrix[rowStart + 1][cMid - 1]) {
            return binarySearch(matrix, target, rowStart + 1, 0, cMid - 1);
        }
        // Search in 4th half
        else {
            return binarySearch(matrix, target, rowStart + 1, cMid + 1, cols - 1);
        }
    }
    // a less optimized but highly workable approach in interviews
    static int[] searchInSorted2D(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;
        int left = 0;
        int right = (row*column)-1;
        while(left<=right){
            int mid = (left+right)/2;
            int mid_index = matrix[mid/column][mid%column];

            if(target == mid_index){
                return new int[]{mid};
            }
            else if(target>mid_index){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return new int[]{-1, -1};
    }

}
