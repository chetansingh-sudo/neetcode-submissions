class Pair{
    int first,second;
    public Pair(int first,int second)
    {
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int jump(int[] nums) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.first-y.first);
        pq.add(new Pair(0,0));
        int[] vis=new int[nums.length];
        vis[0]=1;
        while(!pq.isEmpty())
        {
            int index=pq.peek().second;
            int dist=pq.peek().first;
            pq.remove();
            if(index==nums.length-1)
            return dist;
            for(int ind=1;ind<=nums[index];ind++)
            {
                if(ind+index<nums.length && vis[ind+index]!=1)
                {
                    System.out.print(ind+index + " ");
                    pq.add(new Pair(dist+1,ind+index));
                    vis[ind+index]=1;
                }
            }
        }
        return -1;
    }
}
