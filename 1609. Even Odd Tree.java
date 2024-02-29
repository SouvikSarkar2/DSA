//Beats 5%

class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        ArrayList<Integer> res = levelOrder(root);
         System.out.println(res);
        boolean even = true;
        int max = -1;
        int min = 10000000;
        for(int i = 0 ; i<res.size() ; i++){
            if(res.get(i)==-1) {
                even=!even;
                System.out.println(even);
                max=-1;
                min=10000000;
                continue;
            }
            if(even){
                if(res.get(i)%2==0){
                    
                    return false;
                }
                if(max>=res.get(i)){
                     
                    return false;
                }
                max = res.get(i);
            }
            else{
                if(res.get(i)%2!=0){
                     
                    return false;
                }
                if(min<=res.get(i)){
                    
                    return false;
                }
                min = res.get(i);
            }
        }
        return true;
    }

    public static ArrayList<Integer> levelOrder(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> ans=new ArrayList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            TreeNode node = q.remove();
            if(node==null){
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                    
                }
                ans.add(-1);
            }
            else{
                ans.add(node.val);
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
        }
        return ans;
    }
}


//Beats 100%

class Solution {
    private int[] h;
    private boolean recur(TreeNode root, int level){
        if(root == null){
            return true;
        }
        if((level & 1) == 0){
            if((root.val & 1) == 0){
                return false;
            }
            if(h[level] == 0){
                h[level] = root.val;
            }else{
                if(h[level] >= root.val){
                    return false;
                }else{
                    h[level] = root.val;
                }
            }
        }else{
            if((root.val & 1) == 1){
                return false;
            }
            if(h[level] == 0){
                h[level] = root.val;
            }else{
                if(h[level] <= root.val){
                    return false;
                }else{
                    h[level] = root.val;
                }
            }
        }
        return recur(root.left, level + 1) && recur(root.right, level + 1);
    }
    public boolean isEvenOddTree(TreeNode root) {
        h = new int[100001];
        return recur(root, 0);
    }
}

