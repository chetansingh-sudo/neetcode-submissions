class Solution {
    public int cap(int cap,int[] nums)
    {
        int days=1;
        int last=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]+last>cap)
            {
                days++;
                last=nums[i];
            }
            else
            last+=nums[i];
        }
        return days;
    }
    public int splitArray(int[] nums, int k) {
        int low=Arrays.stream(nums).reduce(0,(a,b)->a>b?a:b);
        int high=Arrays.stream(nums).reduce(0,(a,b)->a+b);
        int ans=-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(cap(mid,nums)<=k)
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