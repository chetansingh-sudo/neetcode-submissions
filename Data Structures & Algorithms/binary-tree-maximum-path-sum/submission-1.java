class Solution {
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
    public int dfs(TreeNode root)
    {
        if(root==null)
        return 0;
        int left=dfs(root.left);
        int right=dfs(root.right);
        if(left<0)
        left=0;
        if(right<0)
        right=0;
        
        max=Math.max(max,left+right+root.val);
        return Math.max(left,right)+root.val;
    }
}
