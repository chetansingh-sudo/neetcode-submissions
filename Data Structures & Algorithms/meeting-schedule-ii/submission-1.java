
class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size()==0)
        return 0;
        intervals.sort((a,b)->a.start-b.start);
        PriorityQueue<Interval> pq=new PriorityQueue<>((x,y)->{
            return x.end-y.end;
        });
        pq.add(intervals.get(0));
        for(int i=1;i<intervals.size();i++)
        {
            if(intervals.get(i).start>=pq.peek().end)
            {
                pq.remove();
            }
            pq.add(intervals.get(i));
        }
        return pq.size();
    }
}
