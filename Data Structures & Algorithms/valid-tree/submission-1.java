class Pair{
    int first,second;
    public Pair(int first,int second)
    {
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] e:edges)
        {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        int[] vis=new int[n];
       
                if(dfs(adj,n,vis)==false)
                return false;
                else
                {
                    Arrays.sort(vis);
                    if(vis[0]==0)
                    return false;
                    return true;
                }
            

        
    }
    public boolean dfs(List<List<Integer>> adj,int n,int[] vis)
    {
        
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(0,-1));
        vis[0]=1;
        while(!q.isEmpty())
        {
            int node=q.peek().first;
            int parent=q.peek().second;
            q.remove();
            for(int it:adj.get(node))
            {
                if(vis[it]==0)
                {
                    q.add(new Pair(it,node));
                    vis[it]=1;

                }
                else if(parent!=it)
                {
                    return false;
                }
            }
        }
        return true;
    }
}
