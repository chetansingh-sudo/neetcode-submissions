
class Solution {
    List<Integer> ans=new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root,0);
        return ans;
    }
    public void dfs(TreeNode root,int level)
    {
        if(root==null)
        return;
        if(ans.size()==level)
        {
        
            ans.add(root.val);
        }
        dfs(root.right,level+1);
        dfs(root.left,level+1);
    }
}
