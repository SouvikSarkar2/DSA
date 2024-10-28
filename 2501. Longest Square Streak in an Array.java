class Solution {
    public int longestSquareStreak(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0 ; i<nums.length ; i++ ){
            hm.put(nums[i],1);
        }
        int finalCount = 0 ;
        for(int i = 0 ; i<nums.length ; i++){
            int curr = nums[i];
            if(curr>316){
                continue;
            }
            int count = 0 ;
            while(hm.containsKey(curr*curr)){
                count++;
                curr*=curr;
            }
            finalCount = Math.max(count,finalCount);
            count= 0;
        }
        return finalCount == 0 ? -1 : finalCount+1;
    }
}
