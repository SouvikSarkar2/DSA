//TLE ONE
class Solution {
    public long continuousSubarrays(int[] nums) {
        long count = 0;
        for(int i = 0 ; i<nums.length ; i++){
            for(int j  = i ; j<nums.length ; j++){

                int max = nums[i];
                int min = nums[j];
                for(int k = i ; k<=j ; k++){
                    max=Math.max(max,nums[k]);
                    min=Math.min(min,nums[k]);
                }
                if(Math.abs(max-min)<=2){
                    count++;
                }
               

            }
        }
        return count;
    }
}
