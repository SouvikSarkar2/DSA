class Solution {
    public int findMaxFish(int[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length]; 
        int maxFish = 0; 

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!vis[i][j] && grid[i][j] != 0) { 
                    int currentFish = findMaxPath(grid, vis, i, j); 
                    maxFish = Math.max(maxFish, currentFish); 
                }
            }
        }
        return maxFish;
    }

    public int findMaxPath(int[][] grid, boolean[][] vis, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || vis[i][j] || grid[i][j] == 0) {
            return 0; 
        }

        vis[i][j] = true; 
        int fish = grid[i][j]; 

        
        fish += findMaxPath(grid, vis, i + 1, j); 
        fish += findMaxPath(grid, vis, i - 1, j); 
        fish += findMaxPath(grid, vis, i, j + 1);
        fish += findMaxPath(grid, vis, i, j - 1); 

        return fish;
    }
}
