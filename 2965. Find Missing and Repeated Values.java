class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int N = n * n;
        int[] count = new int[N + 1];
        int actualSum = 0;
        int repeated = -1;

        // Count occurrences and compute actual sum
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                count[val]++;
                actualSum += val;
                if (count[val] == 2) {
                    repeated = val;
                }
            }
        }

        int expectedSum = N * (N + 1) / 2;
        int missing = expectedSum - (actualSum - repeated);

        return new int[] { repeated, missing };
    }
}
