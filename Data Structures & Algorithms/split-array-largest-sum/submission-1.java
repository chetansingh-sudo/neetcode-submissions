class Solution {
    public int check(int cap,int[] nums)
    {
        int stu=1;
        int last=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]+last<=cap)
            {
                
                last+=nums[i];

            }
            else{
                stu++;
                last=nums[i];
            }
            
        }
        return stu;
    }
    public int splitArray(int[] nums, int k) {
        
        int low=0;
        int high=0;
        for(int i=0;i<nums.length;i++)
        {
            low=Math.max(low,nums[i]);
            high+=nums[i];
        }
        int ans=-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(check(mid,nums)<=k)
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