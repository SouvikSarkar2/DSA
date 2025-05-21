class Solution {
    public void setZeroes(int[][] matrix) {
        boolean zeroPresentInRow[] = new boolean[matrix.length];
        boolean zeroPresentInCol[] = new boolean[matrix[0].length];
        for(int i = 0 ; i<matrix.length ; i++){
            for(int j = 0 ; j<matrix[0].length ; j++){
                if(matrix[i][j]==0){
                    zeroPresentInRow[i]=true;
                    zeroPresentInCol[j]=true;
                }
            }
        }

         for(int i = 0 ; i<matrix.length ; i++){
            for(int j = 0 ; j<matrix[0].length ; j++){
                if(zeroPresentInRow[i] || zeroPresentInCol[j]){
                    matrix[i][j]=0;
                }
            }
        }
        

    }
}
