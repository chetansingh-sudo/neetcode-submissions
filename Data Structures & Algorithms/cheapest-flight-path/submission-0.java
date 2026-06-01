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
        List<List<Pair>> adjList=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adjList.add(new ArrayList<>());
        }
        for(int[] e:flights)
        {
            adjList.get(e[0]).add(new Pair(e[1],e[2]));
        }
        PriorityQueue<Tuple> pq=new PriorityQueue<>((x,y)->{
            return x.first-y.first;
        });
        int[] cost=new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[src]=0;
        pq.add(new Tuple(0,0,src));
        while(!pq.isEmpty())
        {
            int stop=pq.peek().first;
            int price=pq.peek().second;
            int node=pq.peek().third;
            pq.remove();
            for(int i=0;i<adjList.get(node).size();i++)
            {
                int adjNode=adjList.get(node).get(i).first;
                int adjPrice=adjList.get(node).get(i).second;
                if(cost[adjNode]>adjPrice+price && stop<=k)
                {
                    cost[adjNode]=adjPrice+price;
                    pq.add(new Tuple(stop+1,cost[adjNode],adjNode));
                }
            }
        }
        return cost[dst]==Integer.MAX_VALUE?-1:cost[dst];


    }
}
