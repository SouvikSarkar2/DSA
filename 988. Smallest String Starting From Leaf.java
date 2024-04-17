class Solution {
    public String smallestFromLeaf(TreeNode root) {
        StringBuilder smallest = new StringBuilder();
        dfs(root, new StringBuilder(), smallest);
        return smallest.toString();
    }
    
    private void dfs(TreeNode node, StringBuilder path, StringBuilder smallest) {
        if (node == null) return;
        
        
        path.append((char)('a' + node.val));
        
        
        if (node.left == null && node.right == null) {
            String currentString = path.reverse().toString();
            if (smallest.length() == 0 || currentString.compareTo(smallest.toString()) < 0) {
                smallest.setLength(0);
                smallest.append(currentString);
            }
            path.reverse(); 
        }
        
        
        dfs(node.left, path, smallest);
        dfs(node.right, path, smallest);
        
        
        path.setLength(path.length() - 1);
    }
}
