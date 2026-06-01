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
    public int[][] kClosest(int[][] points, int k) {
        int[][] val=new int[k][2];
        List<List<Integer>> ans=new ArrayList<>();
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.first-y.first);
        for(int[] e:points)
        {
            pq.add(new Pair((e[0]*e[0])+(e[1]*e[1]),e[0],e[1]));
        }
        int count=0;
        while(k-->0)
        {
                val[count][0]=pq.peek().second;
                val[count][1]=pq.peek().third;
                pq.remove();
                count++;
        }
        return val;
    }
}