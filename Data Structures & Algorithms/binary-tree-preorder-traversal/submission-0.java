
class Solution {
    List<Integer> ans=new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        dfs(root);
        return ans;
    }
    public void dfs(TreeNode root)
    {
        if(root==null)
        return ;
        ans.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}