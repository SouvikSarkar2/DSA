//BEATS 25%

import java.util.HashMap;


class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int ans = 0;
        int left = 0;
        for(int i = 0 ; i<nums.length ; i++){
            if(hm.containsKey(nums[i])){
               int val = hm.get(nums[i]);
                hm.put(nums[i],++val);
           
            }
            else{
                hm.put(nums[i],1);
            

            }

            while(hm.get(nums[i])>k){
                int v = hm.get(nums[left]);
                hm.put(nums[left],--v);
            

                left++;
           
                
            }

            ans = Math.max(i-left+1,ans);
           
        }
        
        
        
        
        return ans;
    }
    
   
}


//BEATS 100%

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int[] frequencies = new int[max - min + 1];

        int left = 0;
        
        int maxWindow = 0;

        for (int right = 0; right < nums.length; right++) {
            frequencies[nums[right] - min]++;

            while (frequencies[nums[right] - min] > k) {
                frequencies[nums[left] - min]--;

                left++;
            }

            maxWindow = Math.max(maxWindow, right - left + 1);
        }

        return maxWindow;
    }
}
