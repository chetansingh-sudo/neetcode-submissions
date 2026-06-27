class Pair{
    int first,second,third;
    public Pair(int first,int second,int third)
    {
        this.first=first;
        this.second=second;
        this.third=third;
    }
}
class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(vis[i],Integer.MAX_VALUE);
        }
        int[] delrow={-1,0,1,0};
        int[] delcol={0,1,0,-1};
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==0)
                {
                    q.add(new Pair(i,j,0));
                }
            }
        }
        int inf=2147483647;
        while(!q.isEmpty())
        {
            int row=q.peek().first;
            int col=q.peek().second;
            int time=q.peek().third;
            q.remove();
            for(int i=0;i<4;i++)
            {
                int nrow=row+delrow[i];
                int ncol=col+delcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==inf )
                {
                    if(time+1<vis[nrow][ncol])
                    {
                        q.add(new Pair(nrow,ncol,time+1));
                        vis[nrow][ncol]=time+1;
                    }
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==inf)
                {
                    grid[i][j]=vis[i][j];
                }
            }
        }
    }
}
