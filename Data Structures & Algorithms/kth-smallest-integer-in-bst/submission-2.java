class Solution {
    int count=0;
    int ans=0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root,k);
        return ans;
    }
    public void dfs(TreeNode root,int k)
    {
        if(root==null)return;
        dfs(root.left,k);
        
        if(++count==k)
        ans=root.val;
        dfs(root.right,k);
    }
}
