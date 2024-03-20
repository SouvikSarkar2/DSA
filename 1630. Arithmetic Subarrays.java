//Beats 60%

import java.util.*;

class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            result.add(isArithmeticSubarray(nums, l[i], r[i]));
        }
        return result;
    }

    private boolean isArithmeticSubarray(int[] nums, int left, int right) {
        int[] subarray = Arrays.copyOfRange(nums, left, right + 1);
        Arrays.sort(subarray);
        int diff = subarray[1] - subarray[0];
        for (int i = 1; i < subarray.length; i++) {
            if (subarray[i] - subarray[i - 1] != diff) {
                return false;
            }
        }
        return true;
    }
}


//Beats 100%

import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;
class Solution {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n = l.length;
        boolean[] ans = new boolean[n];
        for (int i = 0; i < n; ++i) {
            ans[i] = isArithmetic(nums, l[i],  r[i]);
        }
        return new DangerList(ans, n);
        //return Arrays.asList(ans);
    }

    public boolean isArithmetic(int[] nums, int si, int ei) {
        int max = (int) -1e9;
        int min = (int) 1e9;
        for (int i = si; i <= ei; i++) {
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
        }
        int n = ei - si + 1;
        if ((max - min) % (n - 1) != 0) {
            return false;
        }
        int d = (max - min) / (n - 1);
        if (d == 0) return true;
        boolean[] visited = new boolean[n];
        for (int i = si; i <= ei; i++) {
            int val = nums[i];
            if ((val - min) % d != 0) {
                return false;
            } else {
                int pos = (val - min) / d;
                if (visited[pos]) return false;
                visited[pos] = true;
            }
        }
        return true;
    }


    static class DangerList extends AbstractList<Boolean> implements RandomAccess {

        final boolean[] arr;
        final int size;

        public DangerList(boolean[] arr, int size) {
            this.arr = arr;
            this.size = size;
        }

        public Boolean get(int index) {
            return arr[index];
        }

        public int size() {
            return size;
        }
    }       
}
