
class Solution {
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> sorted = new ArrayList<>();
        findPreorder(root,sorted);
        int[] arr = new int[sorted.size()];
        for(int i = 0 ; i<arr.length ; i++){
            arr[i]=sorted.get(i);
        }
        
        return getSubTree(0,arr.length-1,arr);
    }

    private void findPreorder(TreeNode tree,ArrayList<Integer> sorted){
        if(tree==null){
            return;
        }
        
        findPreorder(tree.left,sorted);
        sorted.add(tree.val);
        findPreorder(tree.right,sorted);

    }


    private TreeNode getSubTree(int left,int right,int arr[]){
        if(left>right){
            return null;
        }
        if(left==right){
            return new TreeNode(arr[left]);
        }
        int mid = (left+right)/2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = getSubTree(left,mid-1,arr);
        root.right = getSubTree(mid+1,right,arr);
        return root;

    }
}
