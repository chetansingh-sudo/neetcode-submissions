class Tuple{
    int first,second,third;
    public Tuple(int first,int second,int third)
    {
        this.first=first;
        this.second=second;
        this.third=third;
    }
}
class Solution {
    public int swimInWater(int[][] grid) {
       PriorityQueue<Tuple> pq=new PriorityQueue<>((x,y)->{
        return x.first-y.first;
       });
       int n=grid.length;
       int m=grid[0].length;
       int[][] vis=new int[n][m];
       vis[0][0]=1;
        pq.add(new Tuple(0,0,0));
        int[] delrow={-1,0,1,0};
        int[] delcol={0,1,0,-1};
        int max=grid[0][0];
        while(!pq.isEmpty())
        {
            int dist=pq.peek().first;
            int row=pq.peek().second;
            int col=pq.peek().third;
            pq.remove();
            max=Math.max(max,dist);
            if(row==n-1 && col==m-1)
            return max;
            for(int i=0;i<4;i++)
            {
                int nrow=row+delrow[i];
                int ncol=col+delcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0)
                {
                    vis[nrow][ncol]=1;

                    pq.add(new Tuple(grid[nrow][ncol],nrow,ncol));
                }
            }
        }
        return -1;
    }
}