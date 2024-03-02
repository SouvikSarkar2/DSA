class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] arr = new int[nums.length];
        int count = 0;
        int k = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < pivot) {
                arr[k++] = nums[i];
            }
            if(nums[i] == pivot) {
                count++;
            }
        }
        for(int i = 0; i < count; i++) {
            arr[k++] = pivot;
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > pivot) {
                arr[k++] = nums[i];
            }
        }
        return arr;
    }
}
