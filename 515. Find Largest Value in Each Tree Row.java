
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0 ; i<size ; i++){
                TreeNode curr = q.remove();
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
                max= Math.max(max,curr.val);

            }
            ans.add(max);
            
        } 
        return ans;
    }
}
