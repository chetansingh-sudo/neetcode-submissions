class Solution {
    public boolean subset(int[] nums,int n,int w,Boolean[][] dp)
    {
        if(w==0)
        return true;
        if(n==0)
        return false;
        if(dp[n][w]!=null)
        return dp[n][w];
        if(nums[n-1]<=w)
        return dp[n][w]=subset(nums,n-1,w-nums[n-1],dp) || subset(nums,n-1,w,dp);
        else
        return subset(nums,n-1,w,dp);

    }
    public boolean canPartition(int[] nums) {
        

        int sum=Arrays.stream(nums).boxed().reduce(0,(x,y)->x+y);
         if(sum%2==1)
        return false;
        sum=sum/2;
       
        Boolean[][] dp=new Boolean[nums.length+1][sum+1];
        for (int i = 0; i < dp.length; i++) {
    Arrays.fill(dp[i], null);
}
        return subset(nums,nums.length,sum,dp);
    }
}
