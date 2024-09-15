package problems.binarysearch.medium;

public class Search2DMatrix {
    public static void main(String[] args) {
        int[][] nums = new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(searchMatrixBruteForce(nums, 10));
        System.out.println(searchMatrix(nums, 10));
        System.out.println(searchMatrixOptimal(nums, 10));
    }

    /**
     * Time: O(m*log(n))
     * Space: O(1)
     */
    public static boolean searchMatrixBruteForce(int[][] matrix, int target) {
        for (int[] arr: matrix) {
            int left = 0;
            int right = arr.length - 1;

            while (left <= right) {
                int mid = (left + right) / 2;
                if (target == arr[mid]) {
                    return true;
                } else if (target > arr[mid]) {
                    left = mid + 1;
                } else if (target < arr[mid]) {
                    right = mid - 1;
                }
            }
        }

        return false;
    }

    /**
     * Time: O(log(m*n))
     * Space: O(1)
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (matrix[mid][matrix[0].length - 1] < target) {
                start = mid + 1;
            } else if (matrix[mid][0] > target) {
                end = mid - 1;
            } else {
                break;
            }
        }

        if (start > end) {
            return false;
        }

        int midRow = start + (end - start) / 2;
        int l = 0;
        int r = matrix[midRow].length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target > matrix[midRow][mid]) {
                l = mid + 1;
            } else if (target < matrix[midRow][mid]) {
                r = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }

    /**
     * mid / cols = row number
     * mid % cols = column number
     * Time: O(log(m*n))
     * Space: O(1)
     */
    public static boolean searchMatrixOptimal(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int rowStart = 0;
        int rowEnd = rows * cols - 1;

        while (rowStart <= rowEnd) {
            int mid = rowStart + (rowEnd - rowStart) / 2;
            int midValue = matrix[mid / cols][mid % cols];

            if (midValue == target) {
                return true;
            } else if (target > midValue) {
                rowStart = mid + 1;
            } else {
                rowEnd = mid - 1;
            }
        }

        return false;
    }
}
