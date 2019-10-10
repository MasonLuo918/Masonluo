package com.masonluo.offer;

public class Ex13 {

    public static int movingCount(int threshold, int row, int col) {
        if (threshold <= 0 || row <= 0 || col <= 0) {
            return 0;
        }
        boolean[] visited = new boolean[row * col];
        int count = movingCount(threshold, row, col, 0, 0, visited);
        return count;
    }

    public static int movingCount(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        int count = 0;
        if (check(threshold, rows, cols, row, col, visited)) {
            visited[row * cols + col] = true;
            count += 1 + movingCount(threshold, rows, cols, row - 1, col, visited);
            count += movingCount(threshold, rows, cols, row, col + 1, visited);
            count += movingCount(threshold, rows, cols, row + 1, col, visited);
            count += movingCount(threshold, rows, cols, row, col - 1, visited);
        }
        return count;
    }

    private static boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && getDigitSum(row) + getDigitSum(col) <= threshold && !visited[row * cols + col]) {
            return true;
        }
        return false;
    }

    private static int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(5, 5, 5));
    }
}
