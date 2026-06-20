

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> pq=new LinkedList<>();
        pq.add(p);
        pq.add(q);
        while(!pq.isEmpty())
        {
            TreeNode left=pq.remove();
            TreeNode right=pq.remove();
            
            if(left==null && right==null)
            continue;
            if(left==null || right==null)
            return false;
            if(left.val!=right.val)
            return false;
            pq.add(left.left);
            pq.add(right.left);
            pq.add(left.right);
            pq.add(right.right);
        } 
        return true;      
    }
}
