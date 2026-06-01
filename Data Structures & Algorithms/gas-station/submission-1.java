class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int g=0;
        int c=0;
        for(int i=0;i<gas.length;i++)
        {
            g+=gas[i];
            c+=cost[i];
        }
        if(c>g)
        return -1;
        int index=-1;
        int extraCost=0;
        for(int i=0;i<gas.length;i++)
        {
            if(gas[i]+extraCost<cost[i])
            {
                index=-1;
                extraCost=0;
            }
            else
            {
                if(index==-1)
                    index=i;
                extraCost+=gas[i]-cost[i];
            }
        }
        return index;
    }
}
