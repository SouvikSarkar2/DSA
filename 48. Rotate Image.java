
// n square space

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int ans[][] = new int[n][n];
        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<n ; j++){
                ans[j][n-1-i]=matrix[i][j];
            }
        }
         for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<n ; j++){
                matrix[i][j]=ans[i][j];
            }
        }
    }
}

// 0 n space

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
       for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<n/2 ; j++){
            int temp = matrix[i][j];
           matrix[i][j]=matrix[i][n-j-1];
            matrix[i][n-j-1]=temp;
       }
    }
        
    }
}

