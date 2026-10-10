class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
      Queue<TreeNode> first=new LinkedList<>();
      
      first.add(p);
      first.add(q);
      
      while(!first.isEmpty())
      {
        TreeNode curr1=first.remove();
        TreeNode curr2=first.remove();
        if(curr1==null && curr2==null)
        continue;
        if(curr1==null || curr2==null)
        return false;
        if(curr1.val!=curr2.val)
        return false;
            first.add(curr1.left);
            first.add(curr2.left);
            first.add(curr1.right);
            first.add(curr2.right);

      }
      return true;
    }
}
