class Solution {
    public boolean check(int[] nums,int cap,int k)
    {
        int day=1;
        int last=0;
        for(int i=0;i<nums.length;i++)
        {
            if(last+nums[i]<=cap)
            {
                last+=nums[i];
            }
            else
            {
                day++;
                last=nums[i];
            }
        }
        if(day<=k)
        return true;
        else
        return false;
    }
    public int splitArray(int[] nums, int k) {
       int low=0;
       int high=0;
       for(int i=0;i<nums.length;i++)
       {
        low=Math.max(low,nums[i]);
        high+=nums[i];
       } 
       while(low<high)
       {
            int mid=(low+high)/2;
            if(check(nums,mid, k))
            {
                high=mid;

            }
            else
            low=mid+1;
       }
       return high;
    }
}