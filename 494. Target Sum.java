// RECURSION (BEATS 16%)

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int count[] = new int[1];
        findSum(nums,0,0,target,count);
        return count[0];
    }

    public void findSum(int nums[],int sum,int i,int target,int count[]){
        if(i>=nums.length){
            if(sum==target){
                count[0]++;
            }
            return;
        }
        findSum(nums,sum+nums[i],i+1,target,count);
        findSum(nums,sum-nums[i],i+1,target,count);

    }
} 


// DP (BEATS 100%)

class Solution {
    int[] dp;
    public int findTargetSumWays(int[] nums, int target) {
        // use DP
        // assume that we have S1 - S2 = target && S1 + S2 = sum ==> S1 = (target + sum)/2
        // it means that we need to find the number of subsets that have sum = (target + sum)/2
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //System.out.println("target+sum:" + (target+sum));
        if (target > sum || target + sum < 0 || (target+sum)%2 != 0) {
            return 0;
        }
        //System.out.println("---");
        int targetSum = (target + sum)/2;
        // we use DP to represents the number of subset that have sum equals targetSum
        dp = new int[targetSum+1]; 
        dp[0] = 1; // we have at least one way to have sum = 0 as empty subset

        countSubsets(nums, 0, targetSum);
        return dp[targetSum];
    }

    private void countSubsets(int[] nums, int index, int targetSum) {
        if (index == nums.length) {
            return;
        }
        
        for (int j=targetSum; j>=nums[index]; j--) {
            dp[j] += dp[j-nums[index]];
        }
        countSubsets(nums, index+1, targetSum);
    }

   
}
