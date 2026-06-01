class Solution {
    public int checkCap(int[] nums,int cap)
    {
        int count=1;
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            if(sum+nums[i]<=cap)
            {
                sum+=nums[i];
            }
            else
            {
                count++;
                sum=nums[i];
            }
        }
        return count;
    }
    public int splitArray(int[] nums, int k) {
        int low=Arrays.stream(nums).boxed().reduce(0,(a,b)->a>b?a:b);
        int high=Arrays.stream(nums).boxed().reduce(0,(a,b)->a+b);
        int ans=-1;
        while(low<=high)
        {
            int mid=(low+high)>>1;
            if(checkCap(nums,mid)<=k)
            {
                ans=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return ans;
    }
}