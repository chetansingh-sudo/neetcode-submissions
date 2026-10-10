
class Solution {
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max==0?0:max-1;
    }
    public int dfs(TreeNode root)
    {
        if(root==null)
        return 0;
        int left=dfs(root.left);
        int right=dfs(root.right);
        max=Math.max(max,left+right+1);
        return Math.max(left,right)+1;
    }
}
