class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int[] row = new int[grid.length];
        int[] col = new int[grid[0].length];
        int r = grid.length;
        int c = grid[0].length;

        for (int i = 0; i < r; i++) {
            int sum = 0;
            for (int j = 0; j < c; j++) {
                sum = sum + grid[i][j];
            }
            row[i] = sum - (r - sum);
        }

        for (int i = 0; i < c; i++) {
            int sum = 0;
            for (int j = 0; j < r; j++) {
                sum = sum + grid[j][i];
            }
            col[i] = sum - (c - sum);
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                grid[i][j] = row[i] + col[j];
            }
        }
        return grid;
    }
}
