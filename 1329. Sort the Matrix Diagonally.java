import java.util.*;
class Solution {
    public int[][] diagonalSort(int[][] mat) {
        
        for(int i=0;i<mat[0].length;i++){
            sort(mat,0,i);
        }
        for(int i=1;i<mat.length;i++){
            sort(mat,i,0);
        }
        return mat;
    }
    void sort(int [][]mat,int r, int c){
        int values[] = new int[101];
        int row=r;
        int col=c;
        while(col<mat[0].length&&row<mat.length){
            values[mat[row][col]]++;
            row++;
            col++;
        }
        row=r;
        col=c;
        for(int i=1;i<101;i++){
            while(values[i]>0){
                mat[row][col]=i;
                values[i]--;
                row++;
                col++;
            }
       }
    }
}
