class Solution {
    public int check(int[] arr,int cap)
    {
        int count=0;
        for(int i=0;i<arr.length;i++)
        {
            count+=(arr[i]/cap);
            if(arr[i]%cap!=0)
            count++;
        }
        return count;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=Arrays.stream(piles).reduce(0,(a,b)->a>b?a:b);
        int ans=-1;
       
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(check(piles,mid)<=h)
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
