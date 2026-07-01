class Pair{
  int first,second;
  public Pair(int first,int second)
  {
    this.first=first;
    this.second=second;
  }
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{
          if(a.first==b.first)
          return a.second-b.second;
          return a.first-b.first;
        });
        for(int i=0;i<arr.length;i++)
        {
          int val=Math.abs(arr[i]-x);
          pq.add(new Pair(val,arr[i]));
        }
        List<Integer> ans=new ArrayList<>();
        while(k-->0)
        {
          ans.add(pq.peek().second);
          pq.remove();
        }
        Collections.sort(ans);
        return ans;
    }
}