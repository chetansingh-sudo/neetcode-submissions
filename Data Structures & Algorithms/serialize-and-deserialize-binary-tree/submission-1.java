

public class Codec {

    
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        if(root==null)
        return sb.toString();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode curr=q.remove();
            if(curr==null)
            {
                sb.append("# ");
                continue;
            }
            sb.append(curr.val).append(" ");
            
            
                q.add(curr.left);
          
            
                q.add(curr.right);
            
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString()+" ");
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
       if (data == "") return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] arr = data.split(" ");
            if(arr[0].equals(""))
            return null;
          TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
       
        
        q.add(root);
       
        for(int i=1;i<arr.length;i++)
        {
            TreeNode curr=q.poll();
            if(!arr[i].equals("#"))
            {
                TreeNode left=new TreeNode(Integer.parseInt(arr[i]));
                curr.left=left;
                q.add(left);

            }
            if(!arr[++i].equals("#"))
            {
                TreeNode right=new TreeNode(Integer.parseInt(arr[i]));
                curr.right=right;
                q.add(right);
            }
        }
        return root;
    }
    
}
