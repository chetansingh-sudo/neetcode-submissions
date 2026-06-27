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
    public int orangesRotting(int[][] grid) {
        int time=0;
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
                
        
int[][] vis=new int[n][m];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==2)
                {
                    q.add(new Pair(i,j,0));
                    vis[i][j]=1;
                }
                else if(grid[i][j]==1)
                    count++;
            }
        }
        
        int[] delrow={-1,0,1,0};
        int[] delcol={0,1,0,-1};

        while(!q.isEmpty())
        {
            int row=q.peek().first;
            int col=q.peek().second;
            int t=q.peek().third;
            time=Math.max(time,t);
            q.remove();
            for(int i=0;i<4;i++)
            {
                int nrow=row+delrow[i];
                int ncol=col+delcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && vis[nrow][ncol]==0)
                {
                    vis[nrow][ncol]=1;
                    q.add(new Pair(nrow,ncol,t+1));
                    count--;
                }
            }
        }
        if(count!=0)
        return -1;
        return time;
    }
}