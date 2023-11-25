package leetcode;

public class lec74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0, r = matrix.length - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (matrix[mid][0] <= target) l = mid;
            else r = mid - 1;
        }

        int now = l;
        l = 0; r = matrix[now].length - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (matrix[now][mid] <= target) l = mid;
            else r = mid - 1;
        }

        return matrix[now][l] == target;
    }
}
