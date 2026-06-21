class Solution {
    int ans=0;
    int count=0;
    public int kthSmallest(TreeNode root, int k) {
         dfs(root,k);
         return ans;
    }
    public void dfs(TreeNode root,int k)
    {
        if(root==null)
        return ;
        dfs(root.left,k);
        count++;
        if(count==k)
        {
            ans=root.val;
            return;
        }
        dfs(root.right,k);
    }
}
