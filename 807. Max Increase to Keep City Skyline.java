class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int sumInitial = 0;
        int sumFinal = 0;
        int cMax[] = new int[n];
        int rMax[] = new int[n];
        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<n ; j++){
              sumInitial+=grid[i][j];
              rMax[i] = Math.max(rMax[i],grid[i][j]);
              cMax[i] = Math.max(cMax[i],grid[j][i]);

            }
        }

        for(int i = 0 ; i < n ; i++){
            for (int j = 0 ; j< n ; j++){
                grid[i][j] = Math.min(rMax[i],cMax[j]);
                sumFinal+=grid[i][j];
            }
        }

        
        return  sumFinal-sumInitial;

    }
}
