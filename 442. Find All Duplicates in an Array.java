// O(1) SPACE SOLUTION
//ORIGINAL ARRAY AS COUNT SOLUTION
//BEATS 80%
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
    List<Integer> res = new ArrayList<Integer>();
    for(int i=0 ; i<nums.length ; i++){    
        int num = Math.abs(nums[i]);
        if(nums[num-1]<0){
            res.add(num);
        }
        nums[num-1]=-nums[num-1];

            
    }
    return res;

    }
}


//0(n) SPACE SOLUTION
// BEATS 99%
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
     List<Integer> res = new ArrayList<Integer>();
     int[]count = new int[nums.length+1];
     for(int freq : nums) 
            count[freq]++;

     for( int i =1 ; i <= nums.length ; i++)
    {
        if(count[i] == 2){
            res.add(i);
        }
     }
     return res;  
    }
}
