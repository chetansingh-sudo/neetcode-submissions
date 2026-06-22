class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> imap=new HashMap<>();
        int n=inorder.length;
        for(int i=0;i<inorder.length;i++)
        {
            imap.put(inorder[i],i);
        }
        return dfs(inorder,0,n-1,preorder,0,n-1,imap);
    }
    public TreeNode dfs(int[] inorder,int instart,int inend,int[] preorder,
    int prestart, int preend,HashMap<Integer,Integer> imap)
    {
        if(instart>inend || prestart>preend)
        return null;
        TreeNode root=new TreeNode(preorder[prestart]);
        int nodeForLeft=imap.get(preorder[prestart]);
        int rem=nodeForLeft-instart;
        root.left=dfs(inorder,instart,nodeForLeft-1,preorder,prestart+1,prestart+rem,imap);
        root.right=dfs(inorder,nodeForLeft+1,inend,preorder,prestart+rem+1,preend,imap);
        return root;
    }
}
