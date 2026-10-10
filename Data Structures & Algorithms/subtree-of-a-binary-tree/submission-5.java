class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null && subRoot==null)
        return true;
        if(root==null || subRoot==null)
        {
            return false;
        }
        if(dfs(root,subRoot)==true)
        return true;
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
    public boolean dfs(TreeNode p,TreeNode q)
    {
        if(p==null && q==null)
        return true;
        if(p==null || q==null)
        return false;
        if(p.val!=q.val)
        return false;
        return dfs(p.left,q.left) && dfs(p.right,q.right);
    }
}
