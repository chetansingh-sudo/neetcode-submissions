class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasCost=Arrays.stream(gas).reduce(0,(a,b)->a+b);
        int totalCost=Arrays.stream(cost).reduce(0,(a,b)->a+b);
        if(totalCost>gasCost)
        return -1;
        int n=gas.length;
        int ind=-1;
        int extra=0;
        for(int i=0;i<n;i++)
        {
            if(extra+gas[i]<cost[i])
            {
                ind=-1;
                extra=0;
            }
            else
            {
                if(ind==-1)
                ind=i;
                extra+=gas[i]-cost[i];
            }
        }
        return ind;
    }
}
