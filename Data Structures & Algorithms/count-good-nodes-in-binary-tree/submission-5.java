

class Solution {
    int count=0;
    int max=Integer.MIN_VALUE;
    public int goodNodes(TreeNode root) {
        dfs(root,root.val);
        return count;
    }
    public void dfs(TreeNode root,int val)
    {
        if(root==null)
        return;
        if(root.val>=val)
        {
            count++;
           
        }
            
            dfs(root.left,Math.max(root.val,val));
            dfs(root.right,Math.max(root.val,val));
        
    }
}
