//BEATS 64% 
class Solution {
    public int findMaxLength(int[] nums) {
        int left = 0, right = 0, len = nums.length;
        for(int indx = 0; indx < len; indx++){
           if(nums[indx] == 0) 
            nums[indx]  = -1;
        }
        int prefSum = 0;
        Map<Integer, Integer> prefSumIndxMp = new HashMap<>();
        prefSumIndxMp.put(0, -1);
        int maxSubLen = 0;
        for(int indx = 0; indx < len; indx++){
            prefSum += nums[indx];
            if(prefSumIndxMp.containsKey(prefSum - 0)){
                maxSubLen = Math.max(maxSubLen, indx - prefSumIndxMp.get(prefSum - 0));
            }
            if(!prefSumIndxMp.containsKey(prefSum)) prefSumIndxMp.put(prefSum, indx);
        }
        return maxSubLen;
    }
}

//BEATS 100%

class Solution {
    public int findMaxLength(int[] nums) {
        int N = nums.length;
        int[] mp = new int[2*N+2];
        int current = N;
        int result = 0;

        for(int i = 0; i < N; i++) {
            current += (nums[i] << 1) - 1;
            if(current == N) {
                result = i+1;
            }
            else if(mp[current] == 0) {
                mp[current] = i+1;
            }
            else {
                result = Math.max(result, i - mp[current]+1);
            }
        }
        return result;
    }
}
