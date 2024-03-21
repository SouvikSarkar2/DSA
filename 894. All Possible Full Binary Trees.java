/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// class Solution {
//     Map<Integer, List<TreeNode>> storeData = new HashMap<>();
//     public List<TreeNode> allPossibleFBT(int n) {
//         List<TreeNode> result = new ArrayList();
//         if (n % 2 == 0) return result;
//         if (storeData.containsKey(n)) return storeData.get(n);
//         if (n == 1) result.add(new TreeNode(0));

//         n-=1;
//         for (int i = 1; i <= n; i+=2) {
//             List<TreeNode> left = allPossibleFBT(i);
//             List<TreeNode> right = allPossibleFBT(n-i);
//             for(TreeNode l: left)
//             {
//                 for(TreeNode r: right)
//                 {
//                     TreeNode root = new TreeNode(0);
//                     root.left = l;
//                     root.right = r;
//                     result.add(root);
//                 }
//             }
//         }
//         storeData.put(n+1, result);

//         return result;
//     }
// }

class Solution {
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode>[] dp = new ArrayList[n + 1];
        return generateTree(n, dp);
    }

    public List<TreeNode> generateTree(int n, List<TreeNode>[] dp) {
        if (dp[n] != null) return dp[n];
        List<TreeNode> result = new ArrayList<>();
        if (n == 1) {
            result.add(new TreeNode(0));
            dp[n] = result;
            return dp[n];
        }

        if (n % 2 == 0) return result;
        for (int i = 1; i < n; i++) {
            List<TreeNode> left = generateTree(i, dp);
            List<TreeNode> right = generateTree(n-i-1, dp);
            for (TreeNode l: left) {
                for (TreeNode r: right) {
                    result.add(new TreeNode(0, l, r));
                }
            }
        } 

        return dp[n] = result;
    }
}
