class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=Arrays.stream(nums).reduce(0,(a,b)->a+b);
        int req=(target+sum)/2;
        int n=nums.length;
        if(sum + target < 0 || (sum + target) % 2 != 0)
    return 0;
        return dfs(nums,n,req);
    }
    public int dfs(int[] nums,int n,int target)
    {
        if(n == 0)
{
    return target == 0 ? 1 : 0;
}
        if(nums[n-1]<=target)
        {
            return dfs(nums,n-1,target-nums[n-1])+dfs(nums,n-1,target);
        }
        else
        return dfs(nums,n-1,target);
    }
}
