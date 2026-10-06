class Pair{
    int first,second;
    public Pair(int first,int second)
    {
        this.first=first;
        this.second=second;
    }
}
class Solution {

    public int eraseOverlapIntervals(int[][] intervals) {
        List<Pair> list=new ArrayList<>();
        for(int[] e:intervals)
        {
            list.add(new Pair(e[0],e[1]));
        }
      
                list.sort((a,b)->a.second-b.second);

        List<List<Integer>> ans=new ArrayList<>();
        Pair it=list.get(0);
        int start=it.first;
        int end=it.second;
        for(int i=1;i<list.size();i++)
        {
            if(list.get(i).first>=end)
            {
                ans.add(new ArrayList<>(Arrays.asList(start,end)));
                start=list.get(i).first;
                end=list.get(i).second;
            }
            
        }
        ans.add(new ArrayList<>(Arrays.asList(start,end)));
        //System.out.println(ans);
        int n=intervals.length;
        return n-ans.size();
    }
}
