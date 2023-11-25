package leetcode;

public class lec48N {
    public static void main(String[] args) {

    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int row = 0; row < n / 2; row ++ ) {
            for (int col = 0; col < (n + 1) / 2; col ++ ) {
                int t = matrix[row][col];
                matrix[row][col] = matrix[n - col - 1][row];
                matrix[n - col - 1][row] = matrix[n - row - 1][n - col - 1];
                matrix[n - row - 1][n - col - 1] = matrix[col][n - row - 1];
                matrix[col][n - row - 1] = t;
            }
        }
    }
}
