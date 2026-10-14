class Pair{
    int first,second;
    public Pair(int first,int second)
    {
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<Pair> list=new ArrayList<>();
        for(int[] e:intervals)
        {
            list.add(new Pair(e[0],e[1]));
        }
        list.add(new Pair(newInterval[0],newInterval[1]));
        list.sort((a,b)->a.first-b.first);
        Pair it=list.get(0);
        int start=it.first;
        int end=it.second;
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=1;i<list.size();i++)
        {
            if(list.get(i).first>end)
            {
                ans.add(new ArrayList<>(Arrays.asList(start,end)));
                start=list.get(i).first;
                end=list.get(i).second;
            }
            else
            {
                end=Math.max(end,list.get(i).second);
            }
        }
        ans.add(new ArrayList<>(Arrays.asList(start,end)));
        int[][] arr=new int[ans.size()][2];
        for(int i=0;i<ans.size();i++)
        {
            arr[i][0]=ans.get(i).get(0);
            arr[i][1]=ans.get(i).get(1);
        }
        return arr;
    }
}
