
class Solution {
    
    public int rob(TreeNode root) {
        int[] arr=target(root);
        return Math.max(arr[0],arr[1]);
    }
    public int[] target(TreeNode root)
    {
        if(root==null)
        {
            return new int[2];
        }
        int[] left=target(root.left);
        int[] right=target(root.right);
        int[] arr=new int[2];
        arr[0]=root.val+left[1]+right[1];
        arr[1]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        return arr;
    }
}