class Solution {
    public int totalCap(int[] arr,int cap)
    {
        int totalDays=1;
        int last=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]+last>cap)
            {
                totalDays++;
                last=arr[i];
            }
            else
            last+=arr[i];
        }
        return totalDays;
    }
    public int shipWithinDays(int[] arr, int days) {
        int low=Arrays.stream(arr).reduce(0,(a,b)->a>b?a:b);
        int high=Arrays.stream(arr).reduce(0,(a,b)->a+b);
        int ans=-1;
        while(low<=high)
        {
            int cap=(low+high)/2;
            if(totalCap(arr,cap)<=days)
            {
                ans=cap;
                high=cap-1;
            }
            else
            low=cap+1;
        }
        return ans;
    }
}