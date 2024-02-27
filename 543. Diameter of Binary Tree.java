class Solution {
    int result = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return result;
    }

    public int depth(TreeNode node){
        if(node == null) return 0;
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);

        int currrentD = leftDepth + rightDepth;
        result = Math.max(result, currrentD);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
