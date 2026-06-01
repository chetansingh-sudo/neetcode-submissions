class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null)
        return ans;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int sz=q.size();
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<sz;i++)
            {
                TreeNode curr=q.remove();
                if(curr!=null)
                temp.add(curr.val);
                if(curr.left!=null)
                q.add(curr.left);
                if(curr.right!=null)
                q.add(curr.right);
            }
            ans.add(temp);
        }
        return ans;
    }
}
