
class Solution {
    int checkCapacity(int[] arr,int cap)
    {
        int days=1;
        int weight=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]+weight<=cap)
            {
                weight+=arr[i];
            }
            else
            {
                days++;
                weight=arr[i];
            }
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
      int max=Arrays.stream(weights).boxed().reduce(0,(a,b)->a>b?a:b);
      int sum=Arrays.stream(weights).boxed().reduce(0,(a,b)->a+b);
     int low=max;
     int high=sum;
     int ans=-1;
     while(low<=high)
     {
        int mid=(low+high)/2;
        if(checkCapacity(weights,mid)<=days)
        {
            ans=mid;
            high=mid-1;
        }
        else
        low=mid+1;
     }
     return ans;
    }
    
}