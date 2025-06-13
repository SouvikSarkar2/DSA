class Solution {
    public int majorityElement(int[] nums) {
        int count = 0 ;
        int el = nums[0];
        for(int i = 0 ; i<nums.length ; i++){
            if(nums[i]==el){
                count++;
            }else{
                if(count==1){
                    el=nums[i];
                }else{
                    count--;
                }
            }
        }
        return el;
    }
}
