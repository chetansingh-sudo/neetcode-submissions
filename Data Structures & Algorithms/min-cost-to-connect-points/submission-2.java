class Disjoint{
    List<Integer> parent=new ArrayList<>();
    List<Integer> size=new ArrayList<>();
    public Disjoint(int n)
    {
        for(int i=0;i<n;i++)
        {
            parent.add(i);
            size.add(1);
        }
    }
    public int findParent(int node)
    {
        if(node==parent.get(node))
        return node;
        int ulp=findParent(parent.get(node));
        parent.set(node,ulp);
        return ulp;
    }
    public void unionBySize(int u,int v)
    {
        int pu=findParent(u);
        int pv=findParent(v);
        if(pu!=pv)
        {
            if(size.get(pu)>size.get(pv))
            {
                parent.set(pv,pu);
                size.set(pv,size.get(pv)+size.get(pu));
            }
            else
            {
                parent.set(pu,pv);
                size.set(pu,size.get(pv)+size.get(pu));
            }
        }
    }
}
class Tuple{
    int node,adjNode,dist;
    public Tuple(int node,int adjNode,int dist){
        this.node=node;
        this.adjNode=adjNode;
        this.dist=dist;
    }

}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Tuple> pq=new PriorityQueue<>((x,y)->x.dist-y.dist);
        int n=points.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int cost = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                pq.offer(new Tuple(i, j, cost));
            }
        }
        int mst=0;
        Disjoint ds=new Disjoint(n);
        while(!pq.isEmpty())
        {
            int u=pq.peek().node;
            int v=pq.peek().adjNode;
            int d=pq.peek().dist;
            pq.remove();
            if(ds.findParent(u)!=ds.findParent(v))
            {
                mst+=d;
                ds.unionBySize(u,v);
            }
        }
        return mst;
    }
}