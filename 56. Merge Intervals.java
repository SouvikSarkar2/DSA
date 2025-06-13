import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
      
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int globalStart = intervals[0][0];
        int globalEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (start <= globalEnd) {
                
                globalEnd = Math.max(globalEnd, end);
            } else {
                
                merged.add(new int[]{globalStart, globalEnd});
                globalStart = start;
                globalEnd = end;
            }
        }

       
        merged.add(new int[]{globalStart, globalEnd});

        return merged.toArray(new int[merged.size()][]);
    }
}
