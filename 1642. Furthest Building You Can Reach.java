//BEATS 100% SOLUTION

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        
        int len=heights.length;
        int maxBricksNeeded=0;
        for (int i=1;i<len;i++)
            if (heights[i]>heights[i-1])
                maxBricksNeeded+=heights[i]-heights[i-1];
        if (bricks>=maxBricksNeeded) return len-1;

        PriorityQueue<Integer> pq = new PriorityQueue<>((i1,i2)->{return i2-i1;});
        int max=0;
        for (int i=max;i<len;i++) {
            max=i;     
            if (i<len-1 && heights[i+1]>heights[i]) {
                int needed=heights[i+1]-heights[i];
                if (bricks<needed) {
                    if (ladders>0) {
                        if (!pq.isEmpty()) {
                            int height=pq.peek();
                            if (height>needed) {
                                pq.poll();
                                bricks+=height-needed;
                                pq.offer(needed);
                            }
                        }
                        ladders--;
                    } else break;                   
                } else {
                    bricks-=needed;
                    pq.offer(needed);                    
                }
            }
        }
        return max;
    }
}




//MY TLE SOLUTION

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int ans = findMaxDis(0,heights,bricks,ladders);
        return ans;
    }

    public static int findMaxDis(int i,int[] heights, int bricks, int ladders){
        if(i==heights.length-1){
            return i;
        }

        if(heights[i+1]-heights[i]<=0){
            return findMaxDis(i+1,heights,bricks,ladders);
        }

        if(ladders == 0 && bricks==0){
            return i;
        }

        if(ladders==0 && heights[i+1]-heights[i]>bricks){
            return i;
        }

        if(ladders==0 && heights[i+1]-heights[i]<=bricks){
            return findMaxDis(i+1,heights,bricks-(heights[i+1]-heights[i]),ladders);
        }

        if(ladders>0 && heights[i+1]-heights[i]>bricks){
            return findMaxDis(i+1,heights,bricks,ladders-1);
        }

        return Math.max(findMaxDis(i+1,heights,bricks-(heights[i+1]-heights[i]),ladders),findMaxDis(i+1,heights,bricks,ladders-1));
        


         
        
    }
}
