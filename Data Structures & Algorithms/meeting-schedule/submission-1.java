
class Pair{
    int first,second;
    public Pair(int first,int second)
    {
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public boolean canAttendMeetings(List<Interval> list) {
        if(list.size()==0 || list.size()==1)
        return true;
        list.sort((a,b)->a.start-b.start);
        List<Pair> ans=new ArrayList<>();
        int start=list.get(0).start;
        int end=list.get(0).end;   
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i).start>=end)
            {
                ans.add(new Pair(start,end));
                start=list.get(i).start;
                end=list.get(i).end;
            }
        }
        ans.add(new Pair(start,end));
        return list.size()==ans.size();
    }
}
