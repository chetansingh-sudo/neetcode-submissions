class Pair {
    int first;  // frequency
    int second; // timestamp
    int value;

    public Pair(int first, int second, int value) {
        this.first = first;
        this.second = second;
        this.value = value;
    }
}

class FreqStack {

    PriorityQueue<Pair> pq;
    Map<Integer, Integer> hm;
    int time;

    public FreqStack() {
        pq = new PriorityQueue<>((x, y) -> {
            if (y.first != x.first) return y.first - x.first; // higher freq first
            return y.second - x.second; // if tie, latest pushed first
        });

        hm = new HashMap<>();
        time = 0;
    }
    
    public void push(int val) {
        int f = hm.getOrDefault(val, 0) + 1;
        hm.put(val, f);

        pq.add(new Pair(f, time++, val));
    }
    
    public int pop() {
        Pair p = pq.poll();
        int val = p.value;

        hm.put(val, hm.get(val) - 1);
        if (hm.get(val) == 0) hm.remove(val);

        return val;
    }
}
