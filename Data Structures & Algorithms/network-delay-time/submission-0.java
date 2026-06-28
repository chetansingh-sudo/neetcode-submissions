class Pair{
    int first,second;
    public Pair(int first,int second)
    {
        this.first=first;
        this.second=second;
    }
}
class Solution {
  
    public int networkDelayTime(int[][] times, int n, int k) {
        n=n+1;
        int[] dist=new int[n];

        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] e:times)
        {
            adj.get(e[0]).add(new Pair(e[1],e[2]));
        }
        
        Arrays.fill(dist,(int)(1e9));
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->{
            return x.first-y.first;
        });
        
        dist[k]=0;
        pq.add(new Pair(0,k));
        while(!pq.isEmpty())
        {
            int node=pq.peek().second;
            int time=pq.peek().first;
            pq.remove();
            if(time > dist[node]) continue;
            for(int i=0;i<adj.get(node).size();i++)
            {
                int adjNode=adj.get(node).get(i).first;
                int adjTime=adj.get(node).get(i).second;
                if(dist[adjNode]>adjTime+time)
                {
                    dist[adjNode]=time+adjTime;
                    pq.add(new Pair(dist[adjNode],adjNode));
                }
            }

        }
        int max=0;
        for(int i=1;i<=n-1;i++)
        {
            if(dist[i]==(int)(1e9))
            return -1;
            max=Math.max(max,dist[i]);
        }
        return max;
    }
}