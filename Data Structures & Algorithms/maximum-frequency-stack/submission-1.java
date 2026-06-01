
class Pair{
    int first,second,third;
    public Pair(int first,int second,int third)
    {
        this.first=first;
        this.second=second;
        this.third=third;
    }
}
class FreqStack {

    PriorityQueue<Pair> pq;
    Map<Integer,Integer> hm;
    int time;
    public FreqStack() {
          pq = new PriorityQueue<>((x, y) -> {
            if (y.first != x.first) return y.first - x.first; // higher freq first
            return y.second - x.second; // if tie, latest pushed first
        });
        hm=new HashMap<>();
    time=0;
    }
    
    public void push(int val) {
        int f=hm.getOrDefault(val,0)+1;
        hm.put(val,f);
       pq.add(new Pair(f,time++,val));
    }
    
    public int pop() {
        
        Pair ans=pq.remove();
        hm.put(ans.third,hm.get(ans.third)-1);
        if(hm.get(ans.third)==0)
        hm.remove(ans.third);
        return ans.third;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */