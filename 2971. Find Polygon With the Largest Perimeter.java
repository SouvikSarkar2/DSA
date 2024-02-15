class Solution {
    public long largestPerimeter(int[] nums) {
        long sum = 0 ;
        Arrays.sort(nums);
        for(int i = 0 ; i<nums.length ; i++){
            sum+=nums[i];
        }

        for(int i = nums.length -1 ; i>=0 ; i--){
            if(sum-2*nums[i]>0){
                return sum;
            }
            else{
                sum=sum-nums[i];
            }
        }

        return -1;

    }
}
