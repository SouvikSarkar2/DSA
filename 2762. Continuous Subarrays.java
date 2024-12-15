//BEATS 100%

class Solution 
{
    public long continuousSubarrays(int[] nums) 
    {
        int right = 0, left = 0;
        int curMin, curMax;
        long windowLen = 0, total = 0;

        // Initialize window with first element
        curMin = curMax = nums[right];

        for (right = 0; right < nums.length; right++) 
        {
            // Update min and max for current window
            curMin = Math.min(curMin, nums[right]);
            curMax = Math.max(curMax, nums[right]);

            // If window condition breaks (diff > 2)
            if (curMax - curMin > 2) 
            {
                // Add subarrays from previous valid window
                windowLen = right - left;
                total += ((windowLen * (windowLen + 1)) / 2);

                // Start new window at current position
                left = right;
                curMin = curMax = nums[right];

                // Expand left boundary while maintaining condition
                while (left > 0 && Math.abs(nums[right] - nums[left - 1]) <= 2) 
                {
                    left--;
                    curMin = Math.min(curMin, nums[left]);
                    curMax = Math.max(curMax, nums[left]);
                }

                // Remove overcounted subarrays if left boundary expanded
                if (left < right) 
                {
                    windowLen = right - left;
                    total -= ((windowLen * (windowLen + 1)) / 2);
                }
            }
        }

        // Add subarrays from final window
        windowLen = right - left;
        total += ((windowLen * (windowLen + 1)) / 2);

        return total;
    }
}


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
