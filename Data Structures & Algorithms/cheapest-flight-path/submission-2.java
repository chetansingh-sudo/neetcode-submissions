class Pair{
    int first,second;
    public Pair(int first,int second)
    {
        this.first=first;
        this.second=second;
    }
}
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
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] e:flights)
        {
            adj.get(e[0]).add(new Pair(e[1],e[2]));
            
        }
        int[] cost=new int[n];
        Arrays.fill(cost,(int)(1e9));
        cost[src]=0;
        PriorityQueue<Tuple> pq=new PriorityQueue<>((x,y)->{
            return x.second-y.second;
        });
        pq.add(new Tuple(src,0,0));
        while(!pq.isEmpty())
        {
            int node=pq.peek().first;
            int stop=pq.peek().second;
            int price=pq.peek().third;
            pq.remove();
            for(int i=0;i<adj.get(node).size();i++)
            {
                int adjNode=adj.get(node).get(i).first;
                int adjPrice=adj.get(node).get(i).second;
                if( cost[adjNode]>price+adjPrice && stop<=k)
                {
                    cost[adjNode]=price+adjPrice;
                    pq.add(new Tuple(adjNode,stop+1,cost[adjNode]));
                }
            }
        }
        if(cost[dst]==(int)(1e9))
        return -1;
        return cost[dst];
    }
}
