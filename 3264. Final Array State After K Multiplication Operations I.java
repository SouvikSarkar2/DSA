//O(n^2)

class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        while(k>0){
            int min = 0;
            for(int i = 0 ; i<nums.length ; i++){
                if(nums[min]>nums[i]){
                    min=i;
                }
            }
            nums[min]*=multiplier;

            k--;
        }
        return nums;
    }
}
