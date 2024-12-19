class Solution {
    public int maxChunksToSorted(int[] arr) {
        int max = -1;
        int ans = 0 ;
        for(int i = 0 ; i<arr.length ; i++){
            max = Math.max(arr[i],max);
            if(max==i){
                ans++;
            }
        }
        return ans;
    }
}
