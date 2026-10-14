class Pair{
    int first,second;
    public Pair(int first,int second)
    {
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       Map<Integer,Integer> hm=new HashMap<>();
       for(int i=0;i<nums.length;i++)
       {
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
       } 
       PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->y.second-x.second);
       for(Map.Entry<Integer,Integer> st:hm.entrySet())
       {
        pq.add(new Pair(st.getKey(),st.getValue()));
       }
       int[] arr=new int[k];
       int count=0;
       while(k-->0)
       {
        Pair it=pq.remove();
        arr[count++]=it.first;
       }
       return arr;
    }
}
