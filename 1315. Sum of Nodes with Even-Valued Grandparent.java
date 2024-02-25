class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        int ans[]=new int[1];
        preorder(root,ans);
        return ans[0];
    }

    public static void preorder(TreeNode root,int ans[]){
        if(root==null){
            return ;
        }
        if(root.val%2==0){
            if(root.left!=null){
                if(root.left.left!=null){
                    ans[0]+=root.left.left.val;
                }
                if(root.left.right!=null){
                    ans[0]+=root.left.right.val;
                }
            }
            if(root.right!=null){
if(root.right.left!=null){
                    ans[0]+=root.right.left.val;
                }
                if(root.right.right!=null){
                    ans[0]+=root.right.right.val;
                }
            }
        }
        preorder(root.left,ans);
        preorder(root.right,ans);
    }
}
