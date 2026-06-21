class Solution {
    int count=0;
    public int goodNodes(TreeNode root) {
        dfs(root,root.val);
        return count;
    }
    public void dfs(TreeNode root,int max)
    {
        if(root==null)
        return;
        if(root.val>=max)
        {
            count++;
        }
        dfs(root.left,Math.max(root.val,max));
        dfs(root.right,Math.max(root.val,max));
    }
}
