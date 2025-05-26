class Solution {
    public void nextPermutation(int[] nums) {
       int c = -1;
       for(int i = nums.length-1 ; i>=1 ; i--){
        if(nums[i-1]<nums[i]){
            c = i-1;
            break;
        }
       }
       if(c == -1){
        reverse(nums,0);
        return;
       }
       int d = -1;
       for(int i = nums.length-1 ; i>=c ; i--){
        if(nums[i] > nums[c]){
            d=i;
            break;
        }
       }
        int temp = nums[c];
            nums[c] = nums[d];
            nums[d] = temp;

         reverse(nums,c+1);   
       
       
       }
    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
