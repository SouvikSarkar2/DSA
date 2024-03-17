class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = helper1(intervals, newInterval[0]);
        int right = helper2(intervals, newInterval[1]);
        int len = intervals.length;
        int n = left + 1 + (len - right - 1);
        int[][] result = new int[n][2];
        int index = 0;
        for (int i = 0; i < left; i++) {
            result[index++] = intervals[i];
        }
        int v1 = left >= len ? newInterval[0] : Math.min(newInterval[0], intervals[left][0]);
        int v2 = right < 0 ? newInterval[1] :  Math.max(newInterval[1], intervals[right][1]);
        result[index++] = new int[]{v1, v2};
        for (int i = right + 1; i < len; i++) {
            result[index++] = intervals[i];
        }
        return result;
    }
    // find the first index that intervals[index][1] >= target
    private int helper1(int[][] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid][1] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    // find the largest index that nums[index][0] <= target
    private int helper2(int[][] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid][0] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
