

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        dfs(root,0,ans);
        return ans;
    }
    public void dfs(TreeNode root,int level,List<Integer> ans)
    {
        if(root==null)
        return;
        if(level==ans.size())
        {
            ans.add(root.val);
        }
        
        dfs(root.right,level+1,ans);
        
        dfs(root.left,level+1,ans);
    }
}
