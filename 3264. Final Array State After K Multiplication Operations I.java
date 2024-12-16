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


//O(nlogn)


class Solution {

    class Pair {
    int value; 
    int index; 

   
    public Pair(int value, int index) {
        this.value = value;
        this.index = index;
    }

}


    public int[] getFinalState(int[] nums, int k, int multiplier) {
         PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.value != b.value) {
                return Integer.compare(a.value, b.value); 
            } else {
                return Integer.compare(a.index, b.index); 
            }
        });
       for(int i = 0 ; i<nums.length ; i++){
        pq.add(new Pair(nums[i],i));
       }
       while(k>0){
        Pair minPair = pq.poll();
        nums[minPair.index]=minPair.value*multiplier;
        pq.add(new Pair(minPair.value*multiplier,minPair.index));
        k--;
       }
        return nums;
    }
}
