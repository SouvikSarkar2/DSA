class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode ans = findTree(0,nums.length-1,nums);
        return ans;
    }

    public static TreeNode findTree(int si,int ei,int nums[]){
        if(si>ei){
            return null;
        }
        int max = nums[si];
        int maxIdx = si;
        for(int i = si+1 ; i<=ei ; i++){
            if(nums[i]>nums[maxIdx]){
                maxIdx=i;
            }
            max=Math.max(max,nums[i]);

        }
        TreeNode tree = new TreeNode(max);
        tree.left = findTree(si,maxIdx-1,nums);
        tree.right = findTree(maxIdx+1,ei,nums);
        return tree;
    }
}
