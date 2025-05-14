//BEATS 20%

public class Solution {

    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> nums = new HashSet<>();
        int n = digits.length;
        // Traverse the indices of three digits
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    // Determine whether it meets the condition of the target even number
                    if (i == j || j == k || i == k) {
                        continue;
                    }
                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if (num >= 100 && num % 2 == 0) {
                        nums.add(num);
                    }
                }
            }
        }
        // Converted to an array sorted in ascending order
        List<Integer> res = new ArrayList<>(nums);
        Collections.sort(res);
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); ++i) {
            result[i] = res.get(i);
        }
        return result;
    }
}

//BEATS 100%

class Solution {
    private int idx;
    public int[] findEvenNumbers(int[] digits) {
        int[] cnt = new int[10];
        for(int d : digits){
            if(cnt[d] < 3) cnt[d]++;
        }
        idx = 0;
        int[] ans = new int[451];
        backtracking(cnt, new int[10], 0, ans);
        return Arrays.copyOf(ans, idx);
    }
    public void backtracking(int[] cnt, int[] count, int num, int[] ans){
        if(num >= 100){
            ans[idx++] = num;
            return;
        }
        for(int i = 0; i < 10; i++){
            if(num == 0 && i == 0) continue;
            if(num > 9 && num < 100 && (i & 1) == 1) continue;
            if(count[i] < cnt[i]){
                count[i]++;
                backtracking(cnt, count, num * 10 + i, ans);
                count[i]--;
            }
        }
    }
}
